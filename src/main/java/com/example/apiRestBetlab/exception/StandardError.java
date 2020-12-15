package com.example.apiRestBetlab.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class StandardError implements Serializable {
    private Integer status;
    private String errorMessage;
    private Long instantOfError;
}
