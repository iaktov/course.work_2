package com.example.course.work_2.Controller;


import com.example.course.work_2.Interface.ExaminerService;
import com.example.course.work_2.Model.Question;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam/get")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }


    @GetMapping(path = "/{amount}")
    Collection<Question> getQuestions(@PathVariable("amount") int amount) {
        return examinerService.getQuestion(amount);
    }



}
