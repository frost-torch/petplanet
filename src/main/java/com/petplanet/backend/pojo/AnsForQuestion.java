package com.petplanet.backend.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class AnsForQuestion {

    private Integer qId;
    private String answer;
    private Date when;
    private Boolean confirmed;
    private Integer likes;
    private Integer uId;

}
