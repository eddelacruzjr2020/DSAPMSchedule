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

public class PrintJobManager extends JFrame implements ActionListener {

    private JTextField txtJobName;
    private JButton btnAddJob, btnProcessJob, btnShowQueue;
    private JList<String> jobList;
    private DefaultListModel<String> listModel;
    private Queue<String> jobQueue;  // Queue to manage print jobs (FIFO)

    public PrintJobManager() {
        // Initialize components
        jobQueue = new LinkedList<>();
        listModel = new DefaultListModel<>();

        // Frame settings
        setTitle("Print Job Manager");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Job name input field
        JLabel lblJobName = new JLabel("Job Name:");
        lblJobName.setBounds(20, 20, 100, 30);
        add(lblJobName);

        txtJobName = new JTextField();
        txtJobName.setBounds(120, 20, 200, 30);
        add(txtJobName);

        // Button to add a print job (right side)
        btnAddJob = new JButton("Add Job");
        btnAddJob.setBounds(350, 20, 120, 30);
        add(btnAddJob);

        // Button to process the next print job (right side)
        btnProcessJob = new JButton("Process Job");
        btnProcessJob.setBounds(350, 60, 120, 30);
        add(btnProcessJob);

        // Button to show the current queue of jobs (right side)
        btnShowQueue = new JButton("Show Queue");
        btnShowQueue.setBounds(350, 100, 120, 30);
        add(btnShowQueue);

        // List to display the print jobs
        jobList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(jobList);
        scrollPane.setBounds(20, 140, 450, 100);
        add(scrollPane);

        // Add action listeners to buttons
        btnAddJob.addActionListener(this);
        btnProcessJob.addActionListener(this);
        btnShowQueue.addActionListener(this);

        // Make frame visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAddJob) {
            // Add the job to the queue
            String jobName = txtJobName.getText().trim();
            if (!jobName.isEmpty()) {
                jobQueue.offer(jobName);  // Add the job to the queue
                txtJobName.setText("");   // Clear the input field
                JOptionPane.showMessageDialog(this, "Job added to the queue: " + jobName);
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a job name", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnProcessJob) {
            // Process the next job (FIFO: First-In-First-Out)
            if (!jobQueue.isEmpty()) {
                String nextJob = jobQueue.poll();  // Remove the next job in the queue
                JOptionPane.showMessageDialog(this, "Processing job: " + nextJob);
            } else {
                JOptionPane.showMessageDialog(this, "No jobs in the queue", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == btnShowQueue) {
            // Show the current jobs in the queue
            listModel.clear();  // Clear the list before displaying new jobs
            if (!jobQueue.isEmpty()) {
                for (String job : jobQueue) {
                    listModel.addElement(job);  // Display each job in the list
                }
            } else {
                JOptionPane.showMessageDialog(this, "No jobs in the queue", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new PrintJobManager();
    }
}
