package com.petplanet.backend.service;

import com.petplanet.backend.dao.PetDao;
import com.petplanet.backend.pojo.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PetService {

    @SuppressWarnings("all")
    @Autowired
    PetDao petDao;

    public Map<String, Object> addPet(Pet pet) {
        return petDao.addPet(pet);
    }

}
