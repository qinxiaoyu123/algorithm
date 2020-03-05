package concurrency;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadCoordinate2 {
    public static void main(String[] args) {
        //加lock+condition实现线程的协同
        ConcurrentHashMap<Integer, Integer> results = new ConcurrentHashMap<>();
        Lock lock = new ReentrantLock();
        Condition allThreadFinished = lock.newCondition();
        AtomicInteger counter = new AtomicInteger(10);
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int value = new Random().nextInt();
                results.put(value, value);
                counter.decrementAndGet();
                lock.lock();
                try {
                    allThreadFinished.signalAll();
                } finally {
                    lock.unlock();
                }

            });
            t.start();
        }
        lock.lock();
        try {
            while (counter.get() != 0) {
                allThreadFinished.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        System.out.println(results);
    }
}
