package com.petplanet.backend.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class OnlinePet {

    private Integer uId;
    private Integer pId;
    private Date when;

    public OnlinePet(Integer uId, Integer pId, Date when) {
        this.uId = uId;
        this.pId = pId;
        this.when = when;
    }

    public OnlinePet() {
    }
}
