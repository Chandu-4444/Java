import java.util.*;
public class codename {
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        String codeNamestring = in.nextLine();
        int i=0, len = codeNamestring.length();
        while(i<len)
        {
            i++;
        }
        if(i<6)
        {
            System.out.print("INVALID CODENAME! Please Enter again!: ");
            codeNamestring = in.nextLine();
        }
        System.out.print("Re-enter the code name: ");
        String codeNameandconfirm = in.nextLine();
        if(codeNamestring.equals(codeNameandconfirm))
        {
            System.out.println("CODE NAME CONFIRMED");
            if(codeNamestring.charAt(i-1)=='X')
            {
                System.out.println("Ok, Code name ends with 'X' ");
            }
            else {
                System.out.println("No, the string doesn't end with 'X' ");
            }
            if(codeNamestring.startsWith("Agent"))
            {
                System.out.println("Ok, Code Name starts with 'Agent'");
            }
            else
            {
                System.out.println("No!, Code Name doesn't start with 'Agent'");


            }
        }
        else
        {
            System.out.println("CODE NAME MISMATCH");
        }

    }

}
