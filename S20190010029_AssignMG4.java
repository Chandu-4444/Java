import javax.print.attribute.standard.DateTimeAtCreation;
import java.text.Collator;
import java.util.*;
import java.io.*;
import java.math.*;

class CreateFile
{
    public static void CreationOfFile()
    {
        try {
            File New_File1 = new File("GeometricalShapesInput.txt");
            File New_File2 = new File("GeometricalShapesOutput.txt");
            if(New_File1.createNewFile()) {
                System.out.println("Successfully Created: " + New_File1.getName());
            }
            else if(New_File1.exists())
            {
                System.out.println("Failed to create (File Already Exists!): "+New_File1.getName());
            }
            if(New_File2.createNewFile())
            {
                System.out.println("Successfully Created: "+New_File2.getName());
            }
            else if(New_File2.exists())
            {
                System.out.println("Failed to create (File Already Exists!): "+New_File2.getName());
            }
        }catch (Exception e)
        {
            System.out.println("Exception Occurred! Failed to Create One or More Files!");
            e.printStackTrace();
        }
    }
}

class ReadFile
{
    public static List<String> FileReading(String FileName)
    {
        List<String> FileDataList = new ArrayList<String>();
        try {


            File MyFile = new File(FileName);
            Scanner MyReader = new Scanner(MyFile);
            while (MyReader.hasNextLine())
            {
                String data = MyReader.nextLine();
                System.out.println("Read: "+data);
                FileDataList.add(data);
            }


        }catch (IOException e)
        {
            System.out.println("Exception Occured!");
            e.printStackTrace();
        }
        finally {
            return FileDataList;
        }


    }
}

class GeometricalShapes
{
    public static int AreaOfRectangle(int Length, int Width)
    {
        if(Length < 0 || Width < 0)
        {
            //System.out.println("Invalid Parameters!");
            return -1;
        }
        return Length*Width;
    }
    public static int AreaOfSquare(int Length, int Width)
    {
        if(Length < 0 || Width < 0)
        {
            //System.out.println("Invalid Parameters!");
            return -1;
        }
        return Length*Width;
    }
    public static double AreaOfCircle(int Radius)
    {
        if(Radius<0)
        {
            //System.out.println("Invalid Parameters!");
            return -1;
        }
        return Math.PI*Radius*Radius;
    }


}

public class S20190010029_AssignMG4{
    public static void main(String args[])
    {
        //Helper Arrays To Store Shapes, Details For Writing TO Output File
        String Shapes[] = {"Circle", "Rectangle", "Square", "Circle", "Circle", "Rectangle", "Square", "Rectangle", "Rectangle", "Circle"};
        String Details[] = {"Nil,Nil,3", "2,4,Nil", "2,2,Nil", "Nil,Nil,2", "Nil,Nil,4", "2,3,Nil", "3,3,Nil", "3,4,Nil", "-5,2,Nil", "Nil,Nil,5"};
        try {
            //Creating Two Files With Names "GeometricalShapesInput.txt", "GeometricalShapesOutput.txt"
            CreateFile.CreationOfFile();
            //Writing to File GeometricalShapesInput.txt
            FileWriter MyWriter = new FileWriter("GeometricalShapesInput.txt");
            MyWriter.write("No,Geometrical Shape,Length,Width,Radius\n");
            MyWriter.write("1,Circle,Nil,Nil,3\n");
            MyWriter.write("2,Rectangle,2,4,Nil\n");
            MyWriter.write("3,Square,2,2,Nil\n");
            MyWriter.write("4,Circle,Nil,Nil,2\n");
            MyWriter.write("5,Circle,Nil,Nil,4\n");
            MyWriter.write("6,Rectangle,2,3,Nil\n");
            MyWriter.write("7,Square,3,3,Nil\n");
            MyWriter.write("8,Rectangle,3,4,Nil\n");
            MyWriter.write("9,Rectangle,-5,2,Nil\n");
            MyWriter.write("10,Circle,Nil,Nil,5");
            MyWriter.close();
            System.out.println();
            System.out.println("Successfully Written To GeometricalShapesInput.txt");
            MyWriter.close();
        }catch (IOException e)
        {
            System.out.println("An exception occured! Program Halted");
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("Reading Data From File.....");
        List<String> FileData = ReadFile.FileReading("GeometricalShapesInput.txt");
        System.out.println();
        System.out.println("Calculating Areas....");
        //Using TreeMap To Reverse Sort Areas Of Geometrical Shapes According To Their Areas
        Map<Double, Integer> Results = new TreeMap<Double, Integer>(Collections.reverseOrder());
        for(String Line: FileData)
        {
            //Split Each Line Of File Data With , As Delimiter
            String Characters[] = Line.split(",", 0);
            //Character[0] Contains Serial Number, Characters[1] Contains Shape, Characters[2] has Length, Characters[3] has Width, Characters[4] has Radius
            //Data Is Stored In TreeMap as <AreaOfShape, Serial Number> pair.....
            if(Characters[1].equals("Circle"))
            {
                Results.put(GeometricalShapes.AreaOfCircle(Integer.parseInt(Characters[4])), Integer.parseInt(Characters[0]));
            }
            else if(Characters[1].equals("Rectangle"))
            {
                Results.put((double)GeometricalShapes.AreaOfRectangle(Integer.parseInt(Characters[2]), Integer.parseInt(Characters[3])), Integer.parseInt(Characters[0]));
            }
            else if(Characters[1].equalsIgnoreCase("Square"))
            {
                Results.put((double)GeometricalShapes.AreaOfSquare(Integer.parseInt(Characters[2]), Integer.parseInt(Characters[3])), Integer.parseInt(Characters[0]));
            }
            else {
                System.out.println("Skipped First row");
            }

        }
        System.out.println("Results Are: <Area Of Shape, Serial Number> ");
        System.out.println(Results);
        System.out.println();
        System.out.println("Writing To File....");
        try {
            //Writing to File GeometricalShapesOutput.txt
            FileWriter MyWriter = new FileWriter("GeometricalShapesOutput.txt");
            MyWriter.write("No,Geometrical Shape,Length,Width,Radius,Area\n");
            for(Map.Entry<Double, Integer> i: Results.entrySet())
            {
                if(i.getKey()==-1) // Area = -1 When Dimension is < 0 So, "Invalid" is printed in Area Column Of Output File
                {
                    MyWriter.write(i.getValue()+","+Shapes[i.getValue()-1]+","+Details[i.getValue()-1]+", Invalid Data!\n");
                }
                else
                {
                    MyWriter.write(i.getValue()+","+Shapes[i.getValue()-1]+","+Details[i.getValue()-1]+","+i.getKey()+"\n");
                }
            }
            MyWriter.close();
            System.out.println("Successfully Written To GeometricalShapesOutput.txt");
            MyWriter.close();
        }catch (IOException e)
        {
            System.out.println("An exception occured! Program Halted");
            e.printStackTrace();
        }


    }


}
