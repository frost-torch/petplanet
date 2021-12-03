package com.petplanet.backend.controller;

import com.petplanet.backend.pojo.OnlinePet;
import com.petplanet.backend.service.OnlinePetService;
import com.petplanet.backend.vo.OnlinePetVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/onlinepet")
public class OnlinePetController {

    @SuppressWarnings("all")
    @Autowired
    private OnlinePetService onlinePetService;

    @PostMapping
    public @ResponseBody
    Map<String, Object> addOnlinePet(@RequestBody OnlinePetVo requestVo) {

        OnlinePet onlinePet = new OnlinePet();
        onlinePet.setUId(requestVo.getUId());
        onlinePet.setPId(requestVo.getPId());
        onlinePet.setWhen(requestVo.getWhen());

        return onlinePetService.addOnlinePet(onlinePet);
    }

    @GetMapping
    public @ResponseBody List<OnlinePet> getAllOnlinePets(@RequestParam Integer uId) {
        return onlinePetService.queryAllOnlinePets(uId);
    }

    @DeleteMapping
    public @ResponseBody Map<String, Object> delOnlinePet(@RequestParam Integer uId, @RequestParam Integer pId) {
        return onlinePetService.delOnlinePet(uId, pId);
    }

}
