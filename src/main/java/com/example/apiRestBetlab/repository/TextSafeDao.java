package com.example.apiRestBetlab.repository;

import com.example.apiRestBetlab.model.TextSafe;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

// TODO: 14/12/2020 a gente trabalha com CrudRepository e o nome das classes de repositorio e terminado em Dao
@Repository
public interface TextSafeDao extends JpaRepository<TextSafe,Long> {


}
