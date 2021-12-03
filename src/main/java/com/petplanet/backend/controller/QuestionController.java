package com.petplanet.backend.controller;

import com.petplanet.backend.pojo.AnsForQuestion;
import com.petplanet.backend.pojo.Question;
import com.petplanet.backend.service.AnsForQuestionService;
import com.petplanet.backend.service.QuestionService;
import com.petplanet.backend.vo.AnsForQuestionVo;
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
    @Autowired
    private AnsForQuestionService answerService;

    @PostMapping("/pub")
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

    @PostMapping("/answer")
    public @ResponseBody Map<String, Object> answerQuestion(@RequestBody AnsForQuestionVo requestVo) {

        AnsForQuestion answer = new AnsForQuestion();
        answer.setQId(requestVo.getQId());
        answer.setAnswer(requestVo.getAnswer());
        answer.setWhen(requestVo.getWhen());
        answer.setConfirmed(requestVo.getConfirmed());
        answer.setLikes(requestVo.getLikes());
        answer.setUId(requestVo.getUId());

        return answerService.addAnswer(answer);
    }

}
