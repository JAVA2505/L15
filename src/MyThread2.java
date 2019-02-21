public class MyThread2 implements Runnable{
    private String msg;

    public MyThread2(String msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(msg);
    }
}
