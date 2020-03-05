package concurrency;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadCoordinate3 {
    public static void main(String[] args) throws InterruptedException {
        //加CountDownLatch实现线程的协同
        ConcurrentHashMap<Integer, Integer> results = new ConcurrentHashMap<>();
        CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int value = new Random().nextInt();
                results.put(value, value);
                latch.countDown();
            });
            t.start();
        }
        latch.await();
        System.out.println(results);
    }
}
