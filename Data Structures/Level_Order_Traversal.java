import java.util.*;

class Node {
    int frequency;
    int data;
    char char_data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

 class BinaryTree {
    Node root;
    Map<Integer, Integer> m = new HashMap<Integer, Integer>();

    public BinaryTree() {
        root = null;
    }

    void printLevelOrder() {
        int h = height(root);
        for (int i = 0; i <= h; i++) {
            printGivenLevel(root, i, i);
        }
    }

    int height(Node root) {
        if (root == null) {
            return 0;
        } else {
            int lheight = height(root.left);
            int rheight = height(root.right);

            if (lheight > rheight) {
                return lheight + 1;
            } else {
                return rheight + 1;
            }
        }

    }

    void printGivenLevel(Node root, int level, int rank) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            m.put(root.data,rank);
            System.out.print(root.data + " " +" Level = "+rank+"\n");
        } else if (level > 1) {
            printGivenLevel(root.left, level - 1, rank);
            printGivenLevel(root.right, level - 1, rank);
        }
    }
}

public class Level_Order_Traversal
{
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.left.left = new Node(5);
        tree.root.left.left.left = new Node(6);
        tree.root.left.left.right = new Node(3);
        tree.root.left.left.right.right = new Node(4);

        System.out.println("Level Order Traversal: ");
        tree.printLevelOrder();


    }

    
}