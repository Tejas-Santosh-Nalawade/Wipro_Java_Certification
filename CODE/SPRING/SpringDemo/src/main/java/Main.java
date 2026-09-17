import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext 	 =
                new ClassPathXmlApplicationContext("bean.xml");

        Student student = context.getBean("student", Student.class);

        student.display();
    }
}