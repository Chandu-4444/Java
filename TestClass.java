import java.awt.*;
import java.util.List;
import java.util.Scanner;


public class TestClass {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        String arr[] = new String[s.length()-k+1];

        for(int i=0;i+k<s.length()+1;i++)
        {
            arr[i] = s.substring(i,i+k);
        }
        String sm = arr[0];
        String la = arr[0];
        for(int i=0;i<arr.length;i++)
        {
            if(sm.compareTo(arr[i])>0)
            {
                sm=arr[i];
            }
            if(la.compareTo(arr[i])<0)
            {
                la=arr[i];
            }
        }
        smallest=sm;
        largest=la;



        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}