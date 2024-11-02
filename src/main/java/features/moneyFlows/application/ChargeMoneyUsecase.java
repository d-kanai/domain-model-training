package features.moneyFlows.application;

import features.moneyFlows.domain.MoneyFlow;
import features.moneyFlows.domain.MoneyFlowRepository;
import features.moneyFlows.presentation.ChargeMoneyInput;

import java.util.UUID;

public class ChargeMoneyUsecase {
    //new
    public void run(UUID userId, ChargeMoneyInput input) {
        MoneyFlow moneyFlow = MoneyFlow.charge(userId, input.getValue());
        new MoneyFlowRepository().save(moneyFlow);
    }
    //old
    public void run(ChargeMoneyInput input) {
        run(UUID.randomUUID(), input);
    }
}