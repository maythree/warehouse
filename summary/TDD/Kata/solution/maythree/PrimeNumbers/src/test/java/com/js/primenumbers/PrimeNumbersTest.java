package com.js.primenumbers;

import com.js.primenumbers.services.PrimeNumberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PrimeNumbersTest {

    @Autowired
    private PrimeNumberService primeNumberService;

    @Test
    public void 정수_4는_소수가_아니다() {
        Integer input = 4;
        assertFalse(primeNumberService.isPrimeNumber(input));
    }

    @Test
    public void 정수_2는_소수가_맞다() {
        Integer input = 2;
        assertTrue(primeNumberService.isPrimeNumber(input));
    }

    @Test
    public void 정수_3은_소수가_맞다() {
        Integer input = 3;
        assertTrue(primeNumberService.isPrimeNumber(input));
    }

    @Test
    public void 정수_1은_소수가_아니다() {
        Integer input = 1;
        assertFalse(primeNumberService.isPrimeNumber(input));
    }

    @Test
    public void 정수_14는_소수가_아니다() {
        Integer input = 14;
        assertFalse(primeNumberService.isPrimeNumber(input));
    }
}
