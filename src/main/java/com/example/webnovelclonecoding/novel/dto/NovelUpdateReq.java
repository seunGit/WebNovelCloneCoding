package com.example.webnovelclonecoding.novel.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NovelUpdateReq {

    private String title;

    private String image;

    private String description;

}
