package com.petplanet.backend.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class QuestionVo implements Serializable {

    private Integer qId;
    private String topic;
    private String content;
    @JsonProperty("click")
    private Integer click;
    private Date when;
    private Boolean solved;
    private Integer collected;
    @JsonProperty("uId")
    private Integer uId;

}
