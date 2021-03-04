import java.util.*;

public class Huffman_Decoding{
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(0);
        tree.root.char_data = 'O';
        tree.root.frequency = 5;
        tree.root.right = new Node(0);
        tree.root.right.char_data = 'A';
        tree.root.right.frequency = 3;
        tree.root.left = new Node(0);
        tree.root.left.char_data = 'O';
        tree.root.left.frequency = 2;
        tree.root.left.left = new Node(0);
        tree.root.left.left.char_data = 'B';
        tree.root.left.left.frequency = 1;
        tree.root.left.right = new Node(0);
        tree.root.left.right.char_data = 'C';
        tree.root.left.right.frequency = 1;
        String s = "1001011";


        Decode(tree.root, s);

    }
    static void Decode(Node root, String s)
    {
        String ans = "";
        Node base = root;
        while(!s.isEmpty())
        {
            if(s.charAt(0) == '1')
            {
                base = base.right;
                s = s.substring(1);
            }
            else{
                base = base.left;
                s = s.substring(1);
            }
            if(base.left==null && base.right==null)
            {
                ans = ans+base.char_data;
                base = root;
            }
        }
        System.out.println(ans);
    }

}