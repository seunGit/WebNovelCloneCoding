package com.example.webnovelclonecoding.novel.dto;

import com.example.webnovelclonecoding.novel.entity.Novel;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NovelRegisterReq {

    private String title;

    private String image;

    private String description;

    public Novel toEntity() {
        return Novel.builder()
                .title(title)
                .image(image)
                .description(description)
                .build();
    }
}
