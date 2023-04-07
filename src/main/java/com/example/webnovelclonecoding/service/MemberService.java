package com.example.webnovelclonecoding.service;

import com.example.webnovelclonecoding.dto.MemberCreateReq;
import com.example.webnovelclonecoding.entity.Member;
import com.example.webnovelclonecoding.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.webnovelclonecoding.common.exception.ExceptionMessage.DUPLICATE_USERNAME_MSG;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void signup(MemberCreateReq memberCreateReq) {
        Member member = memberCreateReq.toEntity();
        // 중복 회원 검증
        memberRepository.findByUsername(memberCreateReq.getUsername())
                .ifPresent(m -> {
                    throw new IllegalArgumentException(DUPLICATE_USERNAME_MSG.getMsg());
                });
        memberRepository.save(member);
    }
}
