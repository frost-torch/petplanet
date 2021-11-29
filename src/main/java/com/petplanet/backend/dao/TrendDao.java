package com.petplanet.backend.dao;

import com.petplanet.backend.pojo.Trend;

import java.util.Map;

public interface TrendDao {

    Map<String, Object> addTrend(Trend trend);

}
