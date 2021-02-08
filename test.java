import java.util.*;
public class test{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0)
        {
            int n = in.nextInt();
            int k = in.nextInt();
            if(n==k)
            {
                System.out.println("1");
            }
            else if(n<=k)
            {
                int ans = k/n + k%n;
                System.out.println(ans);
            }
            else
            {
                if(n%k==0)
                {
                    System.out.println("1");
                }
                else
                {
                    int val = n+k;
                    for(int i = val;i>=0;i--)
                    {
                        if(val%k==0)
                        {
                            break;
                        }
                        val = val-1;
                    }

                }
            }

        }
    }
}