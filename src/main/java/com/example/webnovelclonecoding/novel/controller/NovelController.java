package com.example.webnovelclonecoding.novel.controller;

import com.example.webnovelclonecoding.common.dto.ResponseDto;
import com.example.webnovelclonecoding.novel.dto.NovelListResp;
import com.example.webnovelclonecoding.novel.dto.NovelRegisterReq;
import com.example.webnovelclonecoding.novel.dto.NovelUpdateReq;
import com.example.webnovelclonecoding.novel.service.NovelService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/novel")
public class NovelController {
    private final NovelService novelService;

    @PostMapping("/register")
    public ResponseEntity<?> registerNovel(@RequestBody NovelRegisterReq novelRegisterReq) {
        novelService.registerNovel(novelRegisterReq);
        return new ResponseEntity<>(new ResponseDto<>("success", "소설 등록 성공!", null), HttpStatus.CREATED);
    }

    @PutMapping("/register/{novelId}")
    public ResponseEntity<?> updateNovel(@PathVariable Long novelId, @RequestBody NovelUpdateReq novelUpdateReq) {
        novelService.updateNovel(novelId, novelUpdateReq);
        return new ResponseEntity<>(new ResponseDto<>("success", "소설 수정 성공!", null), HttpStatus.OK);
    }

    @DeleteMapping("/register/{novelId}")
    public ResponseEntity<?> deleteNovel(@PathVariable Long novelId) {
        novelService.deleteNovel(novelId);
        return new ResponseEntity<>(new ResponseDto<>("success", "소설 삭제 성공!", null), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<?> listOfNovel() {
        List<NovelListResp> novels = novelService.findAllBy();
        return new ResponseEntity<>(new ResponseDto<>("success", "소설 목록 조회 성공!", novels), HttpStatus.OK);
    }
}
