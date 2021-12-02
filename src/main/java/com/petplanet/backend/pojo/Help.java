package com.petplanet.backend.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 求助信息领域类
 */
@Data
public class Help {

    private Integer hId;
    private String topic;
    private String content;
    private Integer click;
    private Date when;
    private Boolean solved;
    private Integer collected;
    private Integer uId;

}
