package holopov.dev.dao;

import holopov.dev.entity.RecordStatus;
import org.springframework.stereotype.Repository;
import holopov.dev.entity.Record;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class RecordDao {
    private final List<Record> records = new ArrayList<>(
            Arrays.asList(
                    new Record("Take a shower", RecordStatus.ACTIVE),
                    new Record("Buy flowers", RecordStatus.DONE),
                    new Record("Go to the gym", RecordStatus.ACTIVE)
            )
    );

    public List<Record> findAllRecords() {
        return new ArrayList<>(records);
    }

    public void saveRecord(Record record) {
        records.add(record);
    }

    public void updateRecordStatus(int id, RecordStatus newStatus) {
        for (Record record : records) {
            if(record.getId() == id) {
                record.setStatus(newStatus);
                break;
            }
        }
    }

    public void deleteRecord(int id) {
        records.removeIf(record -> record.getId() == id);
    }
}
