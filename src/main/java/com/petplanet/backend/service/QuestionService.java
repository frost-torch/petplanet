package com.petplanet.backend.service;

import com.petplanet.backend.dao.QuestionDao;
import com.petplanet.backend.pojo.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class QuestionService {

    @SuppressWarnings("all")
    @Autowired
    private QuestionDao questionDao;

    public Map<String, Object> addQuestion(Question question) {
        return questionDao.addQuestion(question);
    }

}
