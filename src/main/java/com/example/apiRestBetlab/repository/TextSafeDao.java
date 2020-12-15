package com.example.apiRestBetlab.repository;

import com.example.apiRestBetlab.model.TextSafe;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface TextSafeDao extends JpaRepository<TextSafe,Long> {


}
