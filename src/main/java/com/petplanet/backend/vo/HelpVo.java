package com.petplanet.backend.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class HelpVo implements Serializable {

    @JsonProperty("hId")
    private Integer hId;
    private String topic;
    private String content;
    private Integer click;
    private Date when;
    private Boolean solved;
    private Integer collected;
    @JsonProperty("uId")
    private Integer uId;

}
