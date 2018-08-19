package com.company;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class product {
    private int code;
    private  int frm;
    private  int tto;
    private  String type;
    private  int price;
    private int client_id;
    private int number;
    private int product_id;

    protected Statement s= null;
    protected Connection c=new database().connect();
    protected   ResultSet result=null;
    protected int resultUpdate;
    protected String sql;
    public boolean Range(int from,int to){
        if(to<=from)
            return false;
        this.frm=from;
        this.tto=to;
        return true;
    }
    public boolean setCode(int code){
        if(code>=frm && code<=tto)
            this.code=code;
        else
            return false;
        return true;
    }
    public boolean addProduct(String type,int price,int code,int from,int to,int number,int client_id){
        if(this.Range(from,to) && this.setCode(code)){
            this.number=number;
            this.price=price;
            this.type=type;
            this.client_id=client_id;
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.util.Date date = new Date();
            this.product_id=0;
            this.product_id();
            this.sql="INSERT into products ( price, number, date, code, total," +
                    " client_id, type, frm, tto) VALUES ('"+this.price+
                    "','"+this.number+"','"+dateFormat.format(date)+"','"+this.code+"','"+this.price*this.number+"','"+this.client_id+"','"
                    +this.type+"','"+this.frm+"','"+this.tto+"')";
            try {
                this.s = this.c.createStatement();
                this.resultUpdate = this.s.executeUpdate(this.sql);
            } catch (SQLException e ) {
            }
            if ( this.resultUpdate== 1) {
                this.addToShop();
                return true;
            } else if(this.resultUpdate==0)
                return false;
            return true;
    }
    else
        return false;
    }
    public ArrayList<Integer> clients()    {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        try {
            this.s = this.c.createStatement();
        } catch (SQLException e) {
            System.out.println("one");
        }
        this.sql="select id FROM clients ";
        try {
            this.result = this.s.executeQuery(this.sql);
            try {
                while (this.result.next() ) {
                  numbers.add(this.result.getInt("id"));
                }

            }catch (SQLException e){}
            System.out.println("inner");

        } catch (SQLException e) {
            System.out.println("Two");
        }
        return numbers;
    }
    private int product_id(){
        int id=0;
        try {
            this.s = this.c.createStatement();
        } catch (SQLException e) {
            System.out.println("one");
        }
        this.sql="select MAX(id) FROM products WHERE code='"+this.code+"'";
        try {
            this.result = this.s.executeQuery(this.sql);
            try {
                if (this.result.next()  ) {
                    id=this.result.getInt("MAX(id)");
                }
            }catch (SQLException e){}
            System.out.println("inner");

        } catch (SQLException e) {
            System.out.println("Two");
        }
        this.product_id=id;
        return this.product_id;
    }
    public boolean sesson(String name){
        int code=this.product_id();
        int id;
        if(name=="summer")
            id = 1;
        else
            id = 2;

        this.sql="INSERT into products_sesson (product_id,sesson_id) VALUES ('"+code+
                "','"+id+"')";
        try {
            this.s = this.c.createStatement();
            this.resultUpdate = this.s.executeUpdate(this.sql);
        } catch (SQLException e ) {
            System.out.println("sesson" + this.sql);
        }
        if ( this.resultUpdate== 1) {
            return true;
        } else if(this.resultUpdate==0)
            return false;
        return true;
    }
    private void addToShop(){
        shop shop=new shop();
        int id=this.product_id;
            if(id!=0){
              shop.editItem(this.price,this.number,this.product_id(),id);
            }else {
                id=this.product_id();
                shop.addItem(this.price,this.number,id);
            }

    }

}

