package com.solutionresort.boilerplate;

import com.solutionresort.boilerplate.infrastructure.spring.ClassPathXmlApplicationContextFactory;
import org.apache.spark.sql.SparkSession;
import org.springframework.context.ApplicationContext;

public class App {
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = ClassPathXmlApplicationContextFactory.getOrCreate();

        SparkSession sparkSession = applicationContext.getBean(SparkSession.class);
        JavaRDD<String> lines = sparkSession.read().textFile(args[0]).javaRDD();
    }
}
