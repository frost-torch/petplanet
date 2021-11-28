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

    public User(Integer uId, String name, String mainPic, Integer likes, Integer comments, Integer atNum, String email) {
        this.uId = uId;
        this.name = name;
        this.mainPic = mainPic;
        this.likes = likes;
        this.comments = comments;
        this.atNum = atNum;
        this.email = email;
    }

}
