/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week2;

import java.awt.Color;
import java.awt.Label;
import javax.swing.*;

/**
 *
 * @author Edmundo Dela Cruz
 */
public class swingSample extends JFrame{
    
    String[] sizes = {"Small", "Medium", "Large"};
    
    swingSample(){
        setSize(600, 600);
        setLayout(null);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel hdrWelcomeToDSA = new JLabel("Welcome to DSA");
        hdrWelcomeToDSA.setBounds(250, 50, 120, 50);
        add(hdrWelcomeToDSA);
        
        JButton btnClickMe = new JButton("Click Me!!!");
        btnClickMe.setBounds(250, 100, 120, 50);
        add(btnClickMe);
        
        JComboBox cmbSizes = new JComboBox(sizes);
        cmbSizes.setBounds(250, 170, 100, 30);
        add(cmbSizes);
       
        JTextField txtName = new JTextField();
        txtName.setBounds(250, 210, 100, 30);
        add(txtName);
        
        JPasswordField password = new JPasswordField();
        password.setBounds(250, 250, 100, 30);
        add(password);
        
        JTextArea txaDescription = new JTextArea();
        txaDescription.setBounds(250, 300, 100, 30);
        add(txaDescription);
        
        setVisible(true);
        
        
        
      
        
        
    }
    
}
