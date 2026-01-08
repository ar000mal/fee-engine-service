package com.bank.feeengine.rule;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.bank.feeengine.model.AccountContext;

@Component
public class PremiumCustomerRule implements FeeRule {

    @Override
    public boolean applies(AccountContext context) {
        return "PREMIUM".equalsIgnoreCase(context.getCustomerType());
    }

    @Override
    public BigDecimal calculateFee(AccountContext context) {
        return BigDecimal.ZERO;
    }

    @Override
    public String getRuleCode() {
        return "PREMIUM_CUSTOMER";
    }
}
