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

    public Pet(Integer owner, Integer pId, String name, Integer species, String type, String age, String weight, String mainPic) {
        this.owner = owner;
        this.pId = pId;
        this.name = name;
        this.species = species;
        this.type = type;
        this.age = age;
        this.weight = weight;
        this.mainPic = mainPic;
    }
}
