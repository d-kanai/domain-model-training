package features.order.domain;

import features.product.domain.Product;

import java.util.UUID;

public class Order {

    private final UUID id;
    private final UUID productId;
    private final UUID userId;

    private Order(UUID id, UUID userId, UUID productId) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
    }

    static Order create(UUID userId, Product product) {
        return new Order(UUID.randomUUID(), userId, product.id());
    }

    public UUID id() {
        return id;
    }
    public UUID userId() {
        return userId;
    }


    public UUID productId() {
        return productId;
    }
}
