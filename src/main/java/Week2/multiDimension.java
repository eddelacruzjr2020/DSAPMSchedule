/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Week2;

/**
 *
 * @author Edmundo Dela Cruz
 */
public class multiDimension {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        int[][] multiDimenArray = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
           // Iterate through the rows
                for (int i = 0; i < multiDimenArray.length; i++) {
                // Iterate through the columns of each row
                for (int j = 0; j < multiDimenArray[i].length; j++) {
                    System.out.print(multiDimenArray[i][j] + " ");
                    // Add a delay of 500 milliseconds between printing each element
                     Thread.sleep(500);
                }
                System.out.println();  // Move to the next line after each row
        
                }
    }
    
}
