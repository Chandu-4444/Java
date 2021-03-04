import java.util.*;




class BinaryTreeQ {
    Node root;

    void printLevelOrder() {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.println(tempNode.data + " ");

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if(tempNode.right!=null)
            {
                queue.add(tempNode.right);
            }
        }
    }
}

public class Level_Order_Traversal_Using_Queue{
    public static void main(String args[])
    {
        BinaryTreeQ tree = new BinaryTreeQ();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.right = new Node(8);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.right.left = new Node(6);
        tree.root.left.right.left.right = new Node(7);
        System.out.println("Level Order Traversal: ");
        tree.printLevelOrder();
    }

}