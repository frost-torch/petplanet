package com.petplanet.backend.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Question {

    private Integer qId;
    private String topic;
    private String content;
    private Integer click;
    private Date when;
    private Boolean solved;
    private Integer collected;
    private Integer uId;

}
