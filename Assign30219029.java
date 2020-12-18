import java.io.*;
import java.util.ArrayList;
import java.util.*;





class Circle{
    class Point{
        int x, y;
        float radius;
        void getPoint()
        {

            System.out.print("x = "+x+", y = "+y);
            radius = min(x,y,70-y,70-x);
            System.out.println(" Radius = "+radius);
        }
        public float min(float a, float b, float c, float d) {

            float min = a;

            if (b < min)
                min = b;
            if (c < min)
                min = c;
            if (d < min)
                min = d;

            return min;
        }
    }
}

class Factors{
    List<Integer> Factor = new ArrayList<Integer>();
    public void computePrimeFactors(int k)
    {
        Factor.clear();
        for(int i=2;i<=k;i++)
        {
            while(k%i==0)
            {
                Factor.add(i);
                k=k/i;
            }
        }
        printFactors(Factor);

    }
    public void printFactors(List<Integer> Factor)
    {
        System.out.println("Prime Factors Are: ");
        for(int i: Factor)
        {
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public int evenFactors(int num)
    {
        Factor.clear();
        int sum =0;
        //computePrimeFactors(num);
        for(int i=2;i<=num;i++)
        {
            while(num%i==0)
            {
                Factor.add(i);
                num=num/i;
            }
        }
        for(int i: Factor)
        {
            if(i%2==0)
            {
                sum = sum+i;
            }
        }
        return sum;
    }
    public int gcd(int a, int b)
    {
        if(a==0)
            return b;
        return gcd(b%a, a);
    }
    public void checkCommonFactors(int num[])
    {
        //The idea is to find GCD of all the elements in array and find the Prime factors of the resultant GCD
        int ComGcd = 0;
        for(int i: num)
        {
            ComGcd = gcd(ComGcd, i);
        }

        computePrimeFactors(ComGcd);
    }
}

interface Bank{
    public float intersetRates(float userRate);
    public float getMAturityAmount(int interestType, int principle, int time);
}


/*
class SBI implements Bank{
    float interestRate;
    int time;
    int principle;

    public float interestRates(float userRate)
    {
        interestRate = userRate;
        return interestRate;
    }

    public float getMaturityAmount(int interestType, int principle, int time)
    {
        float total;
        if(interestType==0)
           return total = principle*time*interestRate/100;
        else
           return total = principle*(float)Math.pow(1+(interestRate/12), 12*time);
    }
}
*/




interface Comp{
    int cores = 8;
    String storage = "1GB";
    void getDetails();
}

class Computer{
    //Non-static inner class
    class CPU{
        int cores = 8;
        String manufacturer = "Dell";
        public void printPrice()
        {
            System.out.println("Rs. 56,000");
        }
    }

    static class Storage{
        int hddGB = 1;
        boolean ssd = true;
        public void getPerformance(){
            System.out.println("Good");
        }
    }

    class Message{
        public void print(){
            System.out.println("This will be welcome message on boot!");
        }
    }

    public void LocInner() {

        Message loc = new Message();
        loc.print();
    }


}



public class Assign30219029{
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        Circle CirObj = new Circle();
        Circle.Point PointObj[] = new Circle.Point[10];
        genRandomArr(PointObj);
        for (int i = 0; i < 10; i++) {
            PointObj[i].getPoint();

        }
        System.out.println();

        //Question 2
        Factors fact = new Factors();
        int n;
        System.out.print("Enter A Number To Find PrimeFactors: ");
        n = in.nextInt();
        fact.computePrimeFactors(n);
        System.out.print("Enter A Number To Find Sum Of Even Prime Factors: ");
        n = in.nextInt();
        System.out.println("Sum Of Even Factors Of Above Number Is: " + fact.evenFactors(n));
        int arr[] = new int[20];
        System.out.println("Generated Array: ");
        for (int i = 0; i < 20; i++) {
            arr[i] = 2 * (rand.nextInt(65) + 10);
            System.out.println(arr[i]);
        }
        System.out.print("Common ");
        fact.checkCommonFactors(arr);

        //Question 3
        //Bank sbi = new SBI();
        //sbi.interestRates(2);

        //Question 4
        System.out.println();
        Computer comp = new Computer();
        Computer.CPU cpu = comp.new CPU();
        System.out.println("Nonstatic inner class: ");
        cpu.printPrice();
        System.out.println();
        Computer.Storage sto = new Computer.Storage();
        System.out.println("Static inner class: ");
        sto.getPerformance();
        System.out.println();
        System.out.println("Local Inner Class: ");
        comp.LocInner();
        System.out.println();
        //Anonymous inner class

        Comp ano = new Comp() {
            public void getDetails() {
                System.out.println("Inside Anonymous Inner Class");
            }
        };
        ano.getDetails();

    }
    static void genRandomArr(Circle.Point arr[])
    {
        Circle CirObj = new Circle();
        Random rand = new Random();
        for(int i=0;i<10;i++)
        {
            arr[i] = CirObj.new Point();
            arr[i].x = rand.nextInt(60)+10;
            arr[i].y = rand.nextInt(60)+10;
        }
   
    }
}