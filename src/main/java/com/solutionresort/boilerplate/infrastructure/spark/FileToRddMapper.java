package com.solutionresort.boilerplate.infrastructure.spark;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.SparkSession;

public class FileToRddMapper {

    private final String inputLocation;
    private final SparkSession sparkSession;

    public FileToRddMapper(
        String inputLocation,
        SparkSession sparkSession
    ) {
        this.inputLocation = inputLocation;
        this.sparkSession = sparkSession;
    }

    public JavaRDD<String> map() {

        return sparkSession.
            read().
            textFile(inputLocation).
            javaRDD();
    }
}
