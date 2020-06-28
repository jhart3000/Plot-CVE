package com.cve.plot.model.jsonmappedobject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
class ConfigurationsDTO {

  @JsonProperty("CVE_data_version")
  private String cVEDataVersion;

  @JsonProperty("nodes")
  private List<NodesDTO> nodes;
}
