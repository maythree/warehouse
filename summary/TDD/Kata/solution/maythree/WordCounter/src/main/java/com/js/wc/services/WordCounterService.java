package com.js.wc.services;

import java.util.HashMap;

public interface WordCounterService {
    HashMap<String, Integer> convertWords(String value, String delimiter);
}
