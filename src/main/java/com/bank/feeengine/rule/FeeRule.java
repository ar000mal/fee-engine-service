package com.bank.feeengine.rule;

import java.math.BigDecimal;
import com.bank.feeengine.model.AccountContext;

public interface FeeRule {

    boolean applies(AccountContext context);

    BigDecimal calculateFee(AccountContext context);

    String getRuleCode();
}
