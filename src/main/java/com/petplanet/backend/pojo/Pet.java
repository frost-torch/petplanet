package com.petplanet.backend.pojo;

import lombok.Data;

/**
 * 宠物领域类
 */
@Data
public class Pet {

    private Integer owner;
    private Integer pId;
    private String name;
    private Integer species;
    private String type;
    private String age;
    private String weight;
    private String mainPic;

}
