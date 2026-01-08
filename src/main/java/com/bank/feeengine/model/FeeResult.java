package com.bank.feeengine.model;

import java.math.BigDecimal;
import java.util.List;

public class FeeResult {

    private BigDecimal totalFee;
    private List<String> appliedRules;

    public FeeResult(BigDecimal totalFee, List<String> appliedRules) {
        this.totalFee = totalFee;
        this.appliedRules = appliedRules;
    }

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public List<String> getAppliedRules() {
        return appliedRules;
    }
}
