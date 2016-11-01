package pkg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import pkg.service.TestService;

import java.util.Arrays;

/**
 * Created by dima on 10/22/16.
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) throws ClassNotFoundException {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }

        TestService testService = (TestService) ctx.getBean("testServiceImpl");
        testService.outerMethod(0L, 1L);
    }

}