package com.petplanet.backend.controller;

import com.petplanet.backend.pojo.Question;
import com.petplanet.backend.service.QuestionService;
import com.petplanet.backend.vo.QuestionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 问题控制类
 */
@RestController
@RequestMapping("/question")
public class QuestionController {

    @SuppressWarnings("all")
    @Autowired
    private QuestionService questionService;

    @PostMapping("/add")
    public @ResponseBody
    Map<String, Object> addQuestion(@RequestBody QuestionVo requestVo) {
        Question question = new Question();
        question.setUId(requestVo.getUId());
        question.setClick(requestVo.getClick());
        question.setTopic(requestVo.getTopic());
        question.setContent(requestVo.getContent());
        question.setCollected(requestVo.getCollected());
        question.setSolved(requestVo.getSolved());
        question.setWhen(requestVo.getWhen());

        return questionService.addQuestion(question);
    }

}
