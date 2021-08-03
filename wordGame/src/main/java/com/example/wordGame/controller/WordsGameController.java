package com.example.wordGame.controller;

import com.example.wordGame.model.WordsDTO;
import com.example.wordGame.service.WordsGameService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api", produces = {"application/json"})
public class WordsGameController {

    private final WordsGameService service;

    @Autowired
    public WordsGameController(WordsGameService service) {
        this.service = service;
    }

    @PostMapping(value = "/playGame", consumes = "application/json")
    public WordsDTO playGame(@RequestBody WordsDTO wordsDTO) {
        return service.getResultGame(wordsDTO.getWords());
    }
}
