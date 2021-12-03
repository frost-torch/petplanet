package com.petplanet.backend.dao.implement;

import com.petplanet.backend.dao.AnsForQuestionDao;
import com.petplanet.backend.pojo.AnsForQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AnsForQuestionDaoImplement implements AnsForQuestionDao {

    @SuppressWarnings("all")
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addAnswer(AnsForQuestion answer) {

        jdbcTemplate.update(
                "insert into `ans_for_q`(`answer`, `when`, `confirmed`, `likes`, `u_id`) values(?,?,?,?,?)",
                answer.getAnswer(),
                answer.getWhen(),
                answer.getConfirmed(),
                answer.getLikes(),
                answer.getUId()
        );
    }

}
