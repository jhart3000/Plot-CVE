package com.cve.plot.model.jsonmappedobject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
class BaseMetricV3DTO {

  @JsonProperty("cvssV3")
  private CvssV3DTO cvssV3;

  @JsonProperty("exploitabilityScore")
  private Object exploitabilityScore;

  @JsonProperty("impactScore")
  private Object impactScore;
}
