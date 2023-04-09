package com.example.webnovelclonecoding.dto;

import com.example.webnovelclonecoding.entity.Member;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberLoginReq {

    private String username;

    private String password;

    public MemberLoginReq(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public Member toEntity() {
        return Member.builder()
                .username(username)
                .password(password)
                .build();
    }
}

