package features.moneyFlows.domain;

import features.product.domain.Product;

import java.util.UUID;

public class MoneyFlow {

    private final UUID id;
    private final UUID userId;
    private final int value;

    private MoneyFlow(UUID id, UUID userId, int value) {
        this.id = id;
        this.userId = userId;
        this.value = value;
    }

    public static MoneyFlow charge(UUID loginUserId, int value) {
        if (value < 0) {
            throw new RuntimeException("マイナス額はチャージできません");
        }
        return MoneyFlow.create(loginUserId, value);
    }

    private static MoneyFlow create(UUID loginUserId, int value) {
        return new MoneyFlow(UUID.randomUUID(), loginUserId, value);
    }

    public static MoneyFlow order(UUID userId, Product product) {
        return MoneyFlow.create(userId, -product.price());
    }

    public static MoneyFlow reconstruct(UUID id, UUID userId, int value) {
        return new MoneyFlow(id, userId, value);
    }

    public UUID id() {
        return id;
    }

    public UUID userId() {
        return userId;
    }

    public int value() {
        return value;
    }
}
