package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adminhome extends JFrame implements ActionListener {
    JButton createcashier ;
    adminhome(String x)
    {
        this.setSize(800,500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        createcashier = new JButton("create");
        createcashier.setBounds(10,10,100,30);

        this.add(createcashier);
        createcashier.addActionListener(this);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == createcashier)
        {
            loginJUI jui =new loginJUI(1);
            this.setVisible(false);
            jui.setVisible(true);
        }
    }
}
