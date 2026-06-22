package com.example.demo.Service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class LottoService {
    public List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();
        Random random = new Random();

        while (lottoNumbers.size()<6){
            int number = random.nextInt(45) + 1;

            if(!lottoNumbers.contains(number)){
                lottoNumbers.add(number);
            }
        }
        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }
}
