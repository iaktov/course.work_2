package com.example.course.work_2.Service;

import com.example.course.work_2.Interface.ExaminerService;
import com.example.course.work_2.Interface.QuestionService;
import com.example.course.work_2.Model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ExaminerServiceImp implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImp(QuestionService questionService) {
        this.questionService = questionService;
    }


    @Override
    public Collection<Question> getQuestion(int amount) {
        return null;
    }
}
