package features.user;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public static List<User> records = new ArrayList();

    public boolean save(User user) {
        records.add(user);
        return true;
    }
}
