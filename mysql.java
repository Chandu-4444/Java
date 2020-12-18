import java.util.*;


class MultiThreadedMergeSortModified{

    public static int[] Fmerge(int[] a, int[] b) {
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

    public void Sorting () {
        Random rand = new Random();
        int[] Original = new int[10000];
        for (int i=0; i<Original.length; i++) {
            Original[i] = rand.nextInt(500);
        }


        int SubArr1[] = new int[2000];
        int SubArr2[] = new int[2000];
        int SubArr3[] = new int[2000];
        int SubArr4[] = new int[2000];
        int SubArr5[] = new int[2000];
        for(int i=0;i<2000;i++)
        {
            SubArr1[i] = Original[i];
            SubArr2[i] = Original[i+2000];
            SubArr3[i] = Original[i+4000];
            SubArr4[i] = Original[i+6000];
            SubArr5[i] = Original[i+8000];
        }


        try{
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
            int Res1[] = Fmerge (runner1.GetResult(), runner2.GetResult());
            int Res2[] = Fmerge(Res1, runner3.GetResult());
            int Res3[] = Fmerge(Res2, runner4.GetResult());
            Original = Fmerge(Res3, runner5.GetResult());
            for(int i=0;i<Original.length;i++)
            {
                System.out.println(Original[i]);
            }
        }
        catch(Exception E){
            System.out.println(E);
        }



    }

    class Worker extends Thread {
        private int[] SubArray;

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

        Worker(int[] arr) {
            SubArray = arr;
        }

        public void run() {
            MergeSort(SubArray);
        }
    }
}

public class mysql {

    public static void main(String[] args) {

        MultiThreadedMergeSortModified Obj = new MultiThreadedMergeSortModified();
        Obj.Sorting();

    }
}