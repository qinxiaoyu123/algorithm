package concurrency;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class ProducerConsumer3 {
    private static Semaphore fullSlot = new Semaphore(0);
    private static Semaphore emptySlot = new Semaphore(1);

    public static void main(String[] args) throws InterruptedException {
        Queue<Integer> queue = new LinkedList<>();
        Producer producer = new Producer(queue);
        producer.start();
        Consumer consumer = new Consumer(queue);
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
            try {
                emptySlot.acquire();
                synchronized (ProducerConsumer3.class) {
                    int value = new Random().nextInt();
                    System.out.println("Producing " + value);
                    queue.offer(value);
                }
                fullSlot.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
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
            try {
                fullSlot.acquire();
                synchronized (ProducerConsumer3.class) {
                    System.out.println("Consuming " + queue.poll());
                }
                emptySlot.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
