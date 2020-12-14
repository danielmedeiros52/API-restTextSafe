package com.example.apiRestBetlab.controller;


import com.example.apiRestBetlab.converter.SavedTextConverter;
import com.example.apiRestBetlab.dto.TextSafeDTO;
import com.example.apiRestBetlab.model.TextSafe;
import com.example.apiRestBetlab.services.TextSafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

// TODO: 14/12/2020  toda url deve seguir o padrao de criacao, ela nao pode ser em cammel case
//  neste caso deveria ser text-safe e ela nao entra em plural
@RestController
@RequestMapping(value = "/textsafes")
public class TextSafeController {
    
      // TODO: 14/12/2020 autowired deve ser usado em constutores e as variaveis devem ser final
    @Autowired
    private TextSafeService service;

  // TODO: 14/12/2020 Os Metodos do Controller deve retornar apenas ResponseEntity sem o generics, 
  //  isto por que voce deve colocar a chamada para o service dentro de um try catch 
    @GetMapping
    public ResponseEntity<Page<TextSafeDTO>>findPages(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage",defaultValue = "10") Integer linesPerPage,
            @RequestParam(value = "orderBy",defaultValue = "id") String orderBy,
            @RequestParam(value = "direction",defaultValue = "ASC") String direction){
        
    // TODO: 14/12/2020 esse tipo de logica nao deve ocorrer dentro do controller pois fere algumas regras
    //  1: Conceito de responsabilidade unica do metodo (todos os metodos devem fazer apenas uma coisa
    //  neste caso este esta recebendo as informacoes externas passando para o service e depois ainda esta filtrando)
    //  2: Desing pattern MVC esta camada ele deve ser resonsavel apenas por receber e devolver informacao nao deve tratar dados.
        Page<TextSafe> listOfPages = service.findAllPages(page,linesPerPage,orderBy,direction);
            // TODO: 14/12/2020 usar method reference quando usar map
        Page<TextSafeDTO> listOfPagesDto = listOfPages.map((objectOfSavedTextPages -> SavedTextConverter.convertToDto(objectOfSavedTextPages)));
            // TODO: 14/12/2020  sendo assim quando ocorrer um erro que este deve ser capturado pelo catch e devolvido pela api com a
    //  mensagem de erro e o status do erro por exemplo ResponseEntity.badRequest().body(e.message())
        return ResponseEntity.ok().body(listOfPagesDto);
    }
    @PostMapping
    public ResponseEntity<TextSafeDTO> insert (@Valid @RequestBody TextSafe entity){

        return new ResponseEntity<>(service.insert(entity),HttpStatus.CREATED);
    }


}
