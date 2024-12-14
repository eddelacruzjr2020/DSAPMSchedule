/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week13To14;
import java.util.Arrays;

/**
 *
 * @author Edmundo Dela Cruz
 */
public class MinHeap {
    private int[] heap;
    private int size;

    public MinHeap(int capacity) {
        heap = new int[capacity];
    }

    public void insert(int value) {
        if (isFull()) {
            throw new IllegalStateException("Heap is full");
        }

        heap[size] = value;
        fixUp(size);
        size++;
    }

    public int delete() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        int value = heap[0];
        heap[0] = heap[size - 1];
        size--;
        fixDown(0);

        return value;
    }

    private void fixUp(int index) {
        int parent = (index - 1) / 2;

        while (parent >= 0 && heap[parent] > heap[index]) {
            int temp = heap[parent];
            heap[parent] = heap[index];
            heap[index] = temp;
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    private void fixDown(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int smallest = index;

        if (left < size && heap[left] < heap[index]) {
            smallest = left;
        }

        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }

        if (index != smallest) {
            int temp = heap[index];
            heap[index] = heap[smallest];
            heap[smallest] = temp;
            fixDown(smallest);
        }
    }

    public boolean isFull() {
        return size == heap.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void print() {
        System.out.println(Arrays.toString(heap));
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.insert(15);
        minHeap.insert(30);
        minHeap.insert(5);
        minHeap.print();
        minHeap.delete();
        minHeap.print();
    }
}
