package concurrency;

public class DeadLock {
    static Object lock1 = new Object();
    static Object lock2 = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread newThread1 = new Thread(() -> {
            synchronized (lock1) {
                try {
                    Thread.sleep(10000);
                    synchronized (lock2) {
                        System.out.println(" lock2 ");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        newThread1.start();

        synchronized (lock2) {
            Thread.sleep(10000);
            synchronized (lock1) {
                System.out.println(" lock1 ");
            }
        }
    }
}
