package features.moneyFlow;

import features.moneyFlows.domain.MoneyFlow;
import features.moneyFlows.domain.MoneyFlowRepository;

import java.util.UUID;

public class MoneyFlowDataBuilder {
    private int value = 1000;

    public MoneyFlow please() {
        MoneyFlow moneyFlow = MoneyFlow.charge(UUID.randomUUID(), value);
        new MoneyFlowRepository().save(moneyFlow);
        return moneyFlow;
    }

    public MoneyFlowDataBuilder value(int value) {
        this.value = value;
        return this;
    }
}
