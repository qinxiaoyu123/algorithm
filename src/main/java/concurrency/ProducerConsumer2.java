package concurrency;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//通过Lock和Condition实现生产者和消费者模式
public class ProducerConsumer2 {
    private static Lock lock = new ReentrantLock();
    private static Condition queueEmpty = lock.newCondition();
    private static Condition queueFull = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        Queue<Integer> queue = new LinkedList<>();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }

    static class Producer extends Thread {
        Queue<Integer> queue;

        Producer(Queue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            lock.lock();
            try {
                while (queue.size() != 0) {
                    try {
                        queueEmpty.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int value = new Random().nextInt();
                System.out.println(Thread.currentThread().toString() + " " + value);
                queue.offer(value);
                queueFull.signal();
            } finally {
                lock.unlock();
            }

        }
    }

    static class Consumer extends Thread {
        Queue<Integer> queue;

        Consumer(Queue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            lock.lock();
            try {
                while (queue.size() == 0) {
                    try {
                        queueFull.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().toString() + " " + queue.poll());
                queueEmpty.signal();
            } finally {
                lock.unlock();
            }
        }
    }

}
