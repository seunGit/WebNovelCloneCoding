package com.example.webnovelclonecoding.novel.repository;

import com.example.webnovelclonecoding.novel.entity.Novel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NovelRepository extends JpaRepository<Novel, Long> {
    // 인터페이스를 생성 후, JpaRepository<Entity 클래스, PK 타입>를 상속하면
    // 기본 적인 CRUD 메소드가 자동으로 생성
    @Query("SELECT n from Novel n order by n.id")
    List<Novel> findAllBy();
}
