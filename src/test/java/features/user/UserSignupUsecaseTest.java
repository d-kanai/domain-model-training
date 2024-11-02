package features.user;

import features.product.ProductDataBuilder;
import features.product.application.ProductPublishUsecase;
import features.product.domain.Product;
import features.product.presentation.ProductPublishInput;
import features.user.application.UserSignupInput;
import features.user.application.UserSignupUsecase;
import helpers.BaseTest;
import org.junit.jupiter.api.Test;
import shared.Records;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class UserSignupUsecaseTest extends BaseTest {

    @Test
    void signup() {
        //given
        UserSignupInput input = new UserSignupInput("kanai@test.com");
        //when
        new UserSignupUsecase().run(input);
        //then
        Records records = db.find("select * from users");
        assertEquals(1, records.size());
    }

}

