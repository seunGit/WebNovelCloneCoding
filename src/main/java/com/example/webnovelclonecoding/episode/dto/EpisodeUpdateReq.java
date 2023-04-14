package com.example.webnovelclonecoding.episode.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EpisodeUpdateReq {
    private String title;

    private Integer page;

    private Boolean isFree;

    private Float vol;

    private String image;

    private Integer ticketCount;
}
