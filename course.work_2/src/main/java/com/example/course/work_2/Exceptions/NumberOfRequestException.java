package com.example.course.work_2.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class NumberOfRequestException extends RuntimeException {

    public NumberOfRequestException() {
        System.out.println("Exceeding the number of requests");
    }
}
