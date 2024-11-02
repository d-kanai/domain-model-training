package features.moneyFlows.domain;

import features.product.domain.Product;

import java.util.UUID;

public class MoneyFlow {

    private final UUID id;
    private final UUID userId;
    private final int value;

    private MoneyFlow(UUID id, int value) {
        this.id = id;
        this.userId = UUID.randomUUID();
        this.value = value;
    }

    private MoneyFlow(UUID id, UUID userId, int value) {
        this.id = id;
        this.userId = userId;
        this.value = value;
    }

    public static MoneyFlow charge(UUID userId, int value) {
        if (value < 0) {
            throw new RuntimeException("マイナス額はチャージできません");
        }
        return MoneyFlow.create__New(userId, value);
    }

    @Deprecated
    private static MoneyFlow create__Old(int value) {
        return new MoneyFlow(UUID.randomUUID(), value);
    }

    private static MoneyFlow create__New(UUID userId, int value) {
        return new MoneyFlow(UUID.randomUUID(), userId, value);
    }

    public static MoneyFlow order(Product product) {
        return MoneyFlow.create__Old(-product.price());
    }

    public static MoneyFlow reconstruct(UUID id, int value) {
        return new MoneyFlow(id, value);
    }

    public UUID id() {
        return id;
    }

    public int value() {
        return value;
    }

    public UUID userId() {
        return userId;
    }
}
