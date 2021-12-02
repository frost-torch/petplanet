package com.petplanet.backend.dao.implement;

import com.petplanet.backend.dao.HelpDao;
import com.petplanet.backend.pojo.Help;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HelpDaoImplement implements HelpDao {

    @SuppressWarnings("all")
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer addHelp(Help help) {

        String sqlInsert = "insert into `help`(`topic`, `content`, `click`, `when`, `solved`, `collected`, `u_id`) values(?,?,?,?,?,?,?)";
        String sqlQuery = "select `h_id` from `help` where u_id=? and topic=?";

        try {
            // 查看用户是否已经发布过相同主题的求助信息
            Integer hId = null;
            try {
                 hId = jdbcTemplate.queryForObject(sqlQuery, Integer.class, help.getUId(), help.getTopic());
            } catch (Exception e) {
                System.out.println("暂无相关记录");
            }
            if (null != hId) {
                // 如果已经发布过了，则返回 null 表示请求失败
                return null;
            }

            jdbcTemplate.update(sqlInsert, help.getTopic(), help.getContent(), help.getClick(), help.getWhen(), help.getSolved(), help.getCollected(), help.getUId());

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            return jdbcTemplate.queryForObject(sqlQuery, Integer.class, help.getUId(), help.getTopic());
        }
    }

    @Override
    public boolean delHelp(Integer hId) {

        try {
            jdbcTemplate.update(
                    "delete from `help` where `h_id`=?",
                    hId
            );

        } catch (Exception e) {
            return false;
        }

        return true;
    }

}
