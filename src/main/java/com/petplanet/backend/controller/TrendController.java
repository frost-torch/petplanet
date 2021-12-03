package com.petplanet.backend.controller;

import com.petplanet.backend.pojo.Trend;
import com.petplanet.backend.service.TrendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/trend")
public class TrendController {

    @SuppressWarnings("all")
    @Autowired
    private TrendService trendService;

}
