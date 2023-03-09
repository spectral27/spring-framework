package spc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        RecordRepository recordRepository = context.getBean(RecordRepository.class);

        recordRepository.insertRecord();

        List<RecordObject> records = recordRepository.getRecords();

        for (int i = 0; i < records.size(); i++) {
            System.out.println(records.get(i).getId());
        }
    }

}
