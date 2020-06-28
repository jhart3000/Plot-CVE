package com.cve.plot.model.jsonmappedobject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
class ReferencesDTO {

  @JsonProperty("reference_data")
  private List<ReferenceDataDTO> referenceData;
}
