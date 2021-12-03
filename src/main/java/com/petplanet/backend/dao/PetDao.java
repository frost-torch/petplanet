package com.petplanet.backend.dao;

import com.petplanet.backend.pojo.Pet;

import java.util.List;
import java.util.Map;

public interface PetDao {

    Map<String, Object> addPet(Pet pet);

    List<Pet> queryPet(Integer uId, Integer pId);

    List<Pet> queryPet(Integer uId);

    boolean updatePet(Pet pet);

    void delPet(Integer pId);

}
