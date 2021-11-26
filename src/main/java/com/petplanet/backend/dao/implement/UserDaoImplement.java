package com.petplanet.backend.dao.implement;

import com.petplanet.backend.dao.UserDao;
import com.petplanet.backend.pojo.User;
import com.petplanet.backend.util.WebStatusUtil;
import com.petplanet.backend.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

@Repository
public class UserDaoImplement implements UserDao {

    @SuppressWarnings("all")
    @Autowired
    JdbcTemplate jdbcTemplate;

    // 插入用户数据
    public Map<String, Object> addUser(User user) {

        // 插入用户信息，从而在数据库中生成用户的 uid
        try {
            jdbcTemplate.update("insert into `user`(`name`,`main_pic`,`email`) values(?,?,?)",
                    user.getName(),
                    user.getMainPic(),
                    user.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
            return WebStatusUtil.httpError("因缺少数据而引起的 sql 错误");
        }

        // 获得用户的 id
        user.setUId(
                jdbcTemplate.queryForObject("select `u_id` from `user` where email=" + user.getEmail(), Integer.class)
        );

        // 返回操作结果
        Map<String, Object> result = WebStatusUtil.httpOk("成功");
        result.put("uId", user.getUId());
        return result;
    }

    /**
     * 通过一条 email 地址，查找到一条用户信息
     * @param email 用户提供的邮箱地址
     * @return 用户信息
     */
    @Override
    public UserVo queryUser(String email) {

        UserVo resultVo = null;

        try {
            User user = jdbcTemplate.queryForObject(
                    "select * from user where `email`=" + email,
                    User.class
            );

            Integer uId = user.getUId();

            resultVo = jdbcTemplate.queryForObject(
                    "select `fans`,`subs`,`pubs`,`sign`,`birthday` from user where `u_id`=?",
                    this::mapRowToUserVo,
                    uId
            );

            resultVo.setUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return resultVo;
        }
    }

    private UserVo mapRowToUserVo(ResultSet rs, int rowNum) throws SQLException {
        return new UserVo(
                rs.getInt("fans"),
                rs.getInt("subs"),
                rs.getInt("pubs"),
                rs.getString("sign"),
                rs.getString("birthday")
        );
    }

}
