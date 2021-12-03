package com.petplanet.backend.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class AnsForQuestionVo {

    @JsonProperty("qId")
    private Integer qId;
    private String answer;
    private Date when;
    private Boolean confirmed;
    @JsonProperty("likes")
    private Integer likes;
    @JsonProperty("uId")
    private Integer uId;

}
