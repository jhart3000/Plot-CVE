package com.cve.plot.model.jsonmappedobject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
class CvssV3DTO {

  @JsonProperty("version")
  private String version;

  @JsonProperty("vectorString")
  private String vectorString;

  @JsonProperty("attackVector")
  private String attackVector;

  @JsonProperty("attackComplexity")
  private String attackComplexity;

  @JsonProperty("privilegesRequired")
  private String privilegesRequired;

  @JsonProperty("userInteraction")
  private String userInteraction;

  @JsonProperty("scope")
  private String scope;

  @JsonProperty("confidentialityImpact")
  private String confidentialityImpact;

  @JsonProperty("integrityImpact")
  private String integrityImpact;

  @JsonProperty("availabilityImpact")
  private String availabilityImpact;

  @JsonProperty("baseScore")
  private Object baseScore;

  @JsonProperty("baseSeverity")
  private Object baseSeverity;
}
