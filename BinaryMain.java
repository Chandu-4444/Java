//S20190010029
import java.util.*;

abstract class BinaryOperation{
    int Operand1;
    int Operand2;
    int Result;
    public abstract int compute();
    public abstract void printresult();
}

class AddBinaryOperation extends BinaryOperation{
    int Operand1;
    int Operand2;
    int Result;



    public int compute() {
        return Operand2 + Operand1;
    }

    public void printresult() {
        System.out.println(compute());
    }
}

class SubBinaryOperation extends BinaryOperation{
    int Operand1;
    int Operand2;
    int Result;
    @Override
    public int compute() {
        return Operand1 - Operand2;
    }

    public void printresult() {
        System.out.println(compute());
    }
}

class MulBinaryOperation extends BinaryOperation{
    int Operand1;
    int Operand2;
    int Result;
    @Override
    public int compute() {
        return Operand1 * Operand2;
    }

    public void printresult() {
        System.out.println(compute());
    }
}

class DivBinaryOperation extends BinaryOperation{
    int Operand1;
    int Operand2;
    int Result;
    @Override
    public int compute() {
        return Operand1 / Operand2;
    }

    public void printresult() {
        System.out.println(compute());
    }
}

class BinaryOperationParser{
     public static BinaryOperation parseBinaryOpString(String binOpString){
         //BinaryOperation Operation = null;
         binOpString = binOpString.replaceAll("\\s", "");
        if(binOpString.contains("+"))
        {
            AddBinaryOperation Operation = new AddBinaryOperation();
            binOpString = binOpString.replace('+', ' ');
            String Digits[] = binOpString.split(" ", 0);
            Operation = new AddBinaryOperation();
            Operation.Operand1 = Integer.parseInt(Digits[0]);
            Operation.Operand2 = Integer.parseInt(Digits[1]);
            return Operation;

        }
        else if(binOpString.contains("-"))
        {
            SubBinaryOperation Operation = new SubBinaryOperation();
            binOpString = binOpString.replace('-', ' ');
            String Digits[] = binOpString.split(" ", 0);
            Operation = new SubBinaryOperation();
            Operation.Operand1 = Integer.parseInt(Digits[0]);
            Operation.Operand2 = Integer.parseInt(Digits[1]);
            return Operation;

        }
        else if(binOpString.contains("*"))
        {
            MulBinaryOperation Operation = new MulBinaryOperation();
            binOpString = binOpString.replace('*', ' ');
            String Digits[] = binOpString.split(" ", 0);
            Operation = new MulBinaryOperation();
            Operation.Operand1 = Integer.parseInt(Digits[0]);
            Operation.Operand2 = Integer.parseInt(Digits[1]);
            return Operation;

        }
        else if(binOpString.contains("/"))
        {
            DivBinaryOperation Operation = new DivBinaryOperation();
            binOpString = binOpString.replace('/', ' ');
            String Digits[] = binOpString.split(" ", 0);
            Operation = new DivBinaryOperation();
            Operation.Operand1 = Integer.parseInt(Digits[0]);
            Operation.Operand2 = Integer.parseInt(Digits[1]);
            if(Operation.Operand2==0)
            {
                System.out.println("Division by 0 !");
                return null;
            }
            return Operation;

        }
        else
        {
            System.out.println("Wrong Expression!");
            return null;
        }
     }
}

public class BinaryMain{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print(">> ");
        String Expression = in.nextLine();
        BinaryOperation Object = BinaryOperationParser.parseBinaryOpString(Expression);
        if(Object!=null)
        {
            Object.printresult();
        }

    }
}

