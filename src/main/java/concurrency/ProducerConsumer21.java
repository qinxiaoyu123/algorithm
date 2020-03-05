package concurrency;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer21 {
    //队列的最大容量
    private static int MAX_QUEUE_SIZE = 3;

    private static Lock lock = new ReentrantLock();
    private static Condition queueEmpty = lock.newCondition();
    private static Condition queueFull = lock.newCondition();
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger counter = new AtomicInteger(0);
        Queue<Integer> queue = new LinkedList<>();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        new Producer(queue).start();
        new Consumer(queue).start();
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }
    static class Producer extends Thread{
        Queue<Integer> queue;
        Producer(Queue<Integer> queue){
            this.queue = queue;
        }
        @Override
        public void run(){
            lock.lock();
            try{
                while(queue.size() > MAX_QUEUE_SIZE-1){
                    queueEmpty.await();
                }
                int value = new Random().nextInt();
                queue.offer(value);
                System.out.println(Thread.currentThread().getId()+" "+value);
                queueFull.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
    static class Consumer extends Thread{
        Queue<Integer> queue;
        Consumer(Queue<Integer> queue){
            this.queue = queue;
        }
        @Override
        public void run(){
            lock.lock();
            try{
                while(queue.size() == 0){
                    queueFull.await();
                }
                System.out.println(Thread.currentThread().getId()+" "+queue.poll());
                queueEmpty.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
