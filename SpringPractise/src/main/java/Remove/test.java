package Remove;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class test {
    public static void main(String[] args) {
            ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
            StringBuild stringBuild = context.getBean("stringBuild",StringBuild.class);
            System.out.println(stringBuild.getX());


    }
}
