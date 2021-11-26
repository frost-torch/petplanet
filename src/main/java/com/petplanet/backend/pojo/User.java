package com.petplanet.backend.pojo;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class User {

    private Integer uId;
    private String name;
    private String mainPic;
    private Integer likes;
    private Integer comments;
    private Integer atNum;
    private String email;

}
