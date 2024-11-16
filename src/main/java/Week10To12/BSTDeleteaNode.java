package Week10To12;
//Java program for Delete a Node of BST
public class BSTDeleteaNode {

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

	// Function to do inorder traversal of BST
	static void inorder(node root)
	{
		if (root != null) {
			inorder(root.left);
			System.out.print(" " + root.key);
			inorder(root.right);
		}
	}
	// Function that returns the node with minimum
	// key value found in that tree
	static node minValueNode(node node)
	{
		node current = node;

		// Loop down to find the leftmost leaf
		while (current != null && current.left != null)
			current = current.left;

		return current;
	}

	// Function that deletes the key and
	// returns the new root
	static node deleteNode(node root, int key)
	{
		// base Case
		if (root == null)
			return root;

		// If the key to be deleted is
		// smaller than the root's key,
		// then it lies in left subtree
		if (key < root.key) {
			root.left = deleteNode(root.left, key);
		}

		// If the key to be deleted is
		// greater than the root's key,
		// then it lies in right subtree
		else if (key > root.key) {

			root.right = deleteNode(root.right, key);
		}

		// If key is same as root's key,
		// then this is the node
		// to be deleted
		else {

			// Node with only one child
			// or no child
			if (root.left == null) {
				node temp = root.right;
				return temp;
			}
			else if (root.right == null) {
				node temp = root.left;
				return temp;
			}

			// Node with two children:
			// Get the inorder successor(smallest
			// in the right subtree)
			node temp = minValueNode(root.right);

			// Copy the inorder successor's
			// content to this node
			root.key = temp.key;

			// Delete the inorder successor
			root.right = deleteNode(root.right, temp.key);
		}
		return root;
	}

	// Driver Code
	public static void main(String[] args)
	{

		/* Let us create following BST
				50
                                /	 \
                            30      80
                            / \    / 
                            20 40 60
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
		root = deleteNode(root, 70);
		inorder(root);
	}
}

