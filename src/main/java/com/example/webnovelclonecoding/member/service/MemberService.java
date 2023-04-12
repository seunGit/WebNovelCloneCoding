package com.example.webnovelclonecoding.member.service;

import com.example.webnovelclonecoding.common.jwt.JwtUtil;
import com.example.webnovelclonecoding.member.dto.MemberCreateReq;
import com.example.webnovelclonecoding.member.dto.MemberLoginReq;
import com.example.webnovelclonecoding.member.entity.Member;
import com.example.webnovelclonecoding.member.repository.MemberRepository;

import jakarta.servlet.http.HttpServletResponse;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

import static com.example.webnovelclonecoding.common.exception.ExceptionMessage.*;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    private final JwtUtil jwtUtil;

    @Transactional
    public void signup(MemberCreateReq memberCreateReq) {
        // 중복 회원 검증
        memberRepository.findByUsername(memberCreateReq.getUsername())
                .ifPresent(m -> {
                    throw new IllegalArgumentException(DUPLICATE_USERNAME_MSG.getMsg());
                });
        Member member = memberCreateReq.toEntity();
        memberRepository.save(member);
    }

    @Transactional(readOnly = true)
    public void login(MemberLoginReq memberLoginReq, HttpServletResponse httpServletResponse) {
        Member member = memberRepository.findByUsername(memberLoginReq.getUsername()).orElseThrow(
                () -> new NoSuchElementException(NOT_FOUND_MEMBER_MSG.getMsg())
        );
        if (!member.getPassword().equals(memberLoginReq.getPassword())) {
            throw new NoSuchElementException(NOT_MATCH_PASSWORD_MSG.getMsg());
        }
        httpServletResponse.addHeader(JwtUtil.AUTHORIZATION_HEADER, jwtUtil.createToken(member.getId()));
    }
}
