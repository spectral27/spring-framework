package spc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MainTest {

    private static ApplicationContext applicationContext;

    @BeforeAll
    public static void createContext() {
        applicationContext = new ClassPathXmlApplicationContext("beans.xml");
    }

    @Test
    public void mainTest() {
        RecordRepository recordRepository = applicationContext.getBean(RecordRepository.class);
        recordRepository.insertRecord();
        List<Record> records = recordRepository.getRecords();
        Assertions.assertNotNull(records);
        Assertions.assertEquals(1, records.size());
        Assertions.assertNotNull(records.get(0).getId());
    }

}
