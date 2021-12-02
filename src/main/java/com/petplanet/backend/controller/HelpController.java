package com.petplanet.backend.controller;

import com.petplanet.backend.pojo.Help;
import com.petplanet.backend.service.HelpService;
import com.petplanet.backend.vo.HelpVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/help")
public class HelpController {

    @SuppressWarnings("all")
    @Autowired
    private HelpService helpService;

    @PostMapping("/pub")
    public @ResponseBody
    Map<String, Object> addHelp(@RequestBody HelpVo requestVo) {

        Help help = new Help();
        help.setTopic(requestVo.getTopic());
        help.setContent(requestVo.getContent());
        help.setWhen(new Date());
        help.setSolved(requestVo.getSolved());
        help.setCollected(requestVo.getCollected());
        help.setUId(requestVo.getUId());

        return helpService.addHelp(help);
    }

}
