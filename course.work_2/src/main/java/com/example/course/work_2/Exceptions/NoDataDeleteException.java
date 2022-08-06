package com.example.course.work_2.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_GATEWAY)
public class NoDataDeleteException extends RuntimeException {
    public NoDataDeleteException() {
        System.out.println("There is no such data in the system, it cannot be deleted");
    }
}
