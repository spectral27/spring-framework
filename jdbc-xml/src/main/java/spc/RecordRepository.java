package spc;

import jdk.jfr.consumer.RecordedObject;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.UUID;

public class RecordRepository {

    private final JdbcTemplate jdbcTemplate;

    public RecordRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insertRecord() {
        this.jdbcTemplate.update(
                "insert into records (id) values (?)",
                UUID.randomUUID().toString());
    }

    public List<RecordObject> getRecords() {
        List<RecordObject> records = jdbcTemplate.query(
                "select * from records",
                (resultSet, rowNum) -> {
                    RecordObject r = new RecordObject();
                    r.setId(resultSet.getString("id"));
                    return r;
                });

        return records;
    }

}
