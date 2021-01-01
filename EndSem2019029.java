import java.util.*;
import java.math.*;

enum Popular{
    MONUMENTS,
    BEACHES,
    LIGHTHOUSE,
    PARKS,
    WATERFALL,
    TREKKING,
    TRAVEL,
    FORTS,
    CRUISE
};

class TourMaps
{
    City network[];
    public TourMaps() {
        Random rand = new Random();
        network = new City[rand.nextInt(100) + 100];
        System.out.println("Creating Grid...");
        for (int i = 0; i < network.length; i++) {
            network[i] = new City(rand.nextInt(89999) + 10000, rand.nextInt(8) + 1);
        }
        System.out.println("Grid with PlaceID, Popular");
    }

}

class City
{
    int placeID;
    int popular;
    List<Float> distance = new ArrayList<Float>();
    int time;
    List<Integer> travel = new ArrayList<Integer>();

    public City()
    {
        placeID = 0;
        popular =0;
        time =0;
    }

    public City(int id, int pop)
    {
        placeID = id;
        popular = pop;
    }
    public void addRoutes(City net[])
    {
        for(City i: net)
        {
            this.distance.add((float) Math.abs(i.placeID-this.placeID));
        }

    }


}

public class EndSem2019029
{
    public static void main(String args[]) {
        boolean prime[][] = new boolean[9][10];
        int arr[][] = {
                {2, 7, 5, 11, 7, 7, 2, 17, 11, 9},
                {4, 5, 9, 83, 59, 8, 3, 13, 7, 5},
                {6, 3, 7, 9, 5, 7, 5, 17, 23, 3},
                {3, 4, 8, 1, 11, 5, 3, 9, 4, 6},
                {1, 2, 5, 13, 8, 7, 5, 6, 89, 7},
                {8, 4, 3, 11, 3, 2, 6, 7, 41, 5},
                {3, 97, 7, 1, 4, 3, 4, 5, 2, 1},
                {5, 2, 5, 28, 20, 7, 9, 35, 8, 7},
                {7, 4, 3, 14, 6, 5, 7, 5, 3, 2}
        };
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%3d ", arr[i][j]);
            }
            System.out.println();
        }
        PrimeFill(arr, prime);
        PrintMatrices(arr, prime);

        // Question 2
        TourMaps map = new TourMaps();
        City network[] = map.network;
        System.out.println("Adding Distances (Adding Routes)!");
        for (City i : network) {
            i.addRoutes(network);
        }
        
    }
    public static void PrimeFill(int arr[][], boolean prime[][])
    {
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[i].length;j++)
            {
                prime[i][j] = isPrime(arr[i][j]);
            }
        }
    }
    public static boolean isPrime(int n)
    {
        if(n<=1)
            return false;
        if(n<=3)
            return true;
        if(n%2==0 || n%3==0)
            return false;

        for(int i=5;i*i<=n;i+=6)
        {
            if(n%i==0 || n%(i+2)==0)
                return false;
        }
        return true;
    }

    public static void PrintMatrices(int arr[][], boolean prime[][])
    {
        int count=0;
        System.out.println("=========");
        for(int i=0;i<arr.length-1;i++)
        {

            for(int j=0;j<arr[i].length-1;j++)
            {
                int r0c0 = arr[i][j], r0c1 = arr[i][j+1], r1c0 = arr[i+1][j], r1c1 = arr[i+1][j+1];
                if((r0c0+r1c1 == r0c1+r1c0) && prime[i][j]&&prime[i+1][j+1]) {
                    System.out.printf("%3d %3d\n", arr[i][j], arr[i][j + 1]);
                    System.out.printf("%3d %3d\n", arr[i + 1][j], arr[i + 1][j + 1]);
                    System.out.println("==========");
                    count+=1;
                }
            }
        }
        System.out.println("Total Such Matrices are: "+count);

    }
}