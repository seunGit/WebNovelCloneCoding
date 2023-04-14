package com.example.webnovelclonecoding.episode.entity;

import com.example.webnovelclonecoding.common.time.Timestamped;
import com.example.webnovelclonecoding.novel.entity.Novel;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Episode extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Integer page;

    private Boolean isFree;

    private Float vol;

    private String image;

    private Integer ticketCount;

    private Integer viewCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="novel_id")
    private Novel novel;

    @Builder
    public Episode(Long id, String title, int page, boolean isFree, float vol, String image, int ticketCount, int viewCount, Novel novel) {
        this.id = id;
        this.title = title;
        this.page = page;
        this.isFree = isFree;
        this.vol = vol;
        this.image = image;
        this.ticketCount = ticketCount;
        this.viewCount = viewCount;
        this.novel = novel;
    }

    public void update(String title, int page, boolean isFree, float vol, String image, int ticketCount) {
        this.title = title;
        this.page = page;
        this.isFree = isFree;
        this.vol = vol;
        this.image = image;
        this.ticketCount = ticketCount;
    }
}
