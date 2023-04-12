package com.example.webnovelclonecoding.novel.entity;

import com.example.webnovelclonecoding.common.time.Timestamped;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Novel extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String image;

    private String description;

    private Long memberId;

    @Builder
    public Novel(Long id, String title, String image, String description, Long memberId) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.description = description;
        this.memberId = memberId;
    }

    public void update(String title, String image, String description) {
        this.title = title;
        this.image = image;
        this.description = description;
    }
}
