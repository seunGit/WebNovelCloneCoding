package com.example.webnovelclonecoding.novel.repository;

import com.example.webnovelclonecoding.novel.entity.Novel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NovelRepository extends JpaRepository<Novel, Long> {

}
