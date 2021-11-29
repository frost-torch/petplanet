package com.petplanet.backend.service;

import com.petplanet.backend.dao.TrendDao;
import com.petplanet.backend.pojo.Trend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TrendService {

    @SuppressWarnings("all")
    @Autowired
    TrendDao trendDao;

    public Map<String, Object> addTrend(Trend trend) {
        return trendDao.addTrend(trend);
    }

}
