package com.example.webnovelclonecoding.common.exception;

import lombok.Getter;

@Getter
public enum ExceptionMessage {

    DUPLICATE_USERNAME_MSG("중복된 아이디 입니다.");

    private final String msg;
    ExceptionMessage(String msg) {
        this.msg = msg;
    }
}
