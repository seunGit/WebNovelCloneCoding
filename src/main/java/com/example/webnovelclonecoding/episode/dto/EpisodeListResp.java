package com.example.webnovelclonecoding.episode.dto;

import com.example.webnovelclonecoding.episode.entity.Episode;
import lombok.Getter;

@Getter
public class EpisodeListResp {
    private Long id;

    private String title;

    private Integer page;

    private Boolean isFree;

    private Float vol;

    private String image;

    private Integer ticketCount;

    public EpisodeListResp(Episode episode) {
        this.id = episode.getId();
        this.title = episode.getTitle();
        this.page = episode.getPage();
        this.isFree = episode.getIsFree();
        this.vol = episode.getVol();
        this.image = episode.getImage();
        this.ticketCount = episode.getTicketCount();
    }
}
