package com.example.webnovelclonecoding.novel.service;

import com.example.webnovelclonecoding.novel.dto.NovelListResp;
import com.example.webnovelclonecoding.novel.dto.NovelRegisterReq;
import com.example.webnovelclonecoding.novel.dto.NovelUpdateReq;
import com.example.webnovelclonecoding.novel.entity.Novel;
import com.example.webnovelclonecoding.novel.repository.NovelRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

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
        novel.update(novelUpdateReq.getTitle(), novelUpdateReq.getImage(), novelUpdateReq.getDescription());
    }

    @Transactional
    public void deleteNovel(Long novelId){
        Novel novel = findByNovelId(novelId);
        novelRepository.delete(novel);
    }
    /*
    (readOnly = true)조회속도 개선
    novelRepository로 넘겨받은 novels stream을
    map을 사용하여 NovelListResp로 변환후 List로 반환.
    */
    @Transactional(readOnly = true)
    public List<NovelListResp> findAllBy() {
        return novelRepository.findAllBy().stream()
//                .map(NovelListResp::new)
                // 람다
                 .map(novel -> new NovelListResp(novel))
                .collect(Collectors.toList());
    }

    private Novel findByNovelId(Long novelId) {
        return novelRepository.findById(novelId).orElseThrow(
                () -> new NoSuchElementException(NOT_FOUND_NOVEL_MSG.getMsg()));
    }
}
