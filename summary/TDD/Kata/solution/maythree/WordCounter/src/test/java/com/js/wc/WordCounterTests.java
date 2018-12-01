package com.js.wc;

import com.js.wc.services.WordCounterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WordCounterTests {

    @Autowired
    private WordCounterService wordCounterService;

    @Test
    public void 한_단어_문자열() {
        String input = "boom";
        HashMap<String, Integer> results = wordCounterService.convertWords(input, " ");

        HashMap<String, Integer> predictResults = new HashMap<>();
        predictResults.put("boom", 1);

        assertEquals(results, predictResults);
    }

    @Test
    public void 스페이스가_구분자인_서로_다른_두_단어_문자열() {
        String input = "boom bang";
        HashMap<String, Integer> results = wordCounterService.convertWords(input, " ");

        HashMap<String, Integer> predictResults = new HashMap<>();
        predictResults.put("boom", 1);
        predictResults.put("bang", 1);

        assertEquals(results, predictResults);
    }

    @Test
    public void 스페이스가_구분자인_서로_같은_두_단어_문자열() {
        String input = "boom boom";
        HashMap<String, Integer> results = wordCounterService.convertWords(input, " ");

        HashMap<String, Integer> predictResults = new HashMap<>();
        predictResults.put("boom", 2);

        assertEquals(results, predictResults);
    }

    @Test
    public void 구분자가_스페이스가_아닌_문자열() {
        String input = "boom,boom,bang,wang,woom,woom,cwang,cwang";
        HashMap<String, Integer> results = wordCounterService.convertWords(input, ",");

        HashMap<String, Integer> predictResults = new HashMap<>();
        predictResults.put("boom", 2);
        predictResults.put("bang", 1);
        predictResults.put("wang", 1);
        predictResults.put("woom", 2);
        predictResults.put("cwang", 2);

        assertEquals(results, predictResults);
    }
}
