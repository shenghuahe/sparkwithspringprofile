package com.solutionresort.boilerplate;

import com.solutionresort.boilerplate.infrastructure.WordCounter;
import com.solutionresort.boilerplate.infrastructure.spring.ClassPathXmlApplicationContextFactory;
import org.springframework.context.ApplicationContext;
import scala.Tuple2;

import java.util.List;

// TO RUN on development, set -Dspring.profiles.active=development
public class App {
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = ClassPathXmlApplicationContextFactory.getOrCreate();

        WordCounter bean = applicationContext.getBean(WordCounter.class);

        List<Tuple2<String, Integer>> countBreakdown = bean.count();

        System.out.println(countBreakdown);
    }
}
