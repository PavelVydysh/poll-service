package ru.golbi.domain.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BaseException extends RuntimeException {

    private String messageKey;

    private Object[] args;

}
