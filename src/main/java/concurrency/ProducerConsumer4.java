package concurrency;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumer4 {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(3);
        Producer producer = new Producer(queue);
        Producer producer1 = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        Consumer consumer1 = new Consumer(queue);
        producer.start();
        consumer.start();
        producer1.start();
        consumer1.start();

        producer.join();
        consumer.join();
        producer1.join();
        consumer1.join();
    }

    static class Producer extends Thread {
        private LinkedBlockingQueue<Integer> queue;

        Producer(LinkedBlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                while(true){
                    Thread.sleep(1000);
                    int value = new Random().nextInt();
                    queue.put(value);
                    System.out.println(Thread.currentThread().getName()+" Producing "+value);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    static class Consumer extends Thread {
        private LinkedBlockingQueue<Integer> queue;

        Consumer(LinkedBlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                while(true){
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName()+" Consuming "+queue.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
