package com.bank.feeengine.engine;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.bank.feeengine.model.AccountContext;
import com.bank.feeengine.rule.FeeRule;

@Component
public class RuleEngine {

    public boolean isApplicable(FeeRule rule, AccountContext context) {
        return rule.applies(context);
    }

    public BigDecimal apply(FeeRule rule, AccountContext context) {
        return rule.calculateFee(context);
    }
}
