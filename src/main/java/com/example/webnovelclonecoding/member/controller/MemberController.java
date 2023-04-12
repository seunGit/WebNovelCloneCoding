package com.example.webnovelclonecoding.member.controller;

import com.example.webnovelclonecoding.common.dto.ResponseDto;
import com.example.webnovelclonecoding.member.dto.MemberCreateReq;
import com.example.webnovelclonecoding.member.dto.MemberLoginReq;
import com.example.webnovelclonecoding.member.service.MemberService;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody MemberCreateReq memberCreateReq) {
        memberService.signup(memberCreateReq);
        return new ResponseEntity<>(new ResponseDto<>("success", "회원가입 성공!", null), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody MemberLoginReq memberLoginReq, HttpServletResponse httpServletResponse) {
        memberService.login(memberLoginReq, httpServletResponse);
        return new ResponseEntity<>(new ResponseDto<>("success", "로그인 성공!", null), HttpStatus.OK);
    }
}
