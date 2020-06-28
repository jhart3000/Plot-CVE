package com.cve.plot.model.analysedobject;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CVEBreakdown {
  private int total;
  private int low;
  private int medium;
  private int high;
  private int critical;
}
