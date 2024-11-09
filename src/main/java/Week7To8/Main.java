/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Week7To8;


/**
 *
 * @author Edmundo Dela Cruz
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        binaryTree tree = new binaryTree();
        tree.add(6);
        tree.add(4);
        tree.add(8);
        tree.add(3);
        tree.add(5);
        tree.add(7);
        tree.add(9);
        
        
        //In Order
        System.out.print("\n In Order tranversal");
        tree.transversalInOrder(tree.root);
        
        //Pre Order
        System.out.print("\n Pre Order tranversal");
        tree.transversalPreOrder(tree.root);
        
        
        //Pre Order
        System.out.print("\n Post Order tranversal");
        tree.transversalPostOrder(tree.root);
        
        
    }
    
}
