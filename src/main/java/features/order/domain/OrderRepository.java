package features.order.domain;

import shared.SqliteDatabase;

public class OrderRepository {
    public void save(Order order) {
        SqliteDatabase db = new SqliteDatabase();
        db.execute(String.format("insert into orders (id, userId, productId) values ('%s', '%s', '%s');",
                order.id(),
                order.userId(),
                order.productId()
        ));
    }
}
