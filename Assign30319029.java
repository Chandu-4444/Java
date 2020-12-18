import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.math.*;

class Matrix
{
    Integer array[][];
    Map<Integer, Integer> Results = new TreeMap<>(Collections.reverseOrder());
    public void GenerateArray()
    {
        array = new Integer[5][20];
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<20;j++)
            {
                array[i][j] = Assign30319029.RandomNumberGenerator(20, 200);
                if(Results.containsValue(array[i][j]))
                {
                    Results.put(array[i][j], Results.get(array[i][j])+1);
                }
                else
                {
                    Results.put(array[i][j],1);
                }

            }
        }
    }
    public void SortArray()
    {
        for(int i=0;i<array.length; i++)
        {
            if(i%2==0)
            {
                Arrays.sort(array[i]);
            }
            else
            {
                for(int j = 0; j<array[i].length-1; j++)
                {
                    for(int k=j+1;k<array[i].length;k++)
                    {
                        if(array[i][k]>array[i][j])
                        {
                            int temp = array[i][k];
                            array[i][k] = array[i][j];
                            array[i][j] = temp;
                        }
                    }

                }
            }
        }

    }
    public void PrintArray()
    {
        Iterator<Integer[]> Row = Arrays.stream(array).iterator();
        while (Row.hasNext())
        {
            Iterator<Integer> Columns = Arrays.stream(Row.next()).iterator();
            while (Columns.hasNext())
            {
                System.out.printf("%4d ",Columns.next());
            }
            System.out.println();
        }
    }

    public void PrintFrequency()
    {
        for(Map.Entry<Integer, Integer> i: Results.entrySet())
        {
            System.out.printf("%4d-%2d ",i.getKey(),i.getValue());
            System.out.println();
        }
    }

}

class ThreadedMergeSort{
    int[] Original = new int[10000];
    public static int[] FinalMerge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int i=0;
        int j=0;
        int r=0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                result[r]=a[i];
                i++;
                r++;
            } else {
                result[r]=b[j];
                j++;
                r++;
            }
            if (i==a.length) {
                while (j<b.length) {
                    result[r]=b[j];
                    r++;
                    j++;
                }
            }
            if (j==b.length) {
                while (i<a.length) {
                    result[r]=a[i];
                    r++;
                    i++;
                }
            }
        }
        return result;
    }

    public void GenerateArray() {
        Random rand = new Random();
        for (int i = 0; i < Original.length; i++) {
            Original[i] = rand.nextInt(500);
        }
        System.out.println("Array Of Length 100000 Created!");

        System.out.println();
    }

    public void StartSorting()
        {
            int SubArr1[] = new int[2000];
            int SubArr2[] = new int[2000];
            int SubArr3[] = new int[2000];
            int SubArr4[] = new int[2000];
            int SubArr5[] = new int[2000];

            for (int i = 0; i < 2000; i++) {
                SubArr1[i] = Original[i];
                SubArr2[i] = Original[i + 2000];
                SubArr3[i] = Original[i + 4000];
                SubArr4[i] = Original[i + 6000];
                SubArr5[i] = Original[i + 8000];
            }
            try {
                Worker runner1 = new Worker(SubArr1);
                Worker runner2 = new Worker(SubArr2);
                Worker runner3 = new Worker(SubArr3);
                Worker runner4 = new Worker(SubArr4);
                Worker runner5 = new Worker(SubArr5);
                runner1.start();
                runner2.start();
                runner3.start();
                runner4.start();
                runner5.start();
                runner1.join();
                runner2.join();
                runner3.join();
                runner4.join();
                runner5.join();
                int Res1[] = FinalMerge(runner1.GetResult(), runner2.GetResult());
                int Res2[] = FinalMerge(Res1, runner3.GetResult());
                int Res3[] = FinalMerge(Res2, runner4.GetResult());
                Original = FinalMerge(Res3, runner5.GetResult());
                System.out.println("Sorting Completed!");
                System.out.println("Printing The Entries in Sorted Array...");
                for(int i=0;i<Original.length;i++)
                {
                    System.out.print(" "+Original[i]);
                    if(i%100==0 && i!=0)
                    {
                        System.out.println();
                    }
                }
                System.out.println();
            }catch (Exception e)
            {
                System.out.println(e);
            }
        }


}

