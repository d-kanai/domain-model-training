package features.moneyFlows.domain;

import shared.Records;
import shared.SqliteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class MoneyFlowRepository {

    SqliteDatabase db = new SqliteDatabase();

    public void save(MoneyFlow moneyFlow) {
        db.execute(String.format("insert into moneyFlows (id, userId, value) values ('%s', '%s', '%d');",
                moneyFlow.id(),
                moneyFlow.userId(),
                moneyFlow.value()
        ));
    }

    public MoneyFlows findByUserId(UUID loginUserId) {
        Records records = db.find(String.format("select * from moneyFlows where userId = '%s'", loginUserId.toString()));
        List<MoneyFlow> moneyFlowList = new ArrayList<>();
        records.items.forEach(record -> {
            Map mapRecord = (Map) record;
            moneyFlowList.add(MoneyFlow.reconstruct
                    (
                            UUID.fromString((String) mapRecord.get("id")),
                            UUID.fromString((String) mapRecord.get("userId")),
                            (Integer) mapRecord.get("value")
                    )
            );
        });
        return new MoneyFlows(moneyFlowList);
    }
}
