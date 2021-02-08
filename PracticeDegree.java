import java.util.*;

class Degree
{
    void getDegree()
    {
        System.out.println("I got a degree");
    }
    void getDegree(boolean parent)
    {
        System.out.println("Exception/Error");
    }
}

class Undergraduate extends Degree
{
    void getDegree()
    {
        System.out.println("I am an Undergraduate");
    }
    void getDegree(boolean parent)
    {
        super.getDegree();
    }

}

class Postgraduate extends Degree
{
    void getDegree()
    {
        System.out.println("I am a Postgraduate");
    }
    void getDegree(boolean parent)
    {
        super.getDegree();
    }
}


public class PracticeDegree
{
    public static void main(String args[])
    {
        Degree ug = new Undergraduate();
        Degree pg = new Postgraduate();
        Degree deg = new Degree();

        deg.getDegree();
        ug.getDegree();
        pg.getDegree();
        System.out.println();

        ug.getDegree(true);
        System.out.println();
        pg.getDegree(true);
        System.out.println();

        deg.getDegree(true);











    }
}