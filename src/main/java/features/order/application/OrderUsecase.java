package features.order.application;

import features.moneyFlows.domain.MoneyFlowRepository;
import features.moneyFlows.domain.MoneyFlows;
import features.order.domain.OrderFactory;
import features.order.domain.OrderRepository;
import features.order.domain.Ordered;
import features.order.presentation.OrderCreateInput;
import features.product.domain.ProductRepository;
import features.product.domain.PublishedProduct;

import java.util.UUID;

public class OrderUsecase {

    public void run(UUID loginUserId, OrderCreateInput input) {
        PublishedProduct product = new ProductRepository().findPublishedById(input.getProductId());
        MoneyFlows moneyFlows = new MoneyFlowRepository().findByUserId(loginUserId);

        Ordered ordered = new OrderFactory(loginUserId, moneyFlows, product).create();

        new OrderRepository().save(ordered.order);
        new MoneyFlowRepository().save(ordered.moneyFlow);
    }


}
