/*
* Name: Chandra Kiran G
* RollNo: S20190010029
 */

import java.util.*;
abstract class Employee
{
    private String Name;
    private int Emp_id;
    private String Projects[];
    private double Points[];
    public Employee(String name, int id, String pro[], double poi[])
    {

        Name = name;
        Emp_id = id;
        Projects= new String[pro.length];
        for(int i=0;i<pro.length;i++)
        {
            Projects[i] = pro[i];
        }
        Points = new double[poi.length];
        for(int i=0;i<poi.length;i++)
        {
            Points[i] = poi[i];
        }
    }
    public String getName()
    {
        return Name;
    }
    public int getID()
    {
        return Emp_id;

    }
    public String[] getProjects()
    {
        return Projects;
    }
    public double[] getPoints()
    {
        return Points;
    }
    public double AvgPoints()
    {
        double avg=0.0;
        for(double i: Points)
        {
            avg+=i;
        }
        return avg/Points.length;
    }
    public abstract String getEmpClass();

    public String toString()
    {
        return String.format("Name: %s, ID: %d, Avg: %e", getName(), getID(), AvgPoints());
    }

}

class Engineer extends Employee
{
    public Engineer(String name, int id, String pro[], double poi[])
    {
        super(name, id, pro, poi);
    }
    public String getEmpClass()
    {
        double avg = super.AvgPoints();
        if(avg>9.0) return "Exemplary";
        else if(avg>8.0) return "Very-Good";
        else if(avg>7.0) return "Good";
        else return "Adequate";
    }
    public String toString()
    {
        return String.format("Engineer\n%s, Class: %s\n",super.toString(),getEmpClass());
    }
}

class SalesExecutive extends Employee
{
    public SalesExecutive(String name, int id, String pro[], double poi[])
    {
        super(name, id, pro, poi);
    }
    public String getEmpClass()
    {
        double a = super.AvgPoints();
        if(a>7.5) return "Target Achieved";
        else return "Adequate";
    }
    public String toString()
    {
        return String.format("Sale Executive\n%s, Class: %s",super.toString(),getEmpClass());
    }
}

public class EmployeeMainApplication
{
    public static void main(String args[])
    {
        String Pro[] = {"Java", "C/C++", "Python"}; //Projects Array
        double poi[] = {5.0, 6.0, 5.0}; //Corresponding Points Array
        Employee engine = new Engineer("Chandra", 123, Pro, poi );
        System.out.println(engine.toString());
        String tar[] = {"Market", "Transfer", "Power"}; //Projects for SalesExecutive
        double poi2[] = {6.0, 9.0, 8.0}; // Points for corresponding Projects
        Employee Sales = new SalesExecutive("Kiran",345, tar, poi2);
        System.out.println(Sales.toString());
    }
}