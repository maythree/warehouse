package com.js.wc.services;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;

@Service
public class WordCounterServiceImpl implements WordCounterService {
    @Override
    public HashMap<String, Integer> convertWords(String value, String delimiter) {
        HashMap<String, Integer> result = new HashMap<>();
        Arrays.stream(value.split(delimiter))
                .sorted()
                .forEach(word -> {
                    if(result.containsKey(word)) {
                        Integer wordCount = result.get(word).intValue();
                        result.replace(word, ++wordCount);
                    } else {
                        result.put(word, 1);
                    }
                });
        return result;
    }
}
