package com.cve.plot.model.jsonmappedobject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ImpactDTO {

  @JsonProperty("baseMetricV2")
  private BaseMetricV2DTO baseMetricV2;

  @JsonProperty("baseMetricV3")
  private BaseMetricV3DTO baseMetricV3;
}
