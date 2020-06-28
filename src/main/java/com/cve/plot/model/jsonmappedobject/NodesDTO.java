package com.cve.plot.model.jsonmappedobject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
class NodesDTO {

  @JsonProperty("operator")
  private String operator;

  @JsonProperty("cpe_match")
  private List<CpeMatchDTO> cpeMatch;

  @JsonProperty("children")
  private List<NodesDTO> childrenList;
}