class Worker extends Thread {
    private int[] SubArray;
    public Worker(int[] arr) {
        SubArray = arr;
    }

    public void run() {
        MergeSort(SubArray);
    }

    public int[] GetResult() {
        return SubArray;
    }

    public void MergeSort(int[] array) {
        if (array.length > 1) {
            int[] left = Left(array);
            int[] right = Right(array);

            MergeSort(left);
            MergeSort(right);
            Merge(array, left, right);
        }
    }

    public int[] Left(int[] array) {
        int size1 = array.length / 2;
        int[] left = new int[size1];
        for (int i = 0; i < size1; i++) {
            left[i] = array[i];
        }
        return left;
    }

    public int[] Right(int[] array) {
        int size1 = array.length / 2;
        int size2 = array.length - size1;
        int[] right = new int[size2];
        for (int i = 0; i < size2; i++) {
            right[i] = array[i + size1];
        }
        return right;
    }

    public void Merge(int[] result, int[] left, int[] right) {
        int i1 = 0;
        int i2 = 0;

        for (int i = 0; i < result.length; i++) {
            if (i2 >= right.length || (i1 < left.length && left[i1] <= right[i2])) {
                result[i] = left[i1];
                i1++;
            } else {
                result[i] = right[i2];
                i2++;
            }
        }
    }

}

class Grid
{
    static int Paths(int SrcX, int SrcY, int DestX, int DestY)
    {
        if(SrcX==DestX || SrcY==DestY)
        {
            return 1;
        }
        return Paths(SrcX-1, SrcY, DestX, DestY) + Paths(SrcX, SrcY-1, DestX, DestY);
    }


}

public class Assign30319029 {
    public static void main(String args[]) {

        //Question 1
        System.out.println("**************** Question 1 ****************");
        Matrix Q1 = new Matrix();
        System.out.println("Generating a Random 5X20 Array..");
        Q1.GenerateArray();
        System.out.println("Sorting The Above Array...");
        Q1.SortArray();
        System.out.println("Printing the Sorted Array...");
        Q1.PrintArray();
        System.out.println("Printing The Frequence..");
        Q1.PrintFrequency();
        //Question 4
        System.out.println("**************** Question 4 ****************");

        int Rand1X = RandomNumberGenerator(5,9);
        int Rand1Y = RandomNumberGenerator(5, 9);
        int Rand2X = RandomNumberGenerator(0, 4);
        int Rand2Y = RandomNumberGenerator(0, 4);
        int steps = Math.abs(Rand1X-Rand2X)+Math.abs(Rand1Y-Rand2Y);
        System.out.println("Printing Total Paths From ("+Rand1X+", "+Rand1Y+") To ("+Rand2X+", "+Rand2Y+")");
        System.out.println("Total Paths Are: "+Grid.Paths(Rand1X, Rand1Y, Rand2X,Rand2Y));

        //Question 2
        System.out.println("**************** Question 2 ****************");

        ThreadedMergeSort MSort = new ThreadedMergeSort();
        MSort.GenerateArray();
        MSort.StartSorting();
        //Question 3
        System.out.println("**************** Question 3 ****************");
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/iiits","luna", "Chandu@4444");
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select * from test");
            int n = RandomNumberGenerator(1,100); // To print Details of n students
            int cou= 0;
            System.out.printf("Printing Profiles of %d Students\n",n);
            while (rs.next() && cou<=n)
            {
                cou++;
                System.out.println(rs.getInt(1)+" "+rs.getString(2));
            }


        }catch (Exception e)
        {
            System.out.println(e);
        }



    }
    public static int RandomNumberGenerator(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}