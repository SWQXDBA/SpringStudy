package frank;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new
                ClassPathXmlApplicationContext("applications.xml");
        Object o = context.getBean("person1");
        System.out.println(o.getClass());
        System.out.println(o);
    }
}
