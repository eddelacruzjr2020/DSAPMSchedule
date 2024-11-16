package Week10To12;

//Java program to delete a BST
public class BSTDeleteBST{

//Given Node node
static class node {
	int key;
	node left, right;
};

//Function to create a new BST node
static node newNode(int item)
{
	node temp
		= new node();
	temp.key = item;
	temp.left = temp.right = null;
	return temp;
}

//Function to insert a new node with
//given key in BST
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

	// Return the node pointer
	return node;
}

//Function to do inorder traversal of BST
static void inorder(node root)
{
	if (root != null) {
		inorder(root.left);
		System.out.print( " "+ root.key);
		inorder(root.right);
	}
}

//Function to delete the BST
static node emptyBST(node root)
{
	node temp;
	if (root != null) {

		// Traverse to left subtree
		emptyBST(root.left);

		// Traverse to right subtree
		emptyBST(root.right);

		System.out.print("\nReleased node:"+ root.key);
		temp = root;

		// Require for free memory
		temp=null;
	}
	return root;
}

//Driver Code
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

	// Creating the BST
	root = insert(root, 50);
	insert(root, 30);
	insert(root, 20);
	insert(root, 40);
	insert(root, 70);
	insert(root, 60);
	insert(root, 80);

	System.out.print("BST before deleting:\n");
	inorder(root);

	// Function Call
	root = emptyBST(root);
}
}


