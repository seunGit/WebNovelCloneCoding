package com.example.webnovelclonecoding.dto;

import com.example.webnovelclonecoding.entity.Member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberCreateReq {

    private String username;

    private String password;

    @Builder
    public MemberCreateReq(String username, String password) {
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

