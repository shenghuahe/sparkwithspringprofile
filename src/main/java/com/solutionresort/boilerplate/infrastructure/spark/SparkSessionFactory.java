package com.solutionresort.boilerplate.infrastructure.spark;

import org.apache.spark.sql.SparkSession;

public class SparkSessionFactory {

    private final String appName;
    private final String masterUrl;

    public SparkSessionFactory(
        String appName,
        String masterUrl
    ) {
        this.appName = appName;
        this.masterUrl = masterUrl;
    }

    public SparkSession create() {

        return SparkSession
            .builder()
            .appName(appName)
            .master(masterUrl)
            .getOrCreate();
    }
}
