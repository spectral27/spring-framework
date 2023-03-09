package spc;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;
import java.util.UUID;

public class RecordRepository {

    private final EntityManagerFactory entityManagerFactory;

    public RecordRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public List<RecordObject> getRecords() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<RecordObject> records = entityManager
                .createQuery("select r from RecordObject r", RecordObject.class)
                .getResultList();

        entityManager.close();

        return records;
    }

    public void insertRecord() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        RecordObject r = new RecordObject();
        r.setId(UUID.randomUUID().toString());
        r.setRecordValue("insertValue");

        entityManager.persist(r);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void updateRecord(String id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        RecordObject r = entityManager.find(RecordObject.class, id);
        r.setRecordValue("updateValue");

        entityManager.merge(r);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void deleteRecord(String id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        RecordObject r = entityManager.find(RecordObject.class, id);

        entityManager.remove(r);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
