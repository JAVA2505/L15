public class MyThread extends Thread {
    private String msg;

    public MyThread(String msg) {
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
