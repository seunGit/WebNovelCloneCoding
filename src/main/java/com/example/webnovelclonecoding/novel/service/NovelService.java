package com.example.webnovelclonecoding.novel.service;

import com.example.webnovelclonecoding.novel.dto.NovelRegisterReq;
import com.example.webnovelclonecoding.novel.dto.NovelUpdateReq;
import com.example.webnovelclonecoding.novel.entity.Novel;
import com.example.webnovelclonecoding.novel.repository.NovelRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

import static com.example.webnovelclonecoding.common.exception.ExceptionMessage.*;

@Service
@RequiredArgsConstructor
public class NovelService {

    private final NovelRepository novelRepository;

    @Transactional
    public void registerNovel(NovelRegisterReq novelRegisterReq) {
        Novel novel = novelRegisterReq.toEntity();
        novelRepository.save(novel);
    }

    @Transactional
    public void updateNovel(Long novelId, NovelUpdateReq novelUpdateReq){
        Novel novel = findByNovelId(novelId);
        novel.update(novelUpdateReq.getTitle(),novelUpdateReq.getImage(),novelUpdateReq.getDescription());

    }

    @Transactional
    public void deleteNovel(Long novelId){
        Novel novel = findByNovelId(novelId);
        novelRepository.delete(novel);
    }

    private Novel findByNovelId(Long novelId) {
        return novelRepository.findById(novelId).orElseThrow(
                () -> new NoSuchElementException(NOT_FOUND_NOVEL_MSG.getMsg()));
    }

}
