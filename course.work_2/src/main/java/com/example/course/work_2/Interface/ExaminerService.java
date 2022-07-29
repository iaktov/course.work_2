package com.example.course.work_2.Interface;

import com.example.course.work_2.Model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestion(int amount);
}
