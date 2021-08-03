package com.example.wordGame.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class WordsDTO {
    private List<String> words;

}
