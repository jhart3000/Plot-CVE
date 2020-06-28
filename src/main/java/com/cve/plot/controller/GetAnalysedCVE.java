package com.cve.plot.controller;

import com.cve.plot.model.analysedobject.CVEYearlyDetail;
import com.cve.plot.service.CVEAnalysisService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class GetAnalysedCVE {

  @Autowired private CVEAnalysisService service;

  @GetMapping("analysedCVEData")
  @Operation(
      summary = "Returns the analysed data from the CVE.json file",
      description =
          "This api will retrieve the CVE data from a json file located in the repositories resources and it will filter through it to create a more refined json response. "
              + "This refined response will give a break down of the severity of the cves published per year and per month of each year also")
  public List<CVEYearlyDetail> getAnalysedCVEData() throws IOException {
    return service.analyseCVEJson();
  }
}
