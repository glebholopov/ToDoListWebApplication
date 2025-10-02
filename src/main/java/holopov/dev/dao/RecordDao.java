package holopov.dev.dao;

import holopov.dev.entity.RecordStatus;
import org.springframework.stereotype.Repository;
import holopov.dev.entity.Record;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class RecordDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Record> findAllRecords() {
        Query query = entityManager.createQuery("SELECT r FROM Record r ORDER BY r.id ASC");
        List<Record> records = query.getResultList();
        return records;
    }

    public void saveRecord(Record record) {
        entityManager.persist(record);
    }

    public void updateRecordStatus(int id, RecordStatus newStatus) {
        Query query = entityManager.createQuery("UPDATE Record SET status = :status WHERE id = :id");
        query.setParameter("status", newStatus);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public void deleteRecord(int id) {
        Query query = entityManager.createQuery("DELETE FROM Record WHERE id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
