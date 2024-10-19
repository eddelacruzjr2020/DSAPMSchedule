/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Week5T6;

import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author Edmundo Dela Cruz
 */
public class stackExample1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        Stack<String> stack = new Stack<>();
        stack.push("Apple");
        stack.push("Banana");
        stack.push("Cherry");
        
//        for(String fruits: stack){
//            System.out.println(fruits);
//            Thread.sleep(500);
//        }

//        System.out.println("First element of stack "+stack.peek());
//        System.out.println("Stack is "+stack);
//        System.out.println("Get First element from the Stack "+stack.pop());
//        System.out.println("New Stack is "+stack);
        System.out.println("Is Stack empty "+stack.empty());
        stack.clear();
        System.out.println("Is Stack empty "+stack.empty());
        
        
        
        
    }
    
}
