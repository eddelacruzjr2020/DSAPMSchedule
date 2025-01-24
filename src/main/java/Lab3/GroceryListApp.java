package Lab3;

import javax.swing.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Iterator;

public class GroceryListApp extends JFrame implements ActionListener {

    private JLabel lblEnterItem;
    private JTextField txtEnterItem;
    private JButton btnAdd, btnRemove, btnBought, btnView;
    private JList<String> listItems;
    private JScrollPane scrollPane;
    private DefaultListModel<String> listModel;
    private HashSet<String> grocerySet;

    GroceryListApp() {
        grocerySet = new HashSet<>();
        listModel = new DefaultListModel<>();

        // Frame setup
        setTitle("Grocery List");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Components setup
        txtEnterItem = new JTextField();
        txtEnterItem.setBounds(20, 50, 150, 30); // Position of the text field
        add(txtEnterItem);

        lblEnterItem = new JLabel("Enter Grocery Item");
        lblEnterItem.setBounds(180, 50, 150, 30); // Position of the label
        add(lblEnterItem);

        // Button setup to align them on the left
        btnAdd = new JButton("Add Item");
        btnAdd.setBounds(20, 100, 150, 30); // Align to left
        add(btnAdd);

        btnRemove = new JButton("Remove Item");
        btnRemove.setBounds(20, 150, 150, 30); // Align to left
        add(btnRemove);

        btnBought = new JButton("Mark as Bought");
        btnBought.setBounds(20, 200, 150, 30); // Align to left
        add(btnBought);

        btnView = new JButton("View List");
        btnView.setBounds(20, 250, 150, 30); // Align to left
        add(btnView);

        // List setup
        listItems = new JList<>(listModel);
        scrollPane = new JScrollPane(listItems);
        scrollPane.setBounds(200, 100, 150, 200); // Adjusted position of list
        add(scrollPane);

        // Add action listeners
        btnAdd.addActionListener(this);
        btnRemove.addActionListener(this);
        btnBought.addActionListener(this);
        btnView.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String item = txtEnterItem.getText().trim();
        int indexSelected;

        if (e.getSource() == btnAdd) {
            if (!item.isEmpty()) {
                if (grocerySet.add(item)) {
                    listModel.addElement(item);
                    txtEnterItem.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Item already exists in the list", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Item cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnRemove) {
            indexSelected = listItems.getSelectedIndex();
            if (indexSelected != -1) {
                String itemToRemove = listModel.getElementAt(indexSelected);
                grocerySet.remove(itemToRemove);
                listModel.remove(indexSelected);
            } else {
                JOptionPane.showMessageDialog(this, "Select an item to remove", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnBought) {
            indexSelected = listItems.getSelectedIndex();
            if (indexSelected != -1) {
                String boughtItem = listModel.getElementAt(indexSelected) + " (Bought)";
                listModel.set(indexSelected, boughtItem);
            } else {
                JOptionPane.showMessageDialog(this, "Select an item to mark as bought", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnView) {
            // Convert HashSet to array for displaying
            Iterator<String> iterator = grocerySet.iterator();
            StringBuilder sb = new StringBuilder();
            while (iterator.hasNext()) {
                sb.append(iterator.next()).append("\n");
            }
            JOptionPane.showMessageDialog(this, "Grocery List: \n" + sb.toString(), "Grocery List", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new GroceryListApp();
    }
}
