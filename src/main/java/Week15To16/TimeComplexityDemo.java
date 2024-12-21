/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week15To16;

import java.util.HashMap;
import java.util.Arrays;

public class TimeComplexityDemo {
    public static void main(String[] args) {
        // Data: Numbers 0 to 9
        int[] data = new int[10];
        for (int i = 0; i < 10; i++) {
            data[i] = i;
        }
        int target = 7; // The number we are searching for

        // Measure time for Linear Search
        long startTime = System.nanoTime();
        int linearResult = linearSearch(data, target);
        long endTime = System.nanoTime();
        System.out.println("Linear Search:");
        System.out.println("Found at index: " + linearResult);
        System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds\n");

        // Measure time for Binary Search
        startTime = System.nanoTime();
        int binaryResult = binarySearch(data, target);
        endTime = System.nanoTime();
        System.out.println("Binary Search:");
        System.out.println("Found at index: " + binaryResult);
        System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds\n");

        // Measure time for Hashing Setup and Lookup
        startTime = System.nanoTime();
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int num : data) {
            map.put(num, true);
        }
        long setupEndTime = System.nanoTime();
        boolean hashResult = map.containsKey(target);
        endTime = System.nanoTime();

        System.out.println("Hashing:");
        System.out.println("HashMap Setup Time: " + (setupEndTime - startTime) + " nanoseconds");
        System.out.println("HashMap Lookup Time: " + (endTime - setupEndTime) + " nanoseconds");
        System.out.println("Found: " + hashResult);
    }

    // Linear Search - O(n)
    public static int linearSearch(int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i; // Return the index if found
            }
        }
        return -1; // Return -1 if not found
    }

    // Binary Search - O(log n)
    public static int binarySearch(int[] data, int target) {
        int left = 0, right = data.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (data[mid] == target) {
                return mid; // Return the index if found
            } else if (data[mid] < target) {
                left = mid + 1; // Search the right half
            } else {
                right = mid - 1; // Search the left half
            }
        }
        return -1; // Return -1 if not found
    }
}
