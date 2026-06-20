package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class LottoService {
    public List<Integer> generatorLotto(){

        List<Integer>numbers = new ArrayList<>();
        for (int i=1; i <= 45; i++){
            numbers.add(i);
        }
        Collections.shuffle(numbers);

        List<Integer> list2 = new ArrayList<>();
        for (int i=0; i <= 5; i++){
            list2.add(numbers.get(i));
        }
        Collections.sort(list2);
        return list2;
        }
    }

