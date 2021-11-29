package com.petplanet.backend.controller;

import com.petplanet.backend.service.TrendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trend")
public class TrendController {

    @SuppressWarnings("all")
    @Autowired
    TrendService trendService;

}
