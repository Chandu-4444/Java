import java.util.*;
public class Same_Substring {
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        int l = 0;
        int r = input.length();
        if(input.charAt(0)==input.charAt(input.length()-2) && input.charAt(1)==input.charAt(input.length()-1))
        {
            l=2;
        }
        System.out.println(input.substring(l,r));


    }

}
