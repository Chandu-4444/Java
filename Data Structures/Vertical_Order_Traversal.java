import java.util.*;

class Values{
	int max, min;
}
public class Vertical_Order_Traversal {
	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.right.left.right = new Node(8);
		tree.root.right.right.right = new Node(9);
		tree.root.right.right.right.right = new Node(10);

		System.out.println("Vertical Order Traversal:");
		Values val = new Values();
		VerticalOrder(tree.root, val);

	}

	static void findMinMax(Node node, Values min, Values max, int hd)
	{
		if(node == null)
		{
			return;
		}
		if(hd < min.min)
		{
			min.min = hd;
		}
		else if(hd>max.max)
		{
			max.max = hd;
		}

		findMinMax(node.left, min, max, hd-1);
		findMinMax(node.right, min, max, hd+1);
	}

	static void printVerticalLine(Node node, int line_no, int hd)
	{
		if(node==null)
		{
			return;
		}

		if(hd==line_no)
		{
			System.out.print(node.data+" ");
		}
		printVerticalLine(node.left, line_no, hd-1);
		printVerticalLine(node.right, line_no, hd+1);
	}
	static void VerticalOrder(Node node, Values val)
	{
		findMinMax(node, val, val, 0);
		for(int line_no = val.min; line_no<= val.max; line_no++)
		{
			printVerticalLine(node, line_no, 0);
			System.out.println("");
		}
	}
}