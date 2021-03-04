
import java.util.*;


class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long a[] = new long[n];
        for(int i=0;i<n;i++)
        {
            a[i] = in.nextLong();
        }
        int lar_pos[] = new int[n];
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(a[i]<a[j])
                {
                    lar_pos[i] = j;
                    break;
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            if(lar_pos[i]==0)
            {
                lar_pos[i] = -1;
            }
        }
        for(int i: lar_pos)
        {
            System.out.print(i+" ");
        }
        System.out.println();
        int les_pos[] = new int[n];
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(lar_pos[i]==-1)
                {
                    les_pos[i] = -1;
                    break;
                }
                else if(a[lar_pos[i]]>a[j])
                {
                    les_pos[i] = j;
                    break;
                }
            
            }

        }
        for(int i: les_pos)
        {
            System.out.print(i+" ");
        }
        System.out.println();
        for(int i=0;i<n;i++)
        {
            if(les_pos[i]==-1)
            {
                System.out.print("-1 ");
            }
            else{
                System.out.print(a[les_pos[i]]+" ");
            }
        }
        
       

    }
}
