package Week10To12;

import java.util.Stack;
 
public class BinaryTreeInOrder {
 
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
 
    // Recursive Solution
    public void inOrder(TreeNode root) {
        if(root !=  null) {
            inOrder(root.left);
            //Visit the node by Printing the node data
            System.out.printf("%d ",root.data);
            inOrder(root.right);
        }
    }
 
    // Iterative solution
    public void inOrderIter(TreeNode root) {
 
        if(root == null)
            return;
 
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode currentNode=root;
 
        while(!s.empty() || currentNode!=null){
 
            if(currentNode!=null)
            {
                s.push(currentNode);
                currentNode=currentNode.left;
            }
            else
            {
                TreeNode n=s.pop();
                System.out.printf("%d ",n.data);
                currentNode=n.right;
            }
        }
    }
 
    public static void main(String[] args)
    {
        BinaryTreeInOrder bi=new BinaryTreeInOrder();
        // Creating a binary tree
        TreeNode rootNode=createBinaryTree();
        System.out.println("InOrder Using Recursive solution:");
 
        bi.inOrder(rootNode);
 
        System.out.println();
        System.out.println("-------------------------");
        System.out.println("InOrder Using Iterative solution:");
 
        bi.inOrderIter(rootNode);
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
 
        rootNode.left=node20;
        rootNode.right=node60;
 
        node20.left=node10;
        node20.right=node30;
 
        node60.left=node50;
        node60.right=node70;
 
        return rootNode;
    }
}