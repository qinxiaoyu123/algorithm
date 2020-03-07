package concurrency;

public class Main {
    public static void main(String[] args) {
        Object i = new Object();
        System.out.println(i);
        a(i);
        //lambda表达式
//        new Thread() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        a();
    }

    private static void a(Object i) {
        System.out.println(i);
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
