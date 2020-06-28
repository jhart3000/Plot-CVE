package com.cve.plot.service;

import com.cve.plot.model.analysedobject.CVEBreakdown;
import com.cve.plot.model.analysedobject.CVEMonthlyDetail;
import com.cve.plot.model.analysedobject.CVEYearlyDetail;
import com.cve.plot.model.jsonmappedobject.CVEItemsDTO;
import com.cve.plot.model.jsonmappedobject.ResponseDTO;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.cve.plot.loadjson.LoadJson.loadCVEJsonFromClasspath;
import static java.util.stream.Collectors.toList;

public class CVEAnalysisService {

  private static final String LOW = "low";
  private static final String MEDIUM = "medium";
  private static final String HIGH = "high";
  private static final String CRITICAL = "critical";

  public List<CVEYearlyDetail> analyseCVEJson() throws IOException {
    ResponseDTO response = loadCVEJsonFromClasspath();
    return filterCVEResponse(response);
  }

  private List<CVEYearlyDetail> filterCVEResponse(ResponseDTO mappedResponse) {
    Map<String, List<CVEItemsDTO>> cveByYearList =
        mappedResponse.getCVEItems().stream()
            .filter(item -> Objects.nonNull(item.getImpact().getBaseMetricV2()))
            .collect(Collectors.groupingBy(cveItem -> getYear(cveItem.getPublishedDate())));
    return buildYearlyDetailList(cveByYearList);
  }

  private List<CVEYearlyDetail> buildYearlyDetailList(
      Map<String, List<CVEItemsDTO>> cveByYearList) {

    return cveByYearList.entrySet().stream()
        .sorted(Comparator.comparing(Map.Entry::getKey))
        .map(item -> buildYearlyDetail(item.getValue(), item.getKey()))
        .collect(toList());
  }

  private CVEYearlyDetail buildYearlyDetail(List<CVEItemsDTO> cveItems, String year) {

    List<CVEMonthlyDetail> monthlyList = buildMonthlyDetailList(cveItems);

    return CVEYearlyDetail.builder()
        .year(year)
        .cveBreakdown(buildYearlyBreakdown(monthlyList, cveItems.size()))
        .monthlyDetail(monthlyList)
        .build();
  }

  private CVEBreakdown buildYearlyBreakdown(List<CVEMonthlyDetail> monthlyDetailList, int total) {
    int low = 0;
    int medium = 0;
    int high = 0;
    int critical = 0;
    for (CVEMonthlyDetail item : monthlyDetailList) {
      low = low + item.getCveBreakdown().getLow();
      medium = medium + item.getCveBreakdown().getMedium();
      high = high + item.getCveBreakdown().getHigh();
      critical = critical + item.getCveBreakdown().getCritical();
    }

    return CVEBreakdown.builder()
        .critical(critical)
        .high(high)
        .medium(medium)
        .total(total)
        .low(low)
        .build();
  }

  private List<CVEMonthlyDetail> buildMonthlyDetailList(List<CVEItemsDTO> cveItems) {

    Map<Month, List<CVEItemsDTO>> cveByMonth =
        cveItems.stream()
            .collect(Collectors.groupingBy(cveItem -> getMonth(cveItem.getPublishedDate())));

    List<CVEMonthlyDetail> monthlyDetailList =
        cveByMonth.entrySet().stream()
            .map(item -> buildMonthlyDetail(item.getValue(), item.getKey().getValue()))
            .collect(toList());

    addEmptyMonthObjects(monthlyDetailList);

    return monthlyDetailList.stream()
        .sorted(Comparator.comparing(CVEMonthlyDetail::getMonthValue))
        .collect(toList());
  }

  private void addEmptyMonthObjects(List<CVEMonthlyDetail> monthlyDetailList) {
    for (int i = 1; i <= 12; i++) {
      int finalI = i;
      if (monthlyDetailList.stream().noneMatch(item -> item.getMonthValue() == finalI)) {
        addEmptyMonthObject(monthlyDetailList, i);
      }
    }
  }

  private void addEmptyMonthObject(List<CVEMonthlyDetail> monthlyDetailList, int month) {
    monthlyDetailList.add(
        CVEMonthlyDetail.builder()
            .monthValue(month)
            .cveBreakdown(
                CVEBreakdown.builder().critical(0).high(0).medium(0).low(0).total(0).build())
            .build());
  }

  private CVEMonthlyDetail buildMonthlyDetail(List<CVEItemsDTO> cveItems, int month) {

    int low = 0;
    int medium = 0;
    int high = 0;
    int critical = 0;
    for (CVEItemsDTO item : cveItems) {
      String severity = item.getImpact().getBaseMetricV2().getSeverity();
      if (severity.equalsIgnoreCase(LOW)) {
        low++;
      }
      if (severity.equalsIgnoreCase(MEDIUM)) {
        medium++;
      }
      if (severity.equalsIgnoreCase(HIGH)) {
        high++;
      }
      if (severity.equalsIgnoreCase(CRITICAL)) {
        critical++;
      }
    }

    return CVEMonthlyDetail.builder()
        .monthValue(month)
        .cveBreakdown(
            CVEBreakdown.builder()
                .low(low)
                .medium(medium)
                .high(high)
                .critical(critical)
                .total(low + medium + high + critical)
                .build())
        .build();
  }

  private String getYear(String publishedDate) {
    return String.valueOf(getDate(publishedDate).getYear());
  }

  private Month getMonth(String publishedDate) {
    return getDate(publishedDate).getMonth();
  }

  private LocalDate getDate(String publishedDate) {
    DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm'Z'");
    return LocalDate.parse(publishedDate, inputFormatter);
  }
}
