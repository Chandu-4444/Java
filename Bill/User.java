package Bill;
import java.util.*;

public class User
{
    private int id;
    private String name;
    private String telephone_number;
    private int total_calls;
    private int month;
    private int year;


    public User(int id, String name, String number, int calls, int month, int year)
    {
        this.id = id;
        this.name = name;
        this.telephone_number = number;
        this.total_calls = calls;
        this.month = month;
        this.year = year;
    }

    public void Display_Bill()
    {
        double bill=0;
        if(total_calls<=100)
        {
            System.out.println("Hello "+name+", Your Bill is: "+bill);
        }
        else if(total_calls>100 && total_calls<=500)
        {
            bill = (total_calls -100) * 1.0;
            System.out.println("Hello "+name+", Your Bill is: "+bill);
        }
        else
        {
            bill = (500) * 1.0;
            bill = bill + (total_calls - 500) * 1.3;
            System.out.println("Hello "+name+", Your Bill is: "+bill);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone_number() {
        return telephone_number;
    }

    public void setTelephone_number(String telephone_number) {
        this.telephone_number = telephone_number;
    }

    public int getTotal_calls() {
        return total_calls;
    }

    public void setTotal_calls(int total_calls) {
        this.total_calls = total_calls;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


}
