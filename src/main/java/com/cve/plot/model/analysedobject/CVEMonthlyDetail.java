package com.cve.plot.model.analysedobject;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CVEMonthlyDetail {
  private int monthValue;
  private CVEBreakdown cveBreakdown;
}
