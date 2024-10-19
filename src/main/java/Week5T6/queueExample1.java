/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Week5T6;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 *
 * @author Edmundo Dela Cruz
 */
public class queueExample1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Queue<String> q = new PriorityQueue<>();
        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new PriorityBlockingQueue<>();
        
//        q.add("Dog");
//        q.add("Apple");
//        q.add("Banana");
//        q.add("Cherry");
//     
//        System.out.println("PriorityQueue is "+q);
//        
        q1.add("Dog");
        q1.add("Apple");
        q1.add("Banana");
        q1.add("Cherry");
        q1.add("Apple");
     
        System.out.println("LinkedList Queue is "+q1);
        q1.remove("Apple");
        System.out.println("LinkedList Queue is "+q1);
    }
    
}
