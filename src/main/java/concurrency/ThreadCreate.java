package concurrency;

public class ThreadCreate {
    public static void main(String[] args) throws InterruptedException {
        Thread threadNew = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("I am interrupted!");
                    e.printStackTrace();
                }
            }
        });
        threadNew.start();
        Thread.sleep(500);
        threadNew.interrupt();
//        new Thread(()->{
//            try {
//                Thread.sleep(60000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//        new Thread(){
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(600000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }.start();
    }
}
