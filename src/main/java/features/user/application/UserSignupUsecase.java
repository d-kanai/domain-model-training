package features.user.application;

import features.product.domain.DraftProduct;
import features.product.domain.ProductRepository;
import features.product.domain.PublishedProduct;
import features.product.presentation.ProductPublishInput;
import features.user.domain.User;
import features.user.domain.UserRepository;

public class UserSignupUsecase {


    public void run(UserSignupInput input) {
        User user = User.signup(input.getEmail());
        new UserRepository().save(user);
    }
}
