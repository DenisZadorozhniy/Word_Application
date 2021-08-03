package com.example.wordGame;

import com.example.wordGame.model.WordsDTO;
import com.example.wordGame.service.WordsGameService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WordGameApplicationTests {

	/*“words”: [ “fish”, “horse”, “egg”’, “goose”, “eagle”  ]} */

	private WordsGameService service = new WordsGameService();

	@Test
	void allValideWords(){
		WordsDTO wordsDTO = new WordsDTO();
		List<String> words = new ArrayList<>();
		words.add("fish");
		words.add("horse");
		words.add("egg");
		words.add("goose");
		words.add("eagle");
		wordsDTO.setWords(words);


		WordsDTO result = service.getResultGame(wordsDTO.getWords());
		// The result should be 5 words in the list

		assertEquals(5, result.getWords().size());

		// There must be every word
		assertTrue(result.getWords().contains("fish"));
		assertTrue(result.getWords().contains("horse"));
		assertTrue(result.getWords().contains("egg"));
		assertTrue(result.getWords().contains("goose"));
		assertTrue(result.getWords().contains("eagle"));

	}

	@Test
	void haveMistake() {

		WordsDTO wordsDTO = new WordsDTO();
		List<String> words = new ArrayList<>();
		words.add("fish");
		words.add("horse");
		words.add("snake");
		words.add("goose");
		words.add("eagle");
		wordsDTO.setWords(words);

		WordsDTO result = service.getResultGame(wordsDTO.getWords());

		assertEquals(2, result.getWords().size());

		assertTrue(result.getWords().contains("fish"));
		assertTrue(result.getWords().contains("horse"));
	}

	@Test
	void checkingForEmptyString(){

		WordsDTO wordsDTO = new WordsDTO();
		List<String> words = new ArrayList<>();
		words.add("fish");
		words.add("horse");
		words.add("");
		words.add("goose");
		words.add("eagle");
		wordsDTO.setWords(words);

		WordsDTO result = service.getResultGame(wordsDTO.getWords());

		assertEquals(2, result.getWords().size());

		assertTrue(result.getWords().contains("fish"));
		assertTrue(result.getWords().contains("horse"));
	}

	@Test
	void checkingForFirstEmptyString(){
		WordsDTO wordsDTO = new WordsDTO();
		List<String> words = new ArrayList<>();
		words.add("");
		words.add("fish");
		words.add("horse");
		words.add("goose");
		words.add("eagle");
		wordsDTO.setWords(words);

		WordsDTO result = service.getResultGame(wordsDTO.getWords());

		assertEquals(0, result.getWords().size());
	}

}
