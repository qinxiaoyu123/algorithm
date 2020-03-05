package concurrency;

import java.io.File;
import java.nio.file.Files;
import java.util.*;
import java.util.concurrent.*;

public class ThreadCoordinite6 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<File> files = Arrays.asList(new File("src/main/java/data/1.txt"), new File("src/main/java/data/2.txt"), new File("src/main/java/data/3.txt"));
        ExecutorService threadPool = new ThreadPoolExecutor(3,3,0L,TimeUnit.SECONDS, new LinkedBlockingQueue<>(),
                (runnable) ->{
                    Thread t = new Thread(runnable, "MyThread");
                    t.setDaemon(true);
                    return t;
                }, new ThreadPoolExecutor.DiscardPolicy());
        List<Future<Map<String, Integer>>> futures = new ArrayList<>();
        for(File file : files){
            Future<Map<String, Integer>> future = threadPool.submit(new ThreadCoordinate5.WordCount(file));
            futures.add(future);
        }
        Map<String, Integer> finalResult = new HashMap<>();
        for(Future<Map<String, Integer>> future :futures){
            System.out.println(future.get());
            merge(finalResult, future.get());
        }
        System.out.println(finalResult);
    }

    private static  void merge(Map<String, Integer> map1, Map<String, Integer> map2) {
        Set<String> sets = new HashSet<>(map1.keySet());
        sets.addAll(map2.keySet());
        for(String key: sets){
            int value = map1.getOrDefault(key,0)+map2.getOrDefault(key,0);
            map1.put(key, value);
        }
    }

    static class WordCount implements Callable<Map<String, Integer>> {
        File file;
        WordCount(File file){
            this.file = file;
        }
        @Override
        public Map<String, Integer> call() throws Exception {
            Map<String, Integer> wordToCountMap = new HashMap<>();
            List<String> lines = Files.readAllLines(file.toPath());
            for(String line: lines){
                for(String s: line.split("\\s+")){
                    wordToCountMap.put(s,wordToCountMap.getOrDefault(s,0)+1);
                }
            }
            return wordToCountMap;
        }
    }

}
