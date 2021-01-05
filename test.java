import java.io.*;
import java.util.*;

class test {
    public void process() throws NumberFormatException, IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int saveN = n;
            int p = 0;
            int count = 0;
            while (count < 4) {
                p <<= 8;
                int lastEightBits = (n&255);
                n >>= 8;
                p += lastEightBits;
                count++;
            }
            bw.write(saveN+" converts to "+p+"\n");          
        }                    
        bw.flush();
        bw.close();
        return;
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        test m = new test();
        m.process();
        System.exit(0);
    }
}