package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginJUI extends JFrame implements ActionListener {
    JLabel label1,label2;
    JTextField user  ;
    JButton submit,create;
    JPasswordField password;
    loginJUI() {

        Font f =new Font("tahoma", Font.BOLD, 20);

        this.setSize(800,500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        label1 =new JLabel("Enter User Name :");

        label1.setBounds(160, 150, 300, 50);
        label1.setBackground(Color.black);
        label1.setForeground(Color.blue);
        label1.setFont(f);
        this.add(label1);

        user =new JTextField();
        user.setEditable(true);
        user.setBounds(350, 150, 300, 50);
        user.setBackground(Color.black);
        user.setForeground(Color.white);
        this.add(user);
        user.setFont(f);
        this.setVisible(true);


        label2 =new JLabel("Enter User Pass :");

        label2.setBounds(170, 230, 300, 50);
        label2.setBackground(Color.black);
        label2.setForeground(Color.blue);
        label2.setFont(f);
        this.add(label2);

        password =new JPasswordField();
        password.setEditable(true);
        password.setBounds(350, 230, 300, 50);
        password.setBackground(Color.black);
        password.setForeground(Color.white);
        this.add(password);
        password.setFont(f);
        this.setVisible(true);


        submit = new JButton("login");
        submit.setBounds(400, 300, 200, 40);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        this.add(submit);
        submit.addActionListener(this);
        submit.setFont(f);


    }
    public  loginJUI(int a) {

        Font f =new Font("tahoma", Font.BOLD, 10);

        this.setSize(800,500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        label1 =new JLabel("Enter User Name :");

        label1.setBounds(160, 150, 300, 50);
        label1.setBackground(Color.black);
        label1.setForeground(Color.blue);
        label1.setFont(f);
        this.add(label1);

        user =new JTextField();
        user.setEditable(true);
        user.setBounds(350, 150, 300, 50);
        user.setBackground(Color.black);
        user.setForeground(Color.white);
        this.add(user);
        user.setFont(f);
        this.setVisible(true);


        label2 =new JLabel("Enter User Pass :");

        label2.setBounds(170, 230, 300, 50);
        label2.setBackground(Color.black);
        label2.setForeground(Color.blue);
        label2.setFont(f);
        this.add(label2);

        password =new JPasswordField();
        password.setEditable(true);
        password.setBounds(350, 230, 300, 50);
        password.setBackground(Color.black);
        password.setForeground(Color.white);
        this.add(password);
        password.setFont(f);
        this.setVisible(true);


        create = new JButton("create");
        create.setBounds(400, 300, 200, 40);
        create.setBackground(Color.black);
        create.setForeground(Color.white);
        this.add(create);
        create.addActionListener(this);
        create.setFont(f);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==submit){
            person a =new person(user.getText(),String.valueOf(password.getPassword()));
            if (a.login()==true){
                //JOptionPane.showMessageDialog(null,"Welcome "+user.getText(),"welcome",JOptionPane.INFORMATION_MESSAGE);
                Test h =new Test(user.getText());
                h.setVisible(true);
                this.setVisible(false);


            }else {
                JOptionPane.showMessageDialog(null,"Wrong Password Or Username","Error",JOptionPane.ERROR_MESSAGE);
            }

        }
        if(e.getSource()==create){
            admin a =new admin();
            if (a.createAccount(user.getText(),String.valueOf(password.getPassword()))==true){
                //JOptionPane.showMessageDialog(null,"Welcome "+user.getText(),"welcome",JOptionPane.INFORMATION_MESSAGE);

            }else {
                JOptionPane.showMessageDialog(null,"this username exist","Error",JOptionPane.ERROR_MESSAGE);
            }

        }
    }
}
