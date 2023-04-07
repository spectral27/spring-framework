package spc;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");
        TestBean testBean = context.getBean("testBean", TestBean.class);
        testBean.start();
    }

}
