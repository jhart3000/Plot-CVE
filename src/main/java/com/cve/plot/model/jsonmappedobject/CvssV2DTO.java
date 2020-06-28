package com.cve.plot.model.jsonmappedobject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
class CvssV2DTO {

  @JsonProperty("version")
  private String version;

  @JsonProperty("vectorString")
  private String vectorString;

  @JsonProperty("accessVector")
  private String accessVector;

  @JsonProperty("accessComplexity")
  private String accessComplexity;

  @JsonProperty("authentication")
  private String authentication;

  @JsonProperty("confidentialityImpact")
  private String confidentialityImpact;

  @JsonProperty("integrityImpact")
  private String integrityImpact;

  @JsonProperty("availabilityImpact")
  private String availabilityImpact;

  @JsonProperty("baseScore")
  private Object baseScore;
}
