package Week10To12;

//Java program for Height of BST
public class BSTHeight {

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

	// Returns height of the BST
	static int height(node node)
	{
		if (node == null)
			return 0;
		else {

			// Compute the depth of each subtree
			int lDepth = height(node.left);
			int rDepth = height(node.right);

			// Use the larger one
			if (lDepth > rDepth)
				return (lDepth + 1);
			else
				return (rDepth + 1);
		}
	}
	// Driver Code
	public static void main(String[] args)
	{

		/* Let us create following BST
				50
			/	 \
			30	 70
		/ \ / \
		20 40 60 80
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
		System.out.println(" " + height(root));
	}
}