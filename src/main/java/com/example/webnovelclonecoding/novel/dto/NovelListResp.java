package com.example.webnovelclonecoding.novel.dto;

import com.example.webnovelclonecoding.novel.entity.Novel;
import lombok.Getter;

@Getter
public class NovelListResp {
    private Long id;

    private String title;

    private String image;

    private String description;

    public NovelListResp(Novel novel) {
        this.id = novel.getId();
        this.title = novel.getTitle();
        this.image = novel.getImage();
        this.description = novel.getDescription();
    }
}
