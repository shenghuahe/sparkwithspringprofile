package com.solutionresort.boilerplate.infrastructure.spark;

import org.apache.spark.sql.SparkSession;

public class SparkSessionFactory {

    private final String appName;

    public SparkSessionFactory(String appName) {
        this.appName = appName;
    }

    public SparkSession create() {

        return SparkSession
                .builder()
                .appName(appName)
                .getOrCreate();
    }
}
