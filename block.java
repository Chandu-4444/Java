class Calculate {

    synchronized public int getAns(int n, int k) {
        if (n % k == 0) {
            return 1;
        }
        return 0;
    }
}

class Driver extends Thread {
    int j;
    int num;
    Calculate cal;
    Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                if (cal.getAns(num, 3) == 1) {
                    j = num;
                    wait();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });

    Thread t2 = new Thread(new Runnable() {
        
        @Override
        public void run() {
            try {
                if (cal.getAns(j, 5) == 1) {
                    System.out.println(j);
                    notify();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });

    public void Ready() throws InterruptedException {
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

}

class block {
    public static void main(String[] args) {

        Driver div3 = new Driver();
        try {
            for (int i = 0; i < 10; i++) {
                div3.num = i;
                div3.Ready();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}