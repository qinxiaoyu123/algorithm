package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {
    static ExecutorService threadPool = Executors.newCachedThreadPool();
    static int i = 0;

    public static void main(String[] args) {
        new Thread(()->{
            //当前任务具体在哪个线程执行不一定，可能在主线程main，可能在threadPool里任何一个线程
            doSomething();
        }).start();
        doSomething();
    }

    private static void doSomething() {
        while(true){
            i++;
        }
    }
}
