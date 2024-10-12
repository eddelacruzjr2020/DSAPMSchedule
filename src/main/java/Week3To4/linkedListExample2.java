/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Week3To4;

import java.util.LinkedList;

/**
 *
 * @author Edmundo Dela Cruz
 */
public class linkedListExample2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList<Character> ll = new LinkedList<>();
        ll.add('A');
        ll.add('B');
        ll.add('C');
        
        System.out.println("LinkedList value is "+ll);
        System.out.println("Is value X "+ll.contains('A'));
        
        
        
//        LinkedList<Character> ll1 = new LinkedList();
//        
//        ll1 = (LinkedList<Character>) ll.clone();
//        ll1.add('D');
//        ll1.add('E');
//        ll1.add('F');
// 
//        ll1.addAll(2, ll);
//        ll1.addAll(ll);
//        ll1.addFirst('L');
//        ll1.addLast('Z');
//        ll1.clear();
//        ll1.add('D');
        
//        System.out.println("New LinkedList value is "+ll);
       
    }
    
}
