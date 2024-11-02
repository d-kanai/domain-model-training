package features.order.domain;

import features.moneyFlows.domain.MoneyFlow;
import features.moneyFlows.domain.MoneyFlows;
import features.product.domain.PublishedProduct;

import java.util.UUID;

public class OrderFactory {
    private final UUID loginUserId;
    private final MoneyFlows moneyFlows;
    private final PublishedProduct product;

    public OrderFactory(UUID loginUserId, MoneyFlows moneyFlows, PublishedProduct product) {
        this.loginUserId = loginUserId;
        this.moneyFlows = moneyFlows;
        this.product = product;
    }

    public Ordered create() {
        if (moneyFlows.sum() < product.price()) throw new RuntimeException("お金が足りません");
        Order order = Order.create(loginUserId, product);
        MoneyFlow moneyFlow = MoneyFlow.order(loginUserId, product);
        return new Ordered(order, moneyFlow);
    }
}
