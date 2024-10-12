/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Week3To4;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Edmundo Dela Cruz
 */
public class linkedListExample3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        LinkedList<String> ll = new LinkedList<>();
        ll.add("Fun");
        ll.add("DSA");
        ll.add("is");
        ll.add("DSA");
        ll.add("DSA");
        
        
        
//        Iterator<String> x = ll.descendingIterator();
//        while(x.hasNext()){
//            System.out.println("Value of x is "+x.next());
//            Thread.sleep(500);
//        }
//        System.out.println("Index element for 1 is "+ll.get(1));
//        System.out.println("First Element from the list "+ll.getFirst());
//          System.out.println("Last Element from the list "+ll.getLast());
//           System.out.println("First occurance of DSA is "+ll.indexOf("DSA"));
//           System.out.println("Last occurance of DSA is "+ll.lastIndexOf("DSA"));
            ll.offer("PM");
            ll.offerFirst("First");
            ll.offerLast("Last");
            System.out.println("Linkedlist value is "+ll);
//           System.out.println("New LinkedList is "+ll);
//           System.out.println("Peek value is "+ll.peek());
//           ll.clear();
//           System.out.println("Peek value is "+ll.peekLast());
//              System.out.println("Poll element is "+ll.poll());
//              System.out.println("New Linkedlist is "+ll);
                ll.push("Last of Last");
                System.out.println("New Linkedlist is "+ll);
        
        
    }
    
}
