package concurrency;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

import static concurrency.ThreadCoordinate5.count;

public class ThreadCoordinite7 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<File> files = Arrays.asList(new File("src/main/java/data/1.txt"), new File("src/main/java/data/2.txt"),
                new File("src/main/java/data/3.txt"));
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Map<String, Integer>> futher = pool.submit(new WordCount(files));
        System.out.println(futher.get());

    }
    static class WordCount extends RecursiveTask<Map<String, Integer>> {
        List<File> files;
        WordCount(List<File> files){
            this.files = files;
        }

        @Override
        protected Map<String, Integer> compute() {
            if(files.isEmpty()){
                return Collections.emptyMap();
            }
            try {
                Map<String, Integer> currentResult = count(files.get(0));
                Map<String, Integer> otherResult = new WordCount(files.subList(1,files.size())).compute();
                Map<String, Integer> sumResult = merge(currentResult, otherResult);
                System.out.println(sumResult);
                return sumResult;
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }

        }


    }
     static Map<String, Integer> merge(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>();
        Set<String> sets = new HashSet<>(map1.keySet());
        sets.addAll(map2.keySet());
        for(String key: sets){
            int value = map1.getOrDefault(key,0)+map2.getOrDefault(key,0);
            result.put(key, value);
        }
        return result;
    }
}
