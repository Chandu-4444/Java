import java.util.*;

class Methods {
    String FName, LName, MName;

    Methods() {
        FName = "";
        MName = "";
        LName = "";
    }

    Methods(String FName, String LName) {
        this.FName = FName.toUpperCase();
        this.LName = LName.toUpperCase();
    }

    Methods(String FName, String MName, String LName) {
        this.FName = FName.toUpperCase();
        this.MName = MName.toUpperCase();
        this.LName = LName.toUpperCase();
    }

    String Return_Name() {
        String ans = "";
        if (MName == null) {
            ans = ans + (FName.charAt(0)) + (LName.charAt(0));
        } else {
            ans = ans + (FName.charAt(0)) + (MName.charAt(0)) + ( LName.charAt(0) );
        }
        return ans;
    }

}

public class Ranjit {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String Name;
        System.out.println("Enter Name: ");
        Name = in.nextLine();
        String Names[] = Name.split(" ");

        if (Names.length == 2) {
            Methods obj = new Methods(Names[0], Names[1]);
            System.out.println(Name + " " + obj.Return_Name());
        } else {
            Methods obj = new Methods(Names[0], Names[1], Names[2]);
            System.out.println(Name + ": " + obj.Return_Name());
        }
    }
}