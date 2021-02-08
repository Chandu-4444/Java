package Bill;
import java.util.*;


public class main {
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        User users[] = new User[5];
        int id, total_calls, month, year;
        String name, phone;
        for(int i=0;i<5;i++)
        {
            System.out.println("Enter id of user: " +(i+1));
            id = in.nextInt();
            System.out.println("Enter Name of user:"+(i+1));
            name = in.next();
            System.out.println("Enter Telephone Number of user:"+(i+1));
            phone = in.next();
            System.out.println("Enter total calls of user:"+(i+1));
            total_calls = in.nextInt();
            System.out.println("Enter month of user:"+(i+1));
            month = in.nextInt();
            System.out.println("Enter year of user:"+(i+1));
            year = in.nextInt();

            users[i] = new User(id, name, phone, total_calls, month, year);


        }

        String details;
        System.out.println("Enter Name, or telephone Number of the user to calculate: ");
        details = in.next();
        int found = 0;
        for(int i=0;i<5; i++)
        {
            if(users[i].getName().equals(details) || users[i].getTelephone_number().equals(details))
            {
                users[i].Display_Bill();
                found = 1;
            }
        }
        if(found == 0)
        {
            System.out.println("User not found");
        }

    }

}
