import java.util.*;

public class MulThread {
    public static void main(String args[]) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        MulThread ob = new MulThread();
        System.out.print("Input: ");
        int n =in.nextInt();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    
                    String s;
              
                    s = Integer.toString(n);
                    ob.F1(s);
                    
                    

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    String s = Integer.toString(n);
                    ob.F2(s);
                    
                   

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

    }
    public void F1(String s) throws InterruptedException
    {
        synchronized (this) {
           
            StringBuilder sb = new StringBuilder(s);
            s = sb.reverse().toString();
            for (int i = 0; i < s.length(); i = i + 2) {
                System.out.print(s.charAt(i));
            }
            wait();
        }

    }

    public void F2(String s) throws InterruptedException
    {
        synchronized (this) {
            
            StringBuilder sb = new StringBuilder(s);
            s = sb.reverse().toString();
            for (int i = 1; i < s.length(); i = i + 2) {
                System.out.print(s.charAt(i));
            }
            notify();
        }


    }

}
