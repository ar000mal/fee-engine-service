package com.bank.feeengine.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.feeengine.engine.RuleEngine;
import com.bank.feeengine.model.AccountContext;
import com.bank.feeengine.model.FeeResult;
import com.bank.feeengine.rule.FeeRule;

@Service
public class FeeCalculationService {

    private final RuleEngine ruleEngine;
    private final List<FeeRule> rules;

    public FeeCalculationService(RuleEngine ruleEngine, List<FeeRule> rules) {
        this.ruleEngine = ruleEngine;
        this.rules = rules;
    }

    public FeeResult calculateFee(AccountContext context) {

        // 🔥 SHORT-CIRCUIT RULE
        // Premium customers pay NO fees at all
        if ("PREMIUM".equalsIgnoreCase(context.getCustomerType())) {
            return new FeeResult(
                BigDecimal.ZERO,
                List.of("PREMIUM_CUSTOMER")
            );
        }

        BigDecimal totalFee = BigDecimal.ZERO;
        List<String> appliedRules = new ArrayList<>();

        for (FeeRule rule : rules) {
            if (ruleEngine.isApplicable(rule, context)) {
                BigDecimal fee = ruleEngine.apply(rule, context);
                totalFee = totalFee.add(fee);
                appliedRules.add(rule.getRuleCode());
            }
        }

        return new FeeResult(totalFee, appliedRules);
    }}
