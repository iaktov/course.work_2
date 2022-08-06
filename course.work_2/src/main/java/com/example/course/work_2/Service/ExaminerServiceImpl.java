package com.example.course.work_2.Service;

import com.example.course.work_2.Exceptions.NumberOfRequestException;
import com.example.course.work_2.Interface.ExaminerService;
import com.example.course.work_2.Interface.QuestionService;
import com.example.course.work_2.Model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }


    @Override
    public Collection<Question> getQuestion(int amount) {
        if (questionService.getAll().size() < amount || amount < 0) {
            throw new NumberOfRequestException();
        }
        Set<Question> result = new HashSet<>();
        while (result.size() < amount) {
                result.add(questionService.getRandomQuestion());
            }
        return result;
    }
}
