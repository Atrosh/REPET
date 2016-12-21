package by.repet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
@EnableConfigurationProperties
public class RepetApplication {

    //	public static void main(String[] args) {
//		SpringApplication.run(RepetApplication.class, args);
//	}
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(RepetApplication.class, args);
        System.out.println("Let's inspect the beans provided by Spring Boot:");

//        String[] beanNames = ctx.getBeanDefinitionNames();
//        Arrays.sort(beanNames);
//        Arrays.stream(beanNames).forEach(System.out::println);
//        for (String beanName : beanNames) {
//            System.out.println(beanName);
//        }
    }
}
