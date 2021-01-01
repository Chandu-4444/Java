import static java.lang.Math.*;
import java.util.*;
public class TestClass{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        char[] ch = s.toCharArray();
        Stack<Character> st = new Stack<>();
        for(int i = 0;i<ch.length;i++){
            if(st.isEmpty() || st.peek() != ch[i]){
                st.push(ch[i]);
            }
            else{
                st.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        System.out.println(sb.reverse().toString());


    }
}