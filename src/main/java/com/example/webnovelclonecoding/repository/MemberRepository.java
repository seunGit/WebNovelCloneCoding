package com.example.webnovelclonecoding.repository;

import com.example.webnovelclonecoding.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByUsername(String email);
}
