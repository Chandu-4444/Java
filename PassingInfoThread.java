import java.util.*;

public class PassingInfoThread {
    public static void main(String args[]) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        PassingInfoThread ob = new PassingInfoThread();
        for (int i = 0; i < 10; i++) {
            int n[] = new int[1];
            String ans[] = new String[2];
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {

                        ob.F1(in, n);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {

                    try {

                        // System.out.print("Entered!");
                        ob.F2(in, n);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            });

            t1.start();
            t2.start();

            t1.join();
            t2.join();
            System.out.println();
            System.out.println(n[0]);

        }

    }

    public synchronized void F1(Scanner in, int n[]) throws InterruptedException {

        System.out.print("Input: ");
        n[0] = in.nextInt();
        String s;
        s = Integer.toString(n[0]);
        StringBuilder sb = new StringBuilder(s);
        s = sb.reverse().toString();
        for (int i = 0; i < s.length(); i = i + 2) {
            System.out.print(s.charAt(i));
        }
        wait();

    }

    public synchronized void F2(Scanner in, int n[]) throws InterruptedException {

        String s = Integer.toString(n[0]);
        StringBuilder sb = new StringBuilder(s);
        s = sb.reverse().toString();
        String a = s;
        for (int i = 1; i < s.length(); i = i + 2) {
            System.out.print(s.charAt(i));
        }

        notify();

    }

}
