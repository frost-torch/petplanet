package com.petplanet.backend.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class OnlinePetVo {

    @JsonProperty("uId")
    private Integer uId;
    @JsonProperty("pId")
    private Integer pId;
    private Date when;

}
