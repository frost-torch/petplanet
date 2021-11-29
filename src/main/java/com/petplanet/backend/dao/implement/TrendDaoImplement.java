package com.petplanet.backend.dao.implement;

import com.petplanet.backend.dao.TrendDao;
import com.petplanet.backend.pojo.Trend;
import com.petplanet.backend.util.WebStatusUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class TrendDaoImplement implements TrendDao {

    @SuppressWarnings("all")
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, Object> addTrend(Trend trend) {
        try {
            jdbcTemplate.update(
                    "insert into `trend`(`t_id`,`topic`,`content`,`private`,`likes`,`p_id`,`u_id`) values(?,?,?,?,?,?,?)",
                    trend.getTId(),
                    trend.getTopic(),
                    trend.getContent(),
                    trend.getPri(),
                    trend.getLikes(),
                    trend.getPId(),
                    trend.getUId()
            );
        } catch (Exception e) {
            e.printStackTrace();
            return WebStatusUtil.httpError("参数缺少或非法参数！");
        }
        return WebStatusUtil.httpOk("响应成功！");
    }

}
