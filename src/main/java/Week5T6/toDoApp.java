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
public class toDoApp extends JFrame implements ActionListener{
    
    private LinkedList<String> todos;
    private DefaultListModel<String> listModel;
    private JLabel lblTodo;
    private JTextField txtTodoInput;
    private JButton btnAdd, btnRemove, btnClear;
    private JList<String> listTodo;
    private JScrollPane scrollPane;
    
    toDoApp(){
        todos = new LinkedList<>();
        listModel = new DefaultListModel<>();
        
        //Setup Frame
        setTitle("Todo List App");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        lblTodo = new JLabel("Enter To-Dos");
        lblTodo.setBounds(20, 50, 100, 30);
        add(lblTodo);
        
        txtTodoInput = new JTextField();
        txtTodoInput.setBounds(120, 50, 150, 30);
        add(txtTodoInput);
        
        //Add Buttons
        btnAdd = new JButton("Add");
        btnAdd.setBounds(20, 100, 80, 30);
        add(btnAdd);
        
        btnRemove = new JButton("Remove");
        btnRemove.setBounds(20, 150, 80, 30);
        add(btnRemove);
        
        btnClear = new JButton("Clear");
        btnClear.setBounds(20, 200, 80, 30);
        add(btnClear);
        
        //Task List display
        listTodo = new JList<>(listModel);
        scrollPane = new JScrollPane(listTodo);
        scrollPane.setBounds(120, 100, 150, 130);
        add(scrollPane);
        
        //Add to ActionListener
        btnAdd.addActionListener(this);
        btnRemove.addActionListener(this);
        btnClear.addActionListener(this);
        
        setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnAdd){
            String todo = txtTodoInput.getText().trim();
            if(!todo.isEmpty()){
                todos.add(todo);
                listModel.addElement(todo);
                txtTodoInput.setText("");
            }else{
                JOptionPane.showMessageDialog(this, "Todo cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else if(e.getSource() == btnRemove){
            int selectedIndex = listTodo.getSelectedIndex();
            if(selectedIndex != -1){
                todos.remove(selectedIndex);
                listModel.remove(selectedIndex);
            }else{
                JOptionPane.showMessageDialog(this, "Select a todo to remove", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else if(e.getSource() == btnClear){
            todos.clear();
            listModel.clear();
        }
        
    }
    
}
