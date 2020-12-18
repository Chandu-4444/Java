//S20190010029
import java.util.*;

abstract class BinaryOperationVar{
    public abstract int compute();
    public abstract void printresult();
}

class AddBinaryOperationVar extends BinaryOperationVar{
 ArrayList<Integer> Operands = new ArrayList<>();
    public int compute() {
        int Result = 0;
        for(int i:Operands)
        {
            Result = i+Result;
        }
        return Result;
    }

    public void printresult() {
        System.out.println(compute());
    }
}

class SubBinaryOperationVar extends BinaryOperationVar{
    ArrayList<Integer> Operands = new ArrayList<>();
    public int compute() {
        int Result = 0;
        for(int i:Operands)
        {
            Result = i - Result;
        }
        return Result;
    }

    public void printresult() {
        System.out.println(compute());
    }
}

class MulBinaryOperationVar extends BinaryOperationVar{
    ArrayList<Integer> Operands = new ArrayList<>();
    public int compute() {
        int Result = 1;
        for(int i:Operands)
        {
            Result = i*Result;
        }
        return Result;
    }

    public void printresult() {
        System.out.println(compute());
    }
}

class DivBinaryOperationVar extends BinaryOperationVar{
    ArrayList<Integer> Operands = new ArrayList<>();
    public int compute() {
        int Result = 1;
        for(int i=Operands.size()-1;i>=0;i--)
        {
            Result = Operands.get(i)/Result;
            if(Result==0)
            {
                System.out.println("Division by 0!");
                return 0;
            }
        }
        return Result;
    }

    public void printresult() {
        System.out.println(compute());
    }
}

class BinaryOperationVarParser{
    public static BinaryOperationVar parseBinaryOpString(String binOpString){
        //BinaryOperationVar Operation = null;
        binOpString = binOpString.replaceAll("\\s", "");
        if(binOpString.contains("+"))
        {
            AddBinaryOperationVar Operation = new AddBinaryOperationVar();
            binOpString = binOpString.replace('+', ' ');
            String Digits[] = binOpString.split(" ", 0);
            Operation = new AddBinaryOperationVar();
            for(int i=0;i<Digits.length;i++)
            {
                Operation.Operands.add(Integer.parseInt(Digits[i]));
            }
            return Operation;

        }
        else if(binOpString.contains("-"))
        {
            SubBinaryOperationVar Operation = new SubBinaryOperationVar();
            binOpString = binOpString.replace('-', ' ');
            String Digits[] = binOpString.split(" ", 0);
            Operation = new SubBinaryOperationVar();
            for(int i=0;i<Digits.length;i++)
            {
                Operation.Operands.add(Integer.parseInt(Digits[i]));
            }
            return Operation;

        }
        else if(binOpString.contains("*"))
        {
            MulBinaryOperationVar Operation = new MulBinaryOperationVar();
            binOpString = binOpString.replace('*', ' ');
            String Digits[] = binOpString.split(" ", 0);
            Operation = new MulBinaryOperationVar();
            for(int i=0;i<Digits.length;i++)
            {
                Operation.Operands.add(Integer.parseInt(Digits[i]));
            }
            return Operation;

        }
        else if(binOpString.contains("/"))
        {
            DivBinaryOperationVar Operation = new DivBinaryOperationVar();
            binOpString = binOpString.replace('/', ' ');
            String Digits[] = binOpString.split(" ", 0);
            Operation = new DivBinaryOperationVar();
            for(int i=0;i<Digits.length;i++)
            {
                Operation.Operands.add(Integer.parseInt(Digits[i]));
                if(Operation.Operands.get(i)==0 && i!=0)
                {
                    System.out.println("Division by 0!");
                    return null;
                }
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

public class VariableArityMain{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print(">> ");
        String Expression = in.nextLine();
        BinaryOperationVar Object = BinaryOperationVarParser.parseBinaryOpString(Expression);
        if(Object!=null)
        {
            Object.printresult();
        }

    }
}

