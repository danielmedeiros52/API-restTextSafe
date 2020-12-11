package com.example.apiRestBetlab.services;


import com.example.apiRestBetlab.dto.TextSafeDTO;
import com.example.apiRestBetlab.model.TextSafe;
import com.example.apiRestBetlab.repository.TextSafeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TextSafeService {
    @Autowired
    private TextSafeRepository dao;


    @Transactional(readOnly = true)
    public List<TextSafeDTO>findAll(){
        return dao.findAll().stream().map(objectTextSafe -> new TextSafeDTO(objectTextSafe)).collect(Collectors.toList());
    }

    @Transactional
    public TextSafeDTO insert (TextSafeDTO objectTextSafeDto){
        TextSafe entity = new TextSafe();
        entity.setDescription(objectTextSafeDto.getDescription());
        entity = dao.save(entity);
        return new TextSafeDTO(entity);

    }

}