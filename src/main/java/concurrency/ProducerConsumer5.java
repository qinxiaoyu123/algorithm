package concurrency;

import java.util.Random;
import java.util.concurrent.Exchanger;

public class ProducerConsumer5 {
    //Exchanger实现生产者消费者模型
    public static void main(String[] args) throws InterruptedException {
        Exchanger<Integer> exchanger = new Exchanger<>();
        Producer producer = new Producer(exchanger);
        Consumer consumer = new Consumer(exchanger);
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();

    }
    static class Producer extends Thread{
        Exchanger<Integer> exchanger;
        Producer(Exchanger exchanger){
            this.exchanger = exchanger;
        }
        @Override
        public void run(){
            try {
                int value = new Random().nextInt();
                System.out.println(value);
                System.out.println("Producing "+exchanger.exchange(value));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    static class Consumer extends Thread{
        Exchanger<Integer> exchanger;
        Consumer(Exchanger exchanger){
            this.exchanger = exchanger;
        }
        @Override
        public void run(){
            try {
                System.out.println("Consuming "+exchanger.exchange(null));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
