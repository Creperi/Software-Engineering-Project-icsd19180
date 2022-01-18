import java.sql.Connection;
import java.sql.DriverManager;
package net.codejava.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Scanner;
package com.vogella.jersey.jaxb;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement

@XmlRootElement(name = "dvd")
class DVD{
    private String title;
    private String actors;
    private String director;
    private int duration;
    private String dub_languages;
    private String sub_languages;
    private String genre;
    private double price = 0.0f;
    private int copies = 0;
    private String ISBN;
    void setPrice(double price){
        this.price = price;
    }
    void setCopies(int copies){
        this.copies = copies;
    }

    DVD(String title, String actors, String director, int duration, String dub_languages, String sub_languages, String genre, String ISBN){
        this.title = title;
        this.actors = actors;
        this.director = director;
        this.duration = duration;
        this.dub_languages = dub_languages;
        this.sub_languages = sub_languages;
        this.genre = genre;
        this.ISBN = ISBN;
    }

}

@WebServlet("/loginServlet")
class User extends HttpServlet{
    private String Fullname;
    private String username;
    private String password;
    User(String Fullname, String username, String password){
        this.Fullname = Fullname;
        this.username = username;
        this.password = password;
    }
    void Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String htmlRespone = "<html>";
        htmlRespone += "<h2>Your username is: " + username + "<br/>";
        htmlRespone += "Your password is: " + password + "</h2>";
        htmlRespone += "</html>";
    }
    void editOrder(List<Class>Order){
        if(Order.getStatus().equals(""))
    }
}

@XmlRootElement(name = "user")
class Customer extends User{
    private String Creditcardnumber;
    private int CVV;
    private String Creditcardtype;
    private int expmonth;
    private int expyear;
    Customer(String Fullname, String username, String password, String address, String Creditcardnumber, int CVV, String Creditcardtype, int expmonth, int expyear){
        Super(Fullname, username, password);
        this.address = address;
        this.Creditcardnumber = Creditcardnumber;
        this.CVV = CVV;
        this.Creditcardtype = Creditcardtype;
        this.expmonth = expmonth;
        this.expyear = expyear;
    }

    void EditOrder(List<Class>Order) {
        for(Class order : Order){
            if(order.getStatus())
        }
    }
     CancelCard(List<Class>Card){
        for(Class card : Card){
            if(!(card.getStatus().equals("Active"))){
                System.out.println("The card can't be deleted");
            }

        }
    }
    void ViewOrders(List<Class>Order){
        for(Class order : Order){
            if(Fullname.equals(order.getFullname())){
                System.out.println(order.getOrder());
            }
        }
    }
}

@XmlRootElement(name = "employee")
class Employee extends User{
    private String role;
    Customer(String Fullname, String username, String password, String role){
        Super(Fullname, username, password);
        this.role = role;
    }
    void ManageOrders(class Order){

    }
    void ManageCards(class Card){

    }
    void getPassword(){
        return Password;
    }
}

@XmlRootElement(name = "order")
class Order{
    private String ID;
    private String Deliveraddress;
    private String status;
    private String Customer_ID;
    private String Card_ID;
    private String ISBN;
    private int creationday;
    private int creationmonth;
    private int creationyear;
    private int completionday;
    private int completionmonth;
    private int completionyear;
    Order(String ID, String Deliveraddress, String status, String Customer_ID, String Card_ID, String ISBN, int creationday, int creationmonth, int creationyear){
        this.ID = ID;
        this.Deliveraddress = Deliveraddress;
        this.status = status;
        this.Customer_ID = Customer_ID;
        this.Card_ID = Card_ID;
        this.ISBN = ISBN;
        this.creationday = creationday;
        this.creationmonth = creationmonth;
        this.creationyear = creationyear;
    }
    void UpdateStatus(String status){
        this.status = status;
    }
    void getStatus(){
        return status;
    }
    String getCustomerID(){
        return Customer_ID;
    }
}
@XmlRootElement(name = "order")
class PurchaseCard{
    private String ID;
    private String customerID;
    private int creationday;
    private int creationmonth;
    private int creationyear;
    private double balance = 0.0f;
    PurchaseCard(String ID, String customerID, int creationday, int creationmonth, int creationyear){
        this.ID = ID;
        this.CustomerID = customerID;
        this.creationday = creationday;
        this.creationmonth = creationmonth;
        this.creationyear = creationyear;
    }
    void generateID(){
        byte[] array = new byte[16];
        new Random().nextBytes(array);
        String ID = new String(array, Charset.forName("UTF-8"));
    }
    void addBalance(double balance){
        balance = balance + this.balance;
    }
    String getPurchaseCard(){
        return "ID" + ID + "\ncustomerID" + customerID + "\ncreationDate" +
                creationday + "/" + creationmonth + "/" + creationyear + + "\nbalance" + balance;
    }
}

class SQLinjecton(String query){
    List<Class> DVDS = new ArrayList<Class>();
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3308/dvd_club","root","");
        Statement stmt=con.createStatement();
        stmt.addBunch("select * from DVD");
        stmt.addBunch("select * from user");
        stmt.addBunch("select * from customer");
        stmt.addBunch("select * from employee");
        stmt.addBunch("select * from order");
        stmt.executeBatch();
        while(rs.next()){
            DVDS.add(rs.getString('ID'),//Μπαίνουν οι υπόλοιπες μεταβλητές//);
        }
        //...Τα επόμενα ισχύουν και για τους υπόλοιπους πίνακες
    }
    catch{

    }
}
