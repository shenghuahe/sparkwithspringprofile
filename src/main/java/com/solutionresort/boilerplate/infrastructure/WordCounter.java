package com.solutionresort.boilerplate.infrastructure;

import com.solutionresort.boilerplate.infrastructure.spark.FileToRddMapper;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class WordCounter {

    private static final Pattern SPACE = Pattern.compile(" ");
    private final FileToRddMapper fileToRddMapper;

    public WordCounter(
        FileToRddMapper fileToRddMapper
    ) {
        this.fileToRddMapper = fileToRddMapper;
    }

    public List<Tuple2<String, Integer>> count() {

        JavaRDD<String> lines = fileToRddMapper.map();
        JavaRDD<String> words = lines.flatMap(
            line ->
                Arrays.
                    asList(
                        SPACE.split(line)
                    ).
                    iterator()
        );

        JavaPairRDD<String, Integer> singleWordPairs = words.
            mapToPair(
                word ->
                    new Tuple2<>(word, 1)
            );

        JavaPairRDD<String, Integer> countedWordPairs = singleWordPairs.
            reduceByKey(
                (integer, integer2) ->
                    integer + integer2
            );

        return countedWordPairs.collect();
    }
}
