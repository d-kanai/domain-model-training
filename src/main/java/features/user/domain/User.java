package features.user.domain;

import java.util.UUID;

public class User {
    private final UUID uuid;
    private final String email;
    private final Plan plan;

    public enum Plan {
        NORMAL,
    }

    public User(UUID uuid, String email, Plan plan) {
        this.uuid = uuid;
        this.email = email;
        this.plan = plan;
    }

    public static User signup(String email) {
        return new User(UUID.randomUUID(), email, Plan.NORMAL);
    }

    public Plan plan() {
        return plan;
    }

    public String email() {
        return email;
    }
}
