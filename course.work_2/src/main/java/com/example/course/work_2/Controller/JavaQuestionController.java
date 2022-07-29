package com.example.course.work_2.Controller;


import com.example.course.work_2.Interface.QuestionService;
import com.example.course.work_2.Model.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(path = "/add")
    public Question addQuestion(@RequestParam(value = "question") String question,
                        @RequestParam(value = "answer") String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping(path = "/remove")
    public Question removeQuestion(@RequestParam(value = "question") String question,
                        @RequestParam(value = "answer") String answer) {
        return questionService.remove(null);
    }

    @GetMapping
    Collection<Question> getQuestions() {
        return questionService.getAll();
    }

}
