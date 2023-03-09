package spc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        RecordRepository recordRepository = context.getBean(RecordRepository.class);

        System.out.println("INSERT");
        recordRepository.insertRecord();

        System.out.println("SELECT");
        List<RecordObject> records = recordRepository.getRecords();

        records.forEach(r -> System.out.println(r.getId()));

        String recordId = records.get(0).getId();

        System.out.println("UPDATE");
        recordRepository.updateRecord(recordId);

        System.out.println("DELETE");
        recordRepository.deleteRecord(recordId);
    }

}
