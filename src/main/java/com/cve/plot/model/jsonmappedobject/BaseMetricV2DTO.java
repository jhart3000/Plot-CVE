package com.cve.plot.model.jsonmappedobject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BaseMetricV2DTO {

  @JsonProperty("cvssV2")
  private CvssV2DTO cvssV2;

  @JsonProperty("severity")
  private String severity;

  @JsonProperty("exploitabilityScore")
  private Object exploitabilityScore;

  @JsonProperty("impactScore")
  private Object impactScore;

  @JsonProperty("acInsufInfo")
  private boolean acInsufInfo;

  @JsonProperty("obtainAllPrivilege")
  private boolean obtainAllPrivilege;

  @JsonProperty("obtainUserPrivilege")
  private boolean obtainUserPrivilege;

  @JsonProperty("obtainOtherPrivilege")
  private boolean obtainOtherPrivilege;

  @JsonProperty("userInteractionRequired")
  private boolean userInteractionRequired;
}
