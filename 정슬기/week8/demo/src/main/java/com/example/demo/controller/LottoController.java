package com.example.demo.controller;

import com.example.demo.service.LottoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class LottoController{

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    @GetMapping("/lotto/generate")
    public List<Integer> lottoGenerate() {
        return lottoService.generateLotto();
    }
}
