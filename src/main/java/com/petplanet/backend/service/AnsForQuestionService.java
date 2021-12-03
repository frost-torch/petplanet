package com.petplanet.backend.service;

import com.petplanet.backend.dao.AnsForQuestionDao;
import com.petplanet.backend.pojo.AnsForQuestion;
import com.petplanet.backend.util.WebStatusUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AnsForQuestionService {

    @SuppressWarnings("all")
    @Autowired
    private AnsForQuestionDao answerDao;

    public Map<String, Object> addAnswer(AnsForQuestion answer) {

        try {
            answerDao.addAnswer(answer);
        }catch (Exception e) {
            e.printStackTrace();
            return WebStatusUtil.httpError("参数错误或缺少参数");
        }finally {
            return WebStatusUtil.httpOk("响应成功！");
        }
    }

}
