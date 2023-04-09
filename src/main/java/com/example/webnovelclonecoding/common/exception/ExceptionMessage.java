package com.example.webnovelclonecoding.common.exception;

import lombok.Getter;

@Getter
public enum ExceptionMessage {

    DUPLICATE_USERNAME_MSG("중복된 아이디 입니다."),
    NOT_FOUND_MEMBER_MSG("아이디를 찾을 수 없습니다."),
    NOT_MATCH_PASSWORD_MSG("비밀번호가 일치하지 않습니다.");

    private final String msg;
    ExceptionMessage(String msg) {
        this.msg = msg;
    }
}
