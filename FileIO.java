import java.util.*;
import java.io.*;




public class FileIO
{
    public static void main(String args[])throws IOException
    {
        /*
        CREATING FILE
        File myObj = new File("demo.txt");
        if(myObj.createNewFile())
        {
            System.out.println("New File Created "+myObj.getName());
        }
        else
        {
            System.out.println("Failed to Create File!");
        }
         */
        /*
        READING FILE 1
        try{
            int ch;
            FileReader MyReader = new FileReader("Demo.txt");
            while ((ch = MyReader.read())!=-1)
            {
                System.out.print((char)ch);
            }
            MyReader.close();
        }catch (FileNotFoundException e)
        {
            System.out.println("File Not Found!");
        }
UP NEXT
LYRICS


         */

        /*
        READING FILE 2

        try
        {
            File MyFile = new File("Demo.txt");
            Scanner MyReader = new Scanner(MyFile);
            while (MyReader.hasNextLine())
            {
                String data = MyReader.nextLine();
                System.out.println(data);
            }
            MyReader.close();
        }catch (FileNotFoundException e)
        {
            System.out.println("e");
            e.printStackTrace();
        }
        */

        /*
        WRITING FILE 1

        try{
            FileWriter MyWriter = new FileWriter("Demo.txt");
            MyWriter.write("This is Written Content\nHello World!\n1,Circle,nil,nil,5");
            MyWriter.close();
            System.out.println("Written Content Successful!");
        }catch (IOException e)
        {
            System.out.println("An Error Occurred!");
        }

         */







    }
}