package com.cve.plot.model.jsonmappedobject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CVEItemsDTO {

  @JsonProperty("cve")
  private CveDTO cve;

  @JsonProperty("configurations")
  private ConfigurationsDTO configurations;

  @JsonProperty("impact")
  private ImpactDTO impact;

  @JsonProperty("publishedDate")
  private String publishedDate;

  @JsonProperty("lastModifiedDate")
  private String lastModifiedDate;
}
