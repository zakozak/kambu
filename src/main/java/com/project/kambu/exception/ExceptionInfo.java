package com.project.kambu.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionInfo {

    private String message;
    private int statusCode;
    private Date timestamp;

}
