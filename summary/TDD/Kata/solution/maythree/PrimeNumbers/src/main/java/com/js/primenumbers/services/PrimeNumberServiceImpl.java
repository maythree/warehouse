package com.js.primenumbers.services;

import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class PrimeNumberServiceImpl implements PrimeNumberService {
    @Override
    public boolean isPrimeNumber(Integer value) {
        if(value == 1) {
            return false;
        }
        return Stream.iterate(2, i -> i)
                .limit(value)
                .filter(num -> (value/num) != 1)
                .count() == 0;
    }
}
