package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {
    public Connection connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection c= null;
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/myshop","root","");
        } catch (SQLException e) {
            System.out.println("three");
        }
        return c;
    }
}
