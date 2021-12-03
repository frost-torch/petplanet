package com.petplanet.backend.dao.implement;

import com.petplanet.backend.dao.OnlinePetDao;
import com.petplanet.backend.pojo.OnlinePet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OnlinePetDaoImplement implements OnlinePetDao {

    @SuppressWarnings("all")
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer addOnlinePet(OnlinePet onlinePet) {

        try {
            jdbcTemplate.update(
                    "insert into `online_pet`(`u_id`,`p_id`,`when`) values(?,?,?)",
                    onlinePet.getUId(),
                    onlinePet.getPId(),
                    onlinePet.getWhen()
            );
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

        return 0;
    }

    @Override
    public List<OnlinePet> queryOnlinePets(Integer uId) {

        return jdbcTemplate.query(
                "select * from `online_pet` where `u_id`=?",
                this::mapRowToOnlinePet,
                uId
        );
    }

    private OnlinePet mapRowToOnlinePet(ResultSet rs, int rowNum) throws SQLException {
        return new OnlinePet(
                rs.getInt("u_id"),
                rs.getInt("p_id"),
                rs.getDate("when")
        );
    }

    @Override
    public boolean delOnlinePet(Integer uId, Integer pId) {

        try {
            jdbcTemplate.update(
                    "delete from `online_pet` where `u_id`=? and `p_id`=?",
                    uId,
                    pId
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
