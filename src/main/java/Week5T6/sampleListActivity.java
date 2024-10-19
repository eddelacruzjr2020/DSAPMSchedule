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
public class sampleListActivity extends JFrame implements ActionListener{
    
    private JScrollPane scrollPane;
    private JList<String> list;
    private LinkedList<String> linkedList;
    private DefaultListModel<String> listModel;
    private JTextField txtInput;
    private JButton btnAdd, btnRemove;
    
    sampleListActivity(){
        linkedList = new LinkedList<>();
        listModel = new DefaultListModel<>();
       
        setTitle("List Management App");
        setSize(300, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        list = new JList<>(listModel);
        scrollPane = new JScrollPane(list);
        scrollPane.setBounds(10, 10, 270, 190);
        add(scrollPane);
        
        txtInput = new JTextField();
        txtInput.setBounds(10, 210, 100, 30);
        add(txtInput);
        
        //Adding buttons
        btnAdd = new JButton("Add");
        btnAdd.setBounds(120, 210, 70, 30);
        add(btnAdd);
                
        btnRemove = new JButton("Remove");
        btnRemove.setBounds(210, 210, 70, 30);
        add(btnRemove);
        
        //Add button to ActionLister
        btnAdd.addActionListener(this);
        btnRemove.addActionListener(this);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnAdd){
            String item = txtInput.getText();
            if(!item.isEmpty()){
                linkedList.add(item);
                listModel.addElement(item);
                txtInput.setText("");
            }else{
                JOptionPane.showMessageDialog(this, "Add item on the list First", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }else if(e.getSource() == btnRemove){
            int indexSelected = list.getSelectedIndex();
            if(indexSelected!=-1){
                linkedList.remove(indexSelected);
                listModel.removeElementAt(indexSelected);
            }else{
                JOptionPane.showMessageDialog(this, "Select Item to remove First", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }
    
}
