package concurrency;



import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadCoordinate {
    public static void main(String[] args) throws InterruptedException {
        //加join实现协同
        ConcurrentHashMap<Integer, Integer> results = new ConcurrentHashMap<>();
        List<Thread> threads = new LinkedList<>();
        for(int i = 0;i<10;i++){
            Thread t = new Thread(()->{
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int value = new Random().nextInt();
                results.put(value, value);
            });
            threads.add(t);
            t.start();
        }
        Iterator<Thread> iter = threads.iterator();
        while(iter.hasNext()){
            iter.next().join();
        }
        System.out.println(results);
    }
}
