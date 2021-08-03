package com.example.wordGame.service;

import com.example.wordGame.model.WordsDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WordsGameService {
    public WordsDTO getResultGame(List<String> allWords) {

        WordsDTO wordsDTO = new WordsDTO();
        List<String> currentWords = new ArrayList<>();

        if (allWords.get(0).equals(" ") || allWords.get(0).equals("")) {
            wordsDTO.setWords(currentWords);
            return wordsDTO;
        } else {
            currentWords.add(allWords.get(0));

            for (int i = 0; i < allWords.size() - 1; i++) {

                StringBuilder sb = new StringBuilder();
                sb.append(allWords.get(i));

                StringBuilder secondSB = new StringBuilder();
                secondSB.append(allWords.get(i + 1));

                if (allWords.get(i + 1).equals(" ") || allWords.get(i + 1).equals("")) {
                    wordsDTO.setWords(currentWords);
                    return wordsDTO;
                } else if (sb.charAt(sb.length() - 1) == secondSB.charAt(0)) {
                    currentWords.add(allWords.get(i + 1));
                    wordsDTO.setWords(currentWords);
                } else {
                    return wordsDTO;
                }
            }
        }
        return wordsDTO;
    }
}
