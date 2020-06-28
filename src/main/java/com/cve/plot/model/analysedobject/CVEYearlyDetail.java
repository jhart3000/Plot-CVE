package com.cve.plot.model.analysedobject;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CVEYearlyDetail {
  private String year;
  private CVEBreakdown cveBreakdown;
  private List<CVEMonthlyDetail> monthlyDetail;
}
