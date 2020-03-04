package concurrency;

public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException e");
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        Thread.sleep(500);
        thread1.interrupt();
    }
}
