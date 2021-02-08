import java.util.*;
import java.io.*;

class Student{
    private String name;
    private String admission_number;
    private double marks[];

    public Student(String name, String number, double marks[])
    {
        this.name = name;
        this.admission_number = number;
        this.marks = new double[5];
        for(int i=0;i<5;i++)
        {
            this.marks[i] = marks[i];
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdmission_number() {
        return admission_number;
    }

    public void setAdmission_number(String admission_number) {
        this.admission_number = admission_number;
    }

    public double[] getMarks() {
        return marks;
    }

    public void setMarks(double[] marks) {
        this.marks = marks;
    }


}



public class Institute {
    public static void main(String args[]) throws IOException
    {

        Scanner in = new Scanner(System.in);
        int total_students;
        System.out.println("Enter total students");
        total_students = in.nextInt();

        Student students[] = new Student[total_students];

        String name, number;
        double marks[] = new double[5];
        for(int i=0;i<total_students;i++)
        {
            System.out.println("Enter Name of student :"+(i+1));
            name = in.next();
            System.out.println("Enter Addmission_Number of student :"+(i+1));
            number = in.next();
            System.out.println("Enter marks of 5 subjects of student :"+(i+1));
            marks[0] = in.nextDouble();
            marks[1] = in.nextDouble();
            marks[2] = in.nextDouble();
            marks[3] = in.nextDouble();
            marks[4] = in.nextDouble();
            students[i] = new Student(name, number, marks);
        }
        try{
            String fname = "Information.txt";
        System.out.println("Writing contents to Files!...");
        File fo = new File(fname);
        if(fo.createNewFile())
        {
            System.out.println("File Created: "+fo.getName());
        }
        else
        {
            System.out.println("File already exists!");
        }

        FileWriter out = new FileWriter(fname);
        out.write("Name \t Admission Number \t Marks\n");
        for(int i=0;i<total_students;i++)
        {
            out.write(students[i].getName()+"   "+students[i].getAdmission_number());
                marks = students[i].getMarks();
                for(double m: marks)
                {
                    out.write(m+" ");
                }
            out.write("\n");
        }
        out.close();
        System.out.println("Done writing contents to the file: "+fname);

    }catch(IOException e)
    {
        System.out.println("Error occurred!");
        e.printStackTrace();
    }



    }

}
