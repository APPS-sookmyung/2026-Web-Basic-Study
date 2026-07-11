package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class LottoService {
    public List<Integer> generateLotto(){
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            lottoNumbers.add(i);
        }

        Collections.shuffle(lottoNumbers);
        List<Integer> lotto = lottoNumbers.subList(0,6);
        Collections.sort(lotto);
        return lotto;
    }
}
