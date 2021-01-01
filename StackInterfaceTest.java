import java.io.*;
interface Interface_StackADT
{
    public void push(int pushedElement)throws ArrayIndexOutOfBoundsException;
    public void pop()throws ArrayIndexOutOfBoundsException;
    public void printElements();
}

class Ipmlementation_StackADT implements Interface_StackADT
{
    private static final int capacity = 3;
    int arr[] = new int[capacity];
    int top = -1;

    public void push(int pushedElement)throws ArrayIndexOutOfBoundsException
    {
        if (top<capacity - 1)
        {
            top++;
            arr[top] = pushedElement;
            System.out.println("Element " + pushedElement + " is pushed to Stack ");
        }
        else
        {
            System.out.println("Stack Overflow !");
        }
    }

    public void pop()throws ArrayIndexOutOfBoundsException
    {
        if (top >= 0)
        {
            top--;
            System.out.println("Pop operation done ! the poped element is:"+arr[top+1]);
        }
        else
        {
            System.out.println("Stack Underflow !");
        }
    }

    public void printElements()
    {
        if (top >= 0)
        {
            System.out.println("Elements in stack :");
            for (int i = 0; i <= top; i++)
            {
                System.out.print(arr[i]+" ");
            }
            System.out.println("");
        }
    }
}


class StackInterfaceTest
{

    public static void main(String arg[])throws IOException,ArrayIndexOutOfBoundsException
    {
        int ch,ele;
        String opt;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Interface_StackADT s=new Ipmlementation_StackADT();
        do
        {
            System.out.println("1-PUSH Element in to Stack");
            System.out.println("2-POP Element from Stack");
            System.out.println("3-Print Elements of Stack");
            System.out.println(" Enter your Choice");
            ch=Integer.parseInt(br.readLine());

            switch(ch)
            {
                case 1:
                    System.out.println(" Enter the Element you want to Push");
                    ele=Integer.parseInt(br.readLine());
                    s.push(ele);
                    break;
                case 2:
                    s.pop();
                    break;
                case 3:
                    s.printElements();
                    break;
                default:
                    System.out.println(" Invalid input");
            }
            System.out.println(" do you want to continue(y/n):");
            opt=br.readLine();
        }while(opt.equals("y"));

    }
}