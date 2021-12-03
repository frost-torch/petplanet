package com.petplanet.backend.controller;

import com.petplanet.backend.pojo.Pet;
import com.petplanet.backend.service.PetService;
import com.petplanet.backend.vo.PetVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/query")
    public @ResponseBody
    List<Pet> queryPet(@RequestParam Integer uId, @RequestParam Integer pId) {
        return petService.queryPet(uId, pId);
    }

    @PostMapping("/update")
    public @ResponseBody Map<String, Object> updatePet(@RequestBody PetVo requestVo) {

        Pet pet = new Pet(
                requestVo.getOwner(),
                requestVo.getPId(),
                requestVo.getName(),
                requestVo.getSpecies(),
                requestVo.getType(),
                requestVo.getAge(),
                requestVo.getWeight(),
                requestVo.getMainPic()
        );

        return petService.updatePet(pet);
    }

    @DeleteMapping("/del")
    public @ResponseBody Map<String, Object> delPet(@RequestParam Integer pId) {
        return petService.delPet(pId);
    }

}
