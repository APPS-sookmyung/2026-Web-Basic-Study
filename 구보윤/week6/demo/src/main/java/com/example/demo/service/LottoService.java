package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class LottoService {

    public List<Integer> generateLottoNumbers() {
        List<Integer> lotto = new ArrayList<>();
        Random random = new Random();

        while (lotto.size() < 6) {
            int number = random.nextInt(45) + 1;

            if (!lotto.contains(number)) {
                lotto.add(number);
            }
        }

        return lotto;
    }
}