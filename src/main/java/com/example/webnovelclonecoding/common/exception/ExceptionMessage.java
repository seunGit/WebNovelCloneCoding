package com.example.webnovelclonecoding.common.exception;

import lombok.Getter;

@Getter
public enum ExceptionMessage {

    // Member
    DUPLICATE_USERNAME_MSG("중복된 아이디 입니다."),
    NOT_FOUND_MEMBER_MSG("아이디를 찾을 수 없습니다."),
    NOT_MATCH_PASSWORD_MSG("비밀번호가 일치하지 않습니다."),
    NOT_AUTHOR_MEMBER_MSG("접근 권한이 없습니다."),
    // Novel
    NOT_FOUND_NOVEL_MSG("소설을 찾을 수 없습니다.");
    private final String msg;
    ExceptionMessage(String msg) {
        this.msg = msg;
    }
}
