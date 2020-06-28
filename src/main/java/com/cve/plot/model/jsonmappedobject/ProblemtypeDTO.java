package com.cve.plot.model.jsonmappedobject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
class ProblemtypeDTO {

  @JsonProperty("problemtype_data")
  private List<ProblemtypeDataDTO> problemtypeData;
}
