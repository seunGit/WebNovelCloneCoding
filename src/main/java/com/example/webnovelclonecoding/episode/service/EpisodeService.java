package com.example.webnovelclonecoding.episode.service;

import com.example.webnovelclonecoding.episode.dto.EpisodeListResp;
import com.example.webnovelclonecoding.episode.dto.EpisodeRegisterReq;
import com.example.webnovelclonecoding.episode.dto.EpisodeUpdateReq;
import com.example.webnovelclonecoding.episode.entity.Episode;
import com.example.webnovelclonecoding.episode.repository.EpisodeRepository;
import com.example.webnovelclonecoding.novel.entity.Novel;
import com.example.webnovelclonecoding.novel.repository.NovelRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static com.example.webnovelclonecoding.common.exception.ExceptionMessage.NOT_FOUND_EPISODE_MSG;
import static com.example.webnovelclonecoding.common.exception.ExceptionMessage.NOT_FOUND_NOVEL_MSG;

@Service
@RequiredArgsConstructor
public class EpisodeService {
    private final EpisodeRepository episodeRepository;
    private final NovelRepository novelRepository;

    @Transactional
    public void registerEpisode(Long novelId, EpisodeRegisterReq episodeReqegisterReq) {
        Novel novel = findByNovelId(novelId);
        Episode episode = episodeReqegisterReq.toEntity(novel);
        episodeRepository.save(episode);
    }

    @Transactional(readOnly = true)
    public List<EpisodeListResp> findAllBy() {
        return episodeRepository.findAllBy().stream()
                .map(EpisodeListResp::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void updateEpisode(Long novelId, Long episodeId, EpisodeUpdateReq episodeUpdateReq){
        findByNovelId(novelId);
        Episode episode = findByEpisodeId(episodeId);
        episode.update(episodeUpdateReq.getTitle(), episodeUpdateReq.getPage(), episodeUpdateReq.getIsFree(), episodeUpdateReq.getVol(), episodeUpdateReq.getImage(), episodeUpdateReq.getTicketCount());
    }

    @Transactional
    public void deleteEpisode(Long novelId, Long episodeId){
        findByNovelId(novelId);
        Episode episode = findByEpisodeId(episodeId);
        episodeRepository.delete(episode);
    }

    private Novel findByNovelId(Long novelId) {
        return novelRepository.findById(novelId).orElseThrow(
                () -> new NoSuchElementException(NOT_FOUND_NOVEL_MSG.getMsg()));
    }

    private Episode findByEpisodeId(Long episodeId) {
        return episodeRepository.findById(episodeId).orElseThrow(
                () -> new NoSuchElementException(NOT_FOUND_EPISODE_MSG.getMsg()));
    }
}