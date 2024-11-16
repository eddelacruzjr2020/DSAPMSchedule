package Week10To12;

//Java program for Left view of BST
public class BSTLeftview {

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

	// Function to print left view of
	// binary tree
	static void leftViewUtil(node root, int level,
							int max_level)
	{
		// Base Case
		if (root == null)
			return;

		// If this is the first node
		// of its level
		if (max_level < level) {
			System.out.print(" " + root.key);
			max_level = level;
		}

		// Recur for left
		leftViewUtil(root.left, level + 1, max_level);
		//leftViewUtil(root.right, level + 1, max_level);
	}

	// Wrapper over leftViewUtil()
	static void leftView(node root)
	{
		int max_level = 0;
		leftViewUtil(root, 1, max_level);
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

		// print the BST
		leftView(root);
	}
}
