package com.cve.plot.model.jsonmappedobject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
class DescriptionDTO {

  @JsonProperty("lang")
  private String lang;

  @JsonProperty("value")
  private String value;
}
