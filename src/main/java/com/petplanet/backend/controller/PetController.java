package com.petplanet.backend.controller;

import com.petplanet.backend.pojo.Pet;
import com.petplanet.backend.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/pet")
public class PetController {

    @SuppressWarnings("all")
    @Autowired
    PetService petService;

    @PostMapping("/add")
    public @ResponseBody Map<String, Object> addPet(@RequestBody Pet pet) {
        return petService.addPet(pet);
    }

}
