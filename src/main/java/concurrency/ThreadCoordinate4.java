package concurrency;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class ThreadCoordinate4 {
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        //加 CyclicBarrier 实现线程的协同
        ConcurrentHashMap<Integer, Integer> results = new ConcurrentHashMap<>();
        //因为加上主线程一共有11个线程
        CyclicBarrier barrier = new CyclicBarrier(11);
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int value = new Random().nextInt();
                results.put(value, value);
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
            t.start();
        }
        barrier.await();
        System.out.println(results);
    }
}
