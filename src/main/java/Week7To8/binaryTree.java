/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week7To8;

/**
 *
 * @author Edmundo Dela Cruz
 */
public class binaryTree {
    
    node root;
    
    binaryTree(){
        root = null;
    }
    
    //Method Add
    public void add(int value){
        root = addRecursive(root, value);
        
    }
    
    //Add Recursive method
    public node addRecursive(node current, int value){
        if(current == null){
            return new node(value);
        }
        if(value < current.value){
            current.left = addRecursive(current.left, value);
        }else if(value > current.value){
            current.right = addRecursive(current.right, value);
            
        }
        return current;
    }
    
    
    //In Order Traversal
    public void transversalInOrder(node node){
        if(node != null){
            transversalInOrder(node.left);
            System.out.print(" "+node.value);
            transversalInOrder(node.right);
        }
        
    }
    
    public void transversalPreOrder(node node){
        if(node != null){
            System.out.print(" "+node.value);
            transversalPreOrder(node.left);
            transversalPreOrder(node.right);
        }
    }
    
    public void transversalPostOrder(node node){
        if(node != null){
            transversalPreOrder(node.left);
            transversalPreOrder(node.right);
            System.out.print(" "+node.value);
        }
    }
    
    
    
}
