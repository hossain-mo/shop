package com.company;

import java.sql.*;

public class person {
    private String username;
    private String password;
    protected Statement s= null;
    protected Connection c=new database().connect();
    protected   ResultSet result=null;
    protected int resultUpdate;
    protected String sql;
    person(){}
    person(String name,String pass){
        this.username=name;
        this.password=pass;
    }
    public boolean login(){


        try {
            this.s = this.c.createStatement();
        } catch (SQLException e) {
            System.out.println("one");
        }
        this.sql="select COUNT(1) FROM users WHERE username='"+this.username+"' AND password='"+this.password+"'";
        try {
              this.result = this.s.executeQuery(this.sql);
             try {
                     if (this.result.next() && this.result.getInt("COUNT(1)") == 1) {
                         return true;
                     } else
                         return false;

             }catch (SQLException e){}
                System.out.println("inner");

        } catch (SQLException e) {
            System.out.println("Two");
        }
        return true;
    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }

}
