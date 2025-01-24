/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab3;

/**
 *
 * @author Edmundo Dela Cruz
 */
import javax.swing.*;
import java.awt.event.*;
import java.util.HashSet;

public class StudentEnrollmentApp extends JFrame implements ActionListener {

    private JLabel lblEnterStudent;
    private JTextField txtEnterStudent;
    private JButton btnEnroll, btnWithdraw, btnView;
    private JList<String> listStudents;
    private JScrollPane scrollPane;
    private DefaultListModel<String> listModel;
    private HashSet<String> students;

    StudentEnrollmentApp() {
        students = new HashSet<>();
        listModel = new DefaultListModel<>();

        // Frame setup
        setTitle("Student Enrollment System");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Components setup
        txtEnterStudent = new JTextField();
        txtEnterStudent.setBounds(20, 50, 150, 30);
        add(txtEnterStudent);

        lblEnterStudent = new JLabel("Enter Student Name");
        lblEnterStudent.setBounds(180, 50, 150, 30);
        add(lblEnterStudent);

        btnEnroll = new JButton("Enroll");
        btnEnroll.setBounds(180, 100, 150, 30);
        add(btnEnroll);

        btnWithdraw = new JButton("Withdraw");
        btnWithdraw.setBounds(180, 150, 150, 30);
        add(btnWithdraw);

        btnView = new JButton("View Enrolled");
        btnView.setBounds(180, 200, 150, 30);
        add(btnView);

        listStudents = new JList<>(listModel);
        scrollPane = new JScrollPane(listStudents);
        scrollPane.setBounds(20, 100, 150, 130);
        add(scrollPane);

        // Add action listeners
        btnEnroll.addActionListener(this);
        btnWithdraw.addActionListener(this);
        btnView.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String studentName = txtEnterStudent.getText().trim();
        if (e.getSource() == btnEnroll) {
            if (!studentName.isEmpty()) {
                if (students.add(studentName)) {
                    listModel.addElement(studentName);
                    txtEnterStudent.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Student already enrolled", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Student name cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnWithdraw) {
            if (!studentName.isEmpty() && students.contains(studentName)) {
                students.remove(studentName);
                listModel.removeElement(studentName);
            } else {
                JOptionPane.showMessageDialog(this, "Student not found", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnView) {
            JOptionPane.showMessageDialog(this, "Enrolled Students: \n" + String.join("\n", students), "Enrolled Students", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new StudentEnrollmentApp();
    }
}

