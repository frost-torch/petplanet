package com.petplanet.backend.pojo;

import lombok.Data;

@Data
public class User {

    private Integer id;
    private String name;
    private String main_pic;
    private Integer likes;
    private Integer comments;
    private Integer at_num;

}
