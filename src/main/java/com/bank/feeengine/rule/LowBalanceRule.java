package com.bank.feeengine.rule;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.bank.feeengine.model.AccountContext;

@Component
public class LowBalanceRule implements FeeRule {

    @Override
    public boolean applies(AccountContext context) {
        return context.getBalance().compareTo(new BigDecimal("5000")) < 0;
    }

    @Override
    public BigDecimal calculateFee(AccountContext context) {
        return new BigDecimal("100");
    }

    @Override
    public String getRuleCode() {
        return "LOW_BALANCE_FEE";
    }
}
