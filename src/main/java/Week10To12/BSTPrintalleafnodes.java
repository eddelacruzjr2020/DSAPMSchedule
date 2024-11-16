package Week10To12;

//Java program for Printing all leaf nodes
public class BSTPrintalleafnodes {

	// Given Node node
	static class node {
		int key;
		node left, right;
	};

	// Function to create a new BST node
	static node newNode(int item)
	{
		node temp = new node();
		temp.key = item;
		temp.left = temp.right = null;
		return temp;
	}

	// Function to insert a new node with
	// given key in BST
	static node insert(node node, int key)
	{
		// If the tree is empty, return a new node
		if (node == null)
			return newNode(key);

		// Otherwise, recur down the tree
		if (key < node.key) {
			node.left = insert(node.left, key);
		}
		else if (key > node.key) {
			node.right = insert(node.right, key);
		}

		// Return the node
		return node;
	}

	// Function to print leaf nodes
	// from left to right
	static void printLeafNodes(node root)
	{
		// If node is null, return
		if (root == null)
			return;

		// If node is leaf node,
		// print its data
		if (root.left == null && root.right == null) {
			System.out.print(" " + root.key);
			return;
		}

		// If left child exists,
		// check for leaf recursively
		if (root.left != null)
			printLeafNodes(root.left);

		// If right child exists,
		// check for leaf recursively
		if (root.right != null)
			printLeafNodes(root.right);
	}

	// Driver Code
	public static void main(String[] args)
	{

		/* Let us create following BST
			     50
			  /	 \
			30	 70
                        / \     / \
                        20 40  60 80
	*/
		node root = null;

		// inserting value 50
		root = insert(root, 50);

		// inserting value 30
		insert(root, 30);

		// inserting value 20
		insert(root, 20);

		// inserting value 40
		insert(root, 40);

		// inserting value 70
		insert(root, 70);

		// inserting value 60
		insert(root, 60);

		// inserting value 80
		insert(root, 80);

		// Function Call
		printLeafNodes(root);
	}
}

