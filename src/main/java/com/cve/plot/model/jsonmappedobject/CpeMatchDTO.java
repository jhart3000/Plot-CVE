package com.cve.plot.model.jsonmappedobject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
class CpeMatchDTO {

  @JsonProperty("vulnerable")
  private boolean vulnerable;

  @JsonProperty("cpe23Uri")
  private String cpe23Uri;

  @JsonProperty("versionStartIncluding")
  private String versionStartIncluding;

  @JsonProperty("versionEndExcluding")
  private String versionEndExcluding;

  @JsonProperty("versionEndIncluding")
  private String versionEndIncluding;

  @JsonProperty("versionStartExcluding")
  private String versionStartExcluding;
}
