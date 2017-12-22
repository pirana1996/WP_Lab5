package com.example.demo.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Student invalid index value")
@ResponseStatus(reason = "Student invalid index value", code = HttpStatus.BAD_REQUEST)
public class InvalidIndexValue extends RuntimeException {
}
