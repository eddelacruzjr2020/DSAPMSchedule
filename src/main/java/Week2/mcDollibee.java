/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Edmundo Dela Cruz
 */
public class mcDollibee extends JFrame implements ActionListener{
    
    private JLabel hdrMcdollibee, lblBurger, lblBurgerCount, lblFries, lblFriesCount, lblSoda, lblSodaCount;
    private JButton btnAddBurger, btnMinusBurger, btnAddFries, btnMinusFries, btnAddSoda, btnMinusSoda, btnReview, btnReset;
    private JComboBox cmbBurger, cmbFries, cmbSoda;
    private JTextArea txaSummary;
    private String[] sizes = {"Small", "Medium", "Large"};
    private int intBurgerCount = 0;
    private int intFriesCount = 0;
    private int intSodaCount = 0;
    
    mcDollibee(){
        setSize(600, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Adding components
        hdrMcdollibee = new JLabel("Welcome to McDollibee. Let's Start", SwingConstants.CENTER);
        hdrMcdollibee.setBounds(0, 50, 600, 30);
        add(hdrMcdollibee);
        
        lblBurger = new JLabel("Burger:");
        lblBurger.setBounds(50, 100, 80, 30);
        add(lblBurger);
        
        lblBurgerCount = new JLabel("0");
        lblBurgerCount.setBounds(150, 100, 50, 30);
        add(lblBurgerCount);
        
        btnAddBurger = new JButton("+");
        btnAddBurger.setBounds(220, 100, 50, 30);
        add(btnAddBurger);
        
        btnMinusBurger = new JButton("-");
        btnMinusBurger.setBounds(290, 100, 50, 30);
        add(btnMinusBurger);
        
        cmbBurger = new JComboBox<>(sizes);
        cmbBurger.setBounds(360, 100, 80, 30);
        add(cmbBurger);
        
        lblFries = new JLabel("Fries:");
        lblFries.setBounds(50, 150, 80, 30);
        add(lblFries);

        lblFriesCount = new JLabel("0");
        lblFriesCount.setBounds(150, 150, 50, 30);
        add(lblFriesCount);

        btnAddFries = new JButton("+");
        btnAddFries.setBounds(220, 150, 50, 30);
        add(btnAddFries);

        btnMinusFries = new JButton("-");
        btnMinusFries.setBounds(290, 150, 50, 30);
        add(btnMinusFries);

        cmbFries = new JComboBox<>(sizes);
        cmbFries.setBounds(360, 150, 80, 30);
        add(cmbFries);
    
        lblSoda = new JLabel("Soda:");
        lblSoda.setBounds(50, 200, 80, 30);
        add(lblSoda);

        lblSodaCount = new JLabel("0");
        lblSodaCount.setBounds(150, 200, 50, 30);
        add(lblSodaCount);

        btnAddSoda = new JButton("+");
        btnAddSoda.setBounds(220, 200, 50, 30);
        add(btnAddSoda);

        btnMinusSoda = new JButton("-");
        btnMinusSoda.setBounds(290, 200, 50, 30);
        add(btnMinusSoda);

        cmbSoda = new JComboBox<>(sizes);
        cmbSoda.setBounds(360, 200, 80, 30);
        add(cmbSoda);
        
        btnReview = new JButton("Review Order");
        btnReview.setBounds(50, 250, 120, 30);
        add(btnReview);
        
        btnReset = new JButton("Reset Order");
        btnReset.setBounds(190, 250, 120, 30);
        add(btnReset);
        
        txaSummary = new JTextArea();
        txaSummary.setBounds(50, 300, 500, 200);
        txaSummary.setEditable(false);
        add(txaSummary);
        
        //Adding to Action Listener
        btnAddBurger.addActionListener(this);
        btnMinusBurger.addActionListener(this);
        btnAddFries.addActionListener(this);
        btnMinusFries.addActionListener(this);
        btnAddSoda.addActionListener(this);
        btnMinusSoda.addActionListener(this);
        btnReview.addActionListener(this);
        btnReset.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnAddBurger){
            intBurgerCount++;
            lblBurgerCount.setText(String.valueOf(intBurgerCount));
        }else if(e.getSource() == btnMinusBurger){
            if(intBurgerCount > 0){
                intBurgerCount--;
                lblBurgerCount.setText(String.valueOf(intBurgerCount));
            }
        }else if(e.getSource() == btnAddFries){
            intFriesCount++;
            lblFriesCount.setText(String.valueOf(intFriesCount));
        }else if(e.getSource() == btnMinusFries){
            if(intFriesCount > 0){
                intFriesCount--;
                lblFriesCount.setText(String.valueOf(intFriesCount));
            }
        }else if(e.getSource() == btnAddSoda){
            intSodaCount++;
            lblSodaCount.setText(String.valueOf(intSodaCount));
        }else if(e.getSource() == btnMinusSoda){
            if(intSodaCount > 0){
                intSodaCount--;
                lblSodaCount.setText(String.valueOf(intSodaCount));
            }
        }else if(e.getSource() == btnReview){
            double totalCost = 0.0;
            totalCost+=calculateCost(intBurgerCount, (String)cmbBurger.getSelectedItem());
            totalCost+=calculateCost(intFriesCount, (String)cmbFries.getSelectedItem());
            totalCost+=calculateCost(intSodaCount, (String)cmbSoda.getSelectedItem());
            
            txaSummary.setText("Burger ("+cmbBurger.getSelectedItem()+"): "+intBurgerCount+"\n" +
                               "Fries ("+cmbFries.getSelectedItem()+"): "+intFriesCount+"\n" +
                               "Soda ("+cmbSoda.getSelectedItem()+"): "+intSodaCount+"\n" +
                               "Total Cost: $"+totalCost+"");
        }else if(e.getSource() == btnReset){
            intBurgerCount = 0;
            lblBurgerCount.setText(String.valueOf(intBurgerCount));
            intSodaCount = 0;
            lblSodaCount.setText(String.valueOf(intSodaCount));
            intFriesCount = 0;
            lblFriesCount.setText(String.valueOf(intFriesCount));
            
            txaSummary.setText("");
            
            cmbBurger.setSelectedIndex(0);
            cmbFries.setSelectedIndex(0);
            cmbSoda.setSelectedIndex(0);
        }
        
    }
    private double calculateCost(int count, String size){
        double price = 0.0;
        switch(size){
            case "Small" -> price = 5.00;
            case "Medium" -> price = 7.50;
            case "Large" -> price = 10.00;
        }
        return count*price;
    }
    
}
