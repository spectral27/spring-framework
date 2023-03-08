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

    public List<Record> getRecords() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Record> records = entityManager
                .createQuery("select r from Record r", Record.class)
                .getResultList();

        entityManager.close();

        return records;
    }

    public void insertRecord() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Record r = new Record();
        r.setId(UUID.randomUUID().toString());

        entityManager.persist(r);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
