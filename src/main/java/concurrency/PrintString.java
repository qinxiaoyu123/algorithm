package concurrency;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintString {
    static Lock lock = new ReentrantLock();
    static Condition conditionPrint = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        String s = "abcdefg";
        int n = s.length();
        Queue<Character> queue = new LinkedList<>();
        Queue<Integer> queue1 = new LinkedList<>();
        queue1.offer(1);
        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < n; i++) {
                queue.offer(s.charAt(i));
            }
        }
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        threadPool.submit(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        while (queue1.size() == 0) {
                            conditionPrint.await();
                        }
                        queue1.offer(new Random().nextInt());
                        System.out.println(queue.poll());
                        conditionPrint.signalAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }

            }
        });


    }
}

//    String s = "abcdefg";
//    int n = s.length();
//    LinkedBlockingQueue<Character> queue = new LinkedBlockingQueue<>();
//        for(int k = 0; k<2;k++){
//        for(int i = 0; i<n; i++){
//        queue.put(s.charAt(i));
//        }
//        }
//        ExecutorService threadPool = Executors.newFixedThreadPool(3);
//        threadPool.submit(new Runnable() {
//@Override
//public void run() {
//        while(true){
//        try {
//        System.out.println(Thread.currentThread().getName()+" "+queue.take());
//        } catch (InterruptedException e) {
//        e.printStackTrace();
//        }
//        }
//        }
//        });
