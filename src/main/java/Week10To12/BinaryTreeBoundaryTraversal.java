package Week10To12;

public class BinaryTreeBoundaryTraversal {
    public static class TreeNode
    {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data)
        {
            this.data=data;
        }
    }
 
    public static void boundaryLevelTraversal(TreeNode root)
    {
        System.out.print(root.data+" ");
        printLeftEdgeNodes(root.left);
        printLeafNodes(root);
        printRightBottomUp(root.right);
 
    }
 
    private static void printLeafNodes(TreeNode root) {
        if(root==null)
            return;
 
        if(root.left==null && root.right==null)
        {
            System.out.print(root.data+" ");
            return;
        }
        printLeafNodes(root.left);
        printLeafNodes(root.right);
    }
 
    private static void printRightBottomUp(TreeNode root)
    {
        if(root==null)
            return;
 
        // if leaf node, ignore while printing edges
        if(root.left==null && root.right==null)
        {
            return;
        }
 
        if(root.right!=null)
        {
            printRightBottomUp(root.right);
        }
        else if(root.left!=null)
        {
            printRightBottomUp(root.left);
        }
 
        System.out.print(root.data+" ");
    }
 
    private static void printLeftEdgeNodes(TreeNode root) {
        if(root==null)
            return;
 
        // if leaf node, ignore while printing edges
        if(root.left==null && root.right==null)
            return;
 
        System.out.print(root.data+" ");
 
        // If left is null, right will be the boundary edge.
        if(root.left==null)
        {
            printLeftEdgeNodes(root.right);
        }
        else
        {
            printLeftEdgeNodes(root.left);
        }
 
    }
 
    public static void main(String[] args)

    {
        // Creating a binary tree
        TreeNode rootNode=createBinaryTree();
        System.out.println("Boundary traversal of binary tree will be:");
        boundaryLevelTraversal(rootNode);
    }
 
    public static TreeNode createBinaryTree()
    {
 
        TreeNode rootNode =new TreeNode(40);
        TreeNode node20=new TreeNode(20);
        TreeNode node10=new TreeNode(10);
        TreeNode node30=new TreeNode(30);
        TreeNode node60=new TreeNode(60);
        TreeNode node50=new TreeNode(50);
        TreeNode node70=new TreeNode(70);
        TreeNode node5=new TreeNode(5);
        TreeNode node45=new TreeNode(45);
        TreeNode node55=new TreeNode(55);
 
        rootNode.left=node20;
        rootNode.right=node60;
 
        node20.left=node10;
        node20.right=node30;
 
        node60.left=node50;
        node60.right=node70;
 
        node10.right=node5;
        node5.right=node45;
 
        node50.right=node55;
        return rootNode;
    }
}