package concurrency;

import java.util.Random;

public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        Container container = new Container();
        Producer producer = new Producer(container);
        Consumer consumer = new Consumer(container);
        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }

    static class Container {
        Object value;
    }

    static class Producer extends Thread {
        Container container;

        public Producer(Container container) {
            this.container = container;
        }

        @Override
        public void run() {
            synchronized (container) {
                while (container.value != null) {
                    try {
                        container.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int random = new Random().nextInt();
                System.out.println("Producing " + random);
                container.value = random;
                container.notify();
            }
        }
    }

    static class Consumer extends Thread {
        Container container;

        public Consumer(Container container) {
            this.container = container;
        }

        @Override
        public void run() {
            synchronized (container) {
                while (container == null) {
                    try {
                        container.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("Consuming " + container.value);
                container.value = null;
                container.notify();
            }
        }
    }
}
