package com.petplanet.backend.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PetVo {

    @JsonProperty("owner")
    private Integer owner;
    @JsonProperty("pId")
    private Integer pId;
    private String name;
    @JsonProperty("species")
    private Integer species;
    private String type;
    private String age;
    private String weight;
    private String mainPic;

}
