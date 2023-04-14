package com.example.webnovelclonecoding.episode.dto;

import com.example.webnovelclonecoding.episode.entity.Episode;
import com.example.webnovelclonecoding.novel.entity.Novel;

import lombok.Getter;

@Getter
public class EpisodeRegisterReq {

    private String title;

    private Integer page;

    private Boolean isFree;

    private Float vol;

    private String image;

    private Integer ticketCount;

    public Episode toEntity(Novel novel) {
        return Episode.builder()
                .title(title)
                .page(0)
                .vol(vol)
                .image(image)
                .isFree(isFree)
                .ticketCount(ticketCount)
                .viewCount(0)
                .novel(novel)
                .build();
    }
}
