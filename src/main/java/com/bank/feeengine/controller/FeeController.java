package com.bank.feeengine.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.feeengine.model.AccountContext;
import com.bank.feeengine.model.FeeResult;
import com.bank.feeengine.service.FeeCalculationService;

@RestController
@RequestMapping("/fees")
public class FeeController {

    private final FeeCalculationService service;

    public FeeController(FeeCalculationService service) {
        this.service = service;
    }

    @PostMapping("/calculate")
    public FeeResult calculate(@RequestBody AccountContext context) {
        return service.calculateFee(context);
    }
}
