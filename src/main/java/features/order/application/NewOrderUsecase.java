package features.order.application;

import features.order.domain.NewOrderService;
import features.product.presentation.ProductPurchaseInput;
import features.user.domain.StandardUser;
import features.user.domain.UserRepository;

import java.util.UUID;

public class NewOrderUsecase {

    private UserRepository userRepository;
    private NewOrderService newOrderService;

    public NewOrderUsecase() {
        userRepository = new UserRepository();
        newOrderService = new NewOrderService();
    }

    public void run(UUID loginUserId, ProductPurchaseInput input) {
        StandardUser user = userRepository.findStandardById(loginUserId);
        newOrderService.run(input.productId, user);
    }


}
