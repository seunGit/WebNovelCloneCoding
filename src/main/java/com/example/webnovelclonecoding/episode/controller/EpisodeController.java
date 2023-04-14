package com.example.webnovelclonecoding.episode.controller;

import com.example.webnovelclonecoding.common.dto.ResponseDto;
import com.example.webnovelclonecoding.episode.dto.EpisodeListResp;
import com.example.webnovelclonecoding.episode.dto.EpisodeRegisterReq;
import com.example.webnovelclonecoding.episode.dto.EpisodeUpdateReq;
import com.example.webnovelclonecoding.episode.service.EpisodeService;

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
public class EpisodeController {

    private final EpisodeService episodeService;

    @PostMapping("/{novelId}/episode")
    public ResponseEntity<?> registerEpisode(@PathVariable Long novelId, @RequestBody EpisodeRegisterReq episodeCreateReq) {
        episodeService.registerEpisode(novelId, episodeCreateReq);
        return new ResponseEntity<>(new ResponseDto<>("success", "에피소드 등록 성공!", null), HttpStatus.CREATED);
    }

    @PutMapping("/{novelId}/{episodeId}")
    public ResponseEntity<?> updateEpisode(@PathVariable Long novelId, @PathVariable Long episodeId, @RequestBody EpisodeUpdateReq episodeUpdateReq) {
        episodeService.updateEpisode(novelId, episodeId, episodeUpdateReq);
        return new ResponseEntity<>(new ResponseDto<>("success", "에피소드 수정 성공!", null), HttpStatus.OK);
    }

    @DeleteMapping("/{novelId}/{episodeId}")
    public ResponseEntity<?> deleteEpisode(@PathVariable Long novelId, @PathVariable Long episodeId) {
        episodeService.deleteEpisode(novelId, episodeId);
        return new ResponseEntity<>(new ResponseDto<>("success", "에피소드 삭제 성공!", null), HttpStatus.OK);
    }

    @GetMapping("/episode/list")
    public ResponseEntity<?> listOfEpisode() {
        List<EpisodeListResp> novels = episodeService.findAllBy();
        return new ResponseEntity<>(new ResponseDto<>("success", "에피소드 목록 조회 성공!", novels), HttpStatus.OK);
    }

}
