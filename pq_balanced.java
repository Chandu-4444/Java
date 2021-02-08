import java.util.*;

public class pq_balanced
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        int index_p =-1;
        int index_q = -1;
        for(int i=0;i<input.length();i++)
        {
            if(input.charAt(i)=='q')
            {
                index_q = i;
                break;
            }
        }
        for(int i=input.length()-1;i>=0;i--)
        {
            if(input.charAt(i)=='p')
            {
                index_p = i;
                break;
            }
        }
        System.out.println(index_p<index_q?"True":"False");

    }
}