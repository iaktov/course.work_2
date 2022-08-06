package com.example.course.work_2.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class NoDataEnteredException extends RuntimeException {
    public NoDataEnteredException() {
        System.out.println("no data entered");
    }
}
