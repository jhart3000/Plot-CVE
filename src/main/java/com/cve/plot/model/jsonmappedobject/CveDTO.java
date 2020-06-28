package com.cve.plot.model.jsonmappedobject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
class CveDTO {

  @JsonProperty("data_type")
  private String dataType;

  @JsonProperty("data_format")
  private String dataFormat;

  @JsonProperty("data_version")
  private String dataVersion;

  @JsonProperty("CVE_data_meta")
  private CVEDataMetaDTO cVEDataMeta;

  @JsonProperty("problemtype")
  private ProblemtypeDTO problemtype;

  @JsonProperty("references")
  private ReferencesDTO references;

  @JsonProperty("description")
  private DescriptionListDTO desscriptionList;
}
