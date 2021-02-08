import java.util.*;

class MyException extends Exception
{
    public MyException(String s)
    {
        super(s);
    }
}

public class UserDefinedException{
    public static void main(String args[]) throws MyException
    {
        try{
        Scanner in = new Scanner(System.in);
        boolean couple;
        int c;
        System.out.println("Are you a couple? ('1' for yes, '0' for no)");
        c = in.nextInt();
        if(c == 1)
        {
            int ageFemale;
            int ageMale;
            System.out.print("Enter Female age and Male age: ");
            ageFemale = in.nextInt();
            ageMale = in.nextInt();
            if(ageFemale <= 18 )
            {
                throw new MyException("concession not applicable to Female!");
            }
            if(ageMale <= 21)
            {
                throw new MyException("Concession not applicable to Male!");
            }
            else
            {
                System.out.println("Ok, No problem for concession!");
            }
        }
        else
        {
            int gender;
            System.out.println("Enter Gender: '1' for male, '2' for female");
            gender = in.nextInt();
            int age;
            System.out.println("Enter Age: ");
            age = in.nextInt();
            if(gender == 1 && age<=65)
            {
                throw new MyException("concession not applicable to this age group!");
            }
            else if( gender== 2 && age <=60)
            {
                throw new MyException("concession not applicable to this age group!");

            }
            else
            {
                System.out.println("OK, No problem for concession!");
            }

        }
    } catch(MyException e)
    {
        System.out.println(e.getMessage());
    }


    }
}