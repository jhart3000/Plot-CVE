package com.cve.plot.model.jsonmappedobject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
class CVEDataMetaDTO {

  @JsonProperty("ID")
  private String iD;

  @JsonProperty("ASSIGNER")
  private String aSSIGNER;
}
