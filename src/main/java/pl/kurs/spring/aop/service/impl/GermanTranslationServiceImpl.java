package pl.kurs.spring.aop.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import pl.kurs.spring.aop.annotation.LogToFile;
import pl.kurs.spring.aop.service.TranslationService;

@Service("german")
public class GermanTranslationServiceImpl implements TranslationService {

	private Map<String, String> dictionary;

	@PostConstruct
	public void init() {
		dictionary = new HashMap<>();
		dictionary.put("tak", "ja");
		dictionary.put("nie", "nein");
		dictionary.put("dlaczego", "warum");
	}

	@Override
	@LogToFile("german.txt")
	public String translate(String polishWord) {
		return Optional.ofNullable(dictionary.get(polishWord)).orElse("Brak tłumaczenia");
	}

}
