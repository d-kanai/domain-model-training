package features.user;

import features.user.domain.User;
import features.user.domain.UserRepository;

public class UserDataBuilder {

    public User please() {
        User user = User.signup("kanai@test.com");
        new UserRepository().save(user);
        return user;
    }

}
