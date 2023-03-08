package spc;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.UUID;

public class RecordRepository {

    private final SessionFactory sessionFactory;

    public RecordRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Record> getRecords() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Record> records = session
                .createQuery("select r from Record r", Record.class)
                .list();

        session.getTransaction().commit();
        session.close();

        return records;
    }

    public void insertRecord() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Record r = new Record();
        r.setId(UUID.randomUUID().toString());

        session.persist(r);
        session.getTransaction().commit();
        session.close();
    }

}
