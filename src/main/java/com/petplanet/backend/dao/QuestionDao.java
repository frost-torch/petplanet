package com.petplanet.backend.dao;

import com.petplanet.backend.pojo.Question;

import java.util.Map;

public interface QuestionDao {

    Map<String, Object> addQuestion(Question question);

}
