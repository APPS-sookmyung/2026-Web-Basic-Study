package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LottoService {

    public List<Integer> generateLotto() {

        Set<Integer> numbers = new HashSet<>();

        while (numbers.size() < 6) {
            numbers.add((int)(Math.random() * 45) + 1);
        }

        List<Integer> result = new ArrayList<>(numbers);
        Collections.sort(result);

        return result;
    }
}