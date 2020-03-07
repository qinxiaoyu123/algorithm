package concurrency;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

import static concurrency.ThreadCoordinate5.count;
import static concurrency.ThreadCoordinite7.merge;

public class ThreadCoordinate8 {
    public static void main(String[] args) {
        List<File> files = Arrays.asList(new File("src/main/java/data/1.txt"), new File("src/main/java/data/2.txt"),
                new File("src/main/java/data/3.txt"));
        Map<String, Integer> finalResult = new HashMap<>();
        List<Map<String, Integer>> results = new ArrayList<>();
        files.parallelStream().forEach(file -> {
            try {
                Map<String, Integer> result = count(file);
                results.add(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        for(Map<String, Integer> result:results){
            finalResult.putAll(merge(finalResult, result));
        }
        System.out.println(finalResult);
    }
}
