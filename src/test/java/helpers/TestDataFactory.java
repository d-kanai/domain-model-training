package helpers;

import features.moneyFlow.domain.MoneyFlow;
import features.moneyFlow.domain.MoneyFlowRepository;
import features.order.domain.Order;
import features.order.domain.OrderRepository;
import features.product.domain.ProductStatus;
import features.user.domain.User;
import features.user.domain.UserPlan;
import features.user.domain.UserRepository;
import features.user.presentation.SignupInput;
import features.product.domain.Product;
import features.product.domain.ProductRepository;

import java.util.Arrays;
import java.util.UUID;

//TODO: Builderにして分ける、重複排除
public class TestDataFactory {

    public static Product createDraftProduct(UUID userId) {
        Product product = Product.reconstruct(
                UUID.randomUUID(),
                userId,
                ProductStatus.DRAFT,
                "book",
                1000
        );
        ProductRepository.records = Arrays.asList(product);
        return product;
    }
    public static Product createPublishedProduct(UUID userId) {
        Product product = Product.reconstruct(
                UUID.randomUUID(),
                userId,
                ProductStatus.PUBLISHED,
                "book",
                1000
        );
        ProductRepository.records = Arrays.asList(product);
        return product;
    }

    public static User createUser() {
        User user = User.reconstruct(
                UUID.randomUUID(),
                "tanaka",
                UserPlan.STANDARD
        );
        UserRepository.records.add(user);
        return user;
    }

    public static User createVipUser() {
        User user = User.reconstruct(
                UUID.randomUUID(),
                "tanaka",
                UserPlan.VIP
        );
        UserRepository.records.add(user);
        return user;
    }

    public static boolean createMoneyFlow(UUID userId) {
        MoneyFlow moneyFlow = MoneyFlow.reconstruct(
                UUID.randomUUID(),
                userId,
                10000
        );
        return MoneyFlowRepository.records.add(moneyFlow);
    }

    public static Order createOrder(UUID userId, Product product) {
        Order order = Order.reconstruct(
                UUID.randomUUID(),
                userId,
                product
        );
        OrderRepository.records.add(order);
        return order;
    }
}
