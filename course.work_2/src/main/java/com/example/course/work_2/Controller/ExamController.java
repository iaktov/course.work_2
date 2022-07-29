package com.example.course.work_2.Controller;


import com.example.course.work_2.Interface.ExaminerService;
import com.example.course.work_2.Model.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }


    @GetMapping
    Collection<Question> getQuestions(@RequestParam(value = "amount") int amount) {
        return examinerService.getQuestion(amount);
    }



}
