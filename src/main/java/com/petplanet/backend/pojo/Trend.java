package com.petplanet.backend.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Trend {

    private Integer tId;
    private String topic;
    private String content;
    @JsonProperty("private")
    private Boolean pri;
    private Integer likes;
    private Integer pId;
    private Integer uId;

}
