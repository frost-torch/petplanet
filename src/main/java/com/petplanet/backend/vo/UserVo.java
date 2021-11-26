package com.petplanet.backend.vo;

import com.petplanet.backend.pojo.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
public class UserVo implements Serializable {

    private User user;
    private Integer fans;
    private Integer subs;
    private Integer pubs;
    private String sign;
    private String birthday;

    public UserVo (Integer fans, Integer subs, Integer pubs, String sign, String birthday) {
        this.fans = fans;
        this.subs = subs;
        this.pubs = pubs;
        this.sign = sign;
        this.birthday = birthday;
    }
}
