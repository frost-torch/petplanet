package com.petplanet.backend.dao;

import com.petplanet.backend.pojo.Pet;

import java.util.Map;

public interface PetDao {

    Map<String, Object> addPet(Pet pet);

}
