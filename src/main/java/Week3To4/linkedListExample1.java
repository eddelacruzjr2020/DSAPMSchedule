/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Week3To4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;


/**
 *
 * @author Edmundo Dela Cruz
 */
public class linkedListExample1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
        
        Collection<Character> collect = new ArrayList();
        collect.add('C');
        
        
        LinkedList<Character> ll = new LinkedList(collect);
        ll.add('A');
        
        System.out.println("Linked List is "+ll);
        
        LinkedList<Character> ll1 = new LinkedList(ll);
        ll1.add('B');
        
        System.out.println("New Linked List is "+ll1);
        
        
        
        
        }
    
}
