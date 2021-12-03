package com.petplanet.backend.dao.implement;

import com.petplanet.backend.dao.PetDao;
import com.petplanet.backend.pojo.Pet;
import com.petplanet.backend.util.WebStatusUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

    @Override
    public List<Pet> queryPet(Integer uId) {

        List<Pet> pets;

        try {
            pets = jdbcTemplate.query(
                    "select * from `pet` where `u_id`=?",
                    this::mapRowToPet,
                    uId
            );
        } catch (Exception e) {
            e.printStackTrace();
            pets = new ArrayList<>();
        }

        return pets;
    }

    @Override
    public boolean updatePet(Pet pet) {

        if (pet.getPId() == null) {
            return false;
        }

        StringBuilder sql = new StringBuilder("update `pet` set ");

        if (pet.getName() != null) {
            sql.append("`name`=").append('\'').append(pet.getName()).append('\'').append(',');
        }
        if (pet.getSpecies() != null) {
            sql.append("`species`=").append(pet.getSpecies()).append(',');
        }
        if (pet.getType() != null) {
            sql.append("`type`=").append('\'').append(pet.getType()).append('\'').append(',');
        }
        if (pet.getAge() != null) {
            sql.append("`age`=").append('\'').append(pet.getAge()).append('\'').append(',');
        }
        if (pet.getWeight() != null) {
            sql.append("`weight`=").append('\'').append(pet.getWeight()).append('\'').append(',');
        }
        if (pet.getMainPic() != null) {
            sql.append("`main_pic`=").append('\'').append(pet.getMainPic()).append('\'').append(',');
        }
        sql.deleteCharAt(sql.length() - 1);
        sql.append(" where `p_id`=").append(pet.getPId());

        try {
            jdbcTemplate.update(sql.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            return true;
        }
    }

    @Override
    public List<Pet> queryPet(Integer uId, Integer pId) {

        List<Pet> pets = new ArrayList<>();
        Pet pet;

        try {
            pet = jdbcTemplate.queryForObject(
                    "select * from `pet` where `u_id`=? and `p_id`=?",
                    this::mapRowToPet,
                    uId,
                    pId
            );

            pets.add(pet);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pets;
    }

    private Pet mapRowToPet(ResultSet rs, int rowNum) throws SQLException {
        return new Pet(
                rs.getInt("owner"),
                rs.getInt("p_id"),
                rs.getString("name"),
                rs.getInt("species"),
                rs.getString("type"),
                rs.getString("age"),
                rs.getString("weight"),
                rs.getString("main_pic")
        );
    }

    @Override
    public void delPet(Integer pId) {
        jdbcTemplate.update(
                "delete from `pet` where `pId`=?",
                pId
        );
    }
}
