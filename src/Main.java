import org.w3c.dom.stylesheets.LinkStyle;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static List<String> digits = new LinkedList<>();
    public static synchronized void add(String s){
        digits.add(s);
    }
    public static synchronized String get(int index){
        return digits.get(index);
    }
    public static synchronized void clear(){
        digits.clear();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread my1 = new MyThread("1");
        Thread my2 = new MyThread("2");
        Thread my3 = new MyThread("3");
        Thread my4 = new Thread(new MyThread2("4"));
        Thread my5 = new Thread(new MyThread2("5"));
        Thread my6 = new Thread(new MyThread2("6"));
        Thread my7 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("7");
            }
        });
        my1.start();
        my2.start();
        my3.start();
        my4.start();
        my5.start();
        my6.start();
        my7.start();

        Thread.sleep(100);

        System.out.println("-------------------");

        System.out.println("How many digits in your number?");
        int d = new Scanner(System.in).nextInt();
        String result = "";
        for(int i = 0; i < d; i++){
            result += formRandomDigit(new Random().nextInt(15));
        }
        System.out.println(result);

    }

    private static String formRandomDigit(int index) {
        Thread[] threads = formDigits();
        startAllThreads(threads);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String out =  get(index);
        clear();
        return out;
    }

    private static Thread[] formDigits(){
        Thread[] out = new Thread[15];
        for(Integer i = 0; i < 10; i++){
            out[i] = new Thread(new RandomThread(i.toString()));
        }
        for(int i = 97; i < 102; i++){
            Character c = (char) i;
            out[i-87] = new Thread(new RandomThread(c.toString()));
        }
        return out;
    }

    private static void startAllThreads(Thread[] threads){
        for(Thread t : threads){
            t.start();
        }
    }
}
