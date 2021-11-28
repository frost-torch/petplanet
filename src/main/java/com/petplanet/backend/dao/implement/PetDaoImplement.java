package com.petplanet.backend.dao.implement;

import com.petplanet.backend.dao.PetDao;
import com.petplanet.backend.pojo.Pet;
import com.petplanet.backend.util.WebStatusUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class PetDaoImplement implements PetDao {

    @SuppressWarnings("all")
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, Object> addPet(Pet pet) {

        try {
            jdbcTemplate.update(
                    "insert into `pet`(`owner`, `name`, `species`, `type`, `age`, `weight`, `main_pic`) values(?,?,?,?,?,?,?)",
                    pet.getOwner(),
                    pet.getName(),
                    pet.getSpecies(),
                    pet.getType(),
                    pet.getAge(),
                    pet.getWeight(),
                    pet.getMainPic()
            );
        } catch (Exception e) {
            e.printStackTrace();

            return WebStatusUtil.httpError("信息不合法或缺少信息！");
        }

        Map<String, Object> ok = WebStatusUtil.httpOk("响应成功！");
        ok.put(
                "pId",
                jdbcTemplate.queryForList(
                        "select `p_id` from `pet` where `owner`=? and `name`=?",
                        pet.getOwner(),
                        pet.getName()
                )
        );
        return ok;
    }

}
