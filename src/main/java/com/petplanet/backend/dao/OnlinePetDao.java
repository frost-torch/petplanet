package com.petplanet.backend.dao;

import com.petplanet.backend.pojo.OnlinePet;

import java.util.List;

public interface OnlinePetDao {

    Integer addOnlinePet(OnlinePet onlinePet);

    List<OnlinePet> queryOnlinePets(Integer uId);

    boolean delOnlinePet(Integer uId, Integer pId);

}
