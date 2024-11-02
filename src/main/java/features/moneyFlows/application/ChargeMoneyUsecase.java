package features.moneyFlows.application;

import features.moneyFlows.domain.MoneyFlow;
import features.moneyFlows.domain.MoneyFlowRepository;
import features.moneyFlows.presentation.ChargeMoneyInput;

import java.util.UUID;

public class ChargeMoneyUsecase {
    public void run(UUID loginUserId, ChargeMoneyInput input) {
        MoneyFlow moneyFlow = MoneyFlow.charge(loginUserId, input.getValue());
        new MoneyFlowRepository().save(moneyFlow);
    }
}