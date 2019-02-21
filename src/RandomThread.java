public class RandomThread implements Runnable {
    private String msg;

    public RandomThread(String msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Main.add(msg);
    }
}
