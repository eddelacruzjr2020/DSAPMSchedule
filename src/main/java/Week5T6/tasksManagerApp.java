/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week5T6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.*;

/**
 *
 * @author Edmundo Dela Cruz
 */
public class tasksManagerApp extends JFrame implements ActionListener{
    
    private JLabel lblEnterTask;
    private JTextField txtEnterTask;
    private JButton btnAdd, btnRemove, btnComplete;
    private JList<String> listTasks;
    private JScrollPane scrollPane;
    private DefaultListModel<String> listModel;
    private LinkedList<String> tasks;
    
    
    tasksManagerApp(){
        
        tasks = new LinkedList<>();
        listModel = new DefaultListModel<>();
        
        //Frame
        setTitle("Task Manager App");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        txtEnterTask = new JTextField();
        txtEnterTask.setBounds(20, 50, 150, 30);
        add(txtEnterTask);
        
        lblEnterTask = new JLabel("Enter Task");
        lblEnterTask.setBounds(180, 50, 100, 30);
        add(lblEnterTask);
       
        //Buttons
        btnAdd = new JButton("Add");
        btnAdd.setBounds(180, 100, 100, 30);
        add(btnAdd);
        
        btnRemove = new JButton("Remove");
        btnRemove.setBounds(180, 150, 100, 30);
        add(btnRemove);
        
        btnComplete = new JButton("Complete");
        btnComplete.setBounds(180, 200, 100, 30);
        add(btnComplete);
        
        listTasks = new JList<>(listModel);
        scrollPane = new JScrollPane(listTasks);
        scrollPane.setBounds(20, 100, 150, 130);
        add(scrollPane);
     
        //Add to ActionListener
        btnAdd.addActionListener(this);
        btnRemove.addActionListener(this);
        btnComplete.addActionListener(this);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnAdd){
            String task = txtEnterTask.getText().trim();
            if(!task.isEmpty()){
                tasks.add(task);
                listModel.addElement(task);
                txtEnterTask.setText("");
            }else{
                JOptionPane.showMessageDialog(this, "Task cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            } 
        }else if(e.getSource() == btnRemove){
            int indexSelected = listTasks.getSelectedIndex();
            if(indexSelected != -1){
                tasks.remove(indexSelected);
                listModel.remove(indexSelected);
            }else{
                JOptionPane.showMessageDialog(this, "Select a task to remove", "Error", JOptionPane.ERROR_MESSAGE);
            }   
        }else if(e.getSource() == btnComplete){
            int indexSelected = listTasks.getSelectedIndex();
            if(indexSelected != -1){
                String completedTask = listModel.getElementAt(indexSelected);
                listModel.set(indexSelected, completedTask + " (Completed)");
                listTasks.setSelectedIndex(-1);
            }else{
                JOptionPane.showMessageDialog(this, "Select a task to mark as complete", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
        
    
}
