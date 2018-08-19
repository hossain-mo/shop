package com.company;

import java.sql.SQLException;

public class admin extends person{
    admin() {
        super();
    }

    public boolean createAccount(String username,String password){
        person cashair=new person(username,password);
        this.sql="INSERT into users (username,password,user_typeid) VALUES ('"+cashair.getUsername()+
                "','"+cashair.getPassword()+"',2)";
        try {
            this.s = this.c.createStatement();
            this.resultUpdate = this.s.executeUpdate(this.sql);
        } catch (SQLException e ) {
        }
        if ( this.resultUpdate== 1) {
            return true;
        } else if(this.resultUpdate==0)
            return false;
    return true;
    }
    public boolean createClient(String username,String company){
        person client=new person();
        this.sql="INSERT into clients (name,company) VALUES ('"+username+
                "','"+company+"')";
        try {
            this.s = this.c.createStatement();
            this.resultUpdate = this.s.executeUpdate(this.sql);
        } catch (SQLException e ) {
        }
        if ( this.resultUpdate== 1) {
            return true;
        } else if(this.resultUpdate==0)
            return false;
        return true;
    }
}
