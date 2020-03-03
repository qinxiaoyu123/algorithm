package test;

public class Main {
    public static void main(String[] args) {
        //lambda表达式
        new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        a();
    }

    private static void a() {
        int i = 0;
        i++;
        b();
    }

    private static void b() {
        c();
    }

    private static void c() {
        d();
    }

    private static void d() {
    }
}
