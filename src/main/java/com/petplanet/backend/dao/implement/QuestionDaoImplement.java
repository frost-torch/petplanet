package com.petplanet.backend.dao.implement;

import com.petplanet.backend.dao.QuestionDao;
import com.petplanet.backend.pojo.Question;
import com.petplanet.backend.util.WebStatusUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class QuestionDaoImplement implements QuestionDao {

    @SuppressWarnings("all")
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, Object> addQuestion(Question question) {
        // 插入数据
        try {
            jdbcTemplate.update(
                    "insert into `question`(`topic`,`content`,`click`,`when`,`solved`,`collected`,`u_id`) values(?,?,?,?,?,?,?)",
                    question.getTopic(),
                    question.getContent(),
                    question.getClick(),
                    question.getWhen(),
                    question.getSolved(),
                    question.getCollected(),
                    question.getUId()
            );
        } catch (Exception e) {
            e.printStackTrace();
            return WebStatusUtil.httpError("参数缺少或非法参数！");
        }

        // 获得刚刚插入的数据的序列号
        List<Integer> qIds = jdbcTemplate.queryForList("select `q_id` from `question` where `u_id`=" + question.getUId(), Integer.class);
        Integer qId = qIds.get(qIds.size() - 1);

        // 返回结果
        Map<String, Object> ok = WebStatusUtil.httpOk("响应成功！");
        ok.put("qId", qId);
        return ok;
    }

}
