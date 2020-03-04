package concurrency;

public class VolatileTest {
    static final int i = 0;
    static volatile boolean initializationFinished = false;

    public static void main(String[] args) {
        init();

        initializationFinished = true;

        new Thread(()->{
            while(true){
                if(initializationFinished){
                    doSomething();
                    break;
                }
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }).start();
    }

    private static void doSomething() {
    }

    private static void init() {
        //do something init
    }
}
