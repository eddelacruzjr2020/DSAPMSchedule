/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week7To8;

/**
 *
 * @author Edmundo Dela Cruz
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

public class CustomerServiceQueueManager extends JFrame implements ActionListener {

    private JTextField txtCustomerName;
    private JButton btnAddCustomer, btnServeCustomer, btnShowQueue;
    private JList<String> customerList;
    private DefaultListModel<String> listModel;
    private Queue<String> customerQueue;  // Queue to manage customers (FIFO)

    public CustomerServiceQueueManager() {
        // Initialize components
        customerQueue = new LinkedList<>();
        listModel = new DefaultListModel<>();

        // Frame settings
        setTitle("Customer Service Queue Manager");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Customer name input field
        JLabel lblCustomerName = new JLabel("Customer Name:");
        lblCustomerName.setBounds(20, 20, 120, 30);
        add(lblCustomerName);

        txtCustomerName = new JTextField();
        txtCustomerName.setBounds(170, 20, 300, 30);
        add(txtCustomerName);

        // Button to add a customer (left side)
        btnAddCustomer = new JButton("Add Customer");
        btnAddCustomer.setBounds(20, 70, 140, 30);
        add(btnAddCustomer);

        // Button to serve the next customer (left side)
        btnServeCustomer = new JButton("Serve Customer");
        btnServeCustomer.setBounds(20, 110, 140, 30);
        add(btnServeCustomer);

        // Button to show the current queue of customers (left side)
        btnShowQueue = new JButton("Show Queue");
        btnShowQueue.setBounds(20, 150, 140, 30);
        add(btnShowQueue);

        // List to display the customers
        customerList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(customerList);
        scrollPane.setBounds(170, 70, 300, 180);
        add(scrollPane);

        // Add action listeners to buttons
        btnAddCustomer.addActionListener(this);
        btnServeCustomer.addActionListener(this);
        btnShowQueue.addActionListener(this);

        // Make frame visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAddCustomer) {
            // Add the customer to the queue
            String customerName = txtCustomerName.getText().trim();
            if (!customerName.isEmpty()) {
                customerQueue.offer(customerName);  // Add the customer to the queue
                txtCustomerName.setText("");  // Clear the input field
                JOptionPane.showMessageDialog(this, "Customer added to the queue: " + customerName);
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a customer name", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnServeCustomer) {
            // Serve the next customer (FIFO: First-In-First-Out)
            if (!customerQueue.isEmpty()) {
                String nextCustomer = customerQueue.poll();  // Remove the next customer in the queue
                JOptionPane.showMessageDialog(this, "Serving customer: " + nextCustomer);
            } else {
                JOptionPane.showMessageDialog(this, "No customers in the queue", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == btnShowQueue) {
            // Show the current customers in the queue
            listModel.clear();  // Clear the list before displaying new customers
            if (!customerQueue.isEmpty()) {
                for (String customer : customerQueue) {
                    listModel.addElement(customer);  // Display each customer in the list
                }
            } else {
                JOptionPane.showMessageDialog(this, "No customers in the queue", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new CustomerServiceQueueManager();
    }
}

