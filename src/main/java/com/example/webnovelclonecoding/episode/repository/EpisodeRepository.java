package com.example.webnovelclonecoding.episode.repository;

import com.example.webnovelclonecoding.episode.entity.Episode;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EpisodeRepository extends JpaRepository<Episode, Long> {
    @Query("SELECT e from Episode e order by e.id")
    List<Episode> findAllBy();
}
