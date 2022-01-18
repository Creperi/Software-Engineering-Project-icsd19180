package com.vogella.jersey.jaxb;

import javax.ws.rs.*;
import javax.xml.bind.annotation.XmlRootElement;

@Path("/Main")
public class Client{

    @POST
    @Produces({MediaType.TEXT_XML})
    public void successfulLogin(){

    }

    @POST
    @Produces({MediaType.TEXT_XML})
    public String generateOrder(Class Order, String ID, String Deliveraddress, String status, String Customer_ID, String Card_ID, String ISBN, int creationday, int creationmonth, int creationyear){
        if(Order == null){
            Order(ID, Deliveraddress, status, Customer_ID, Card_ID, ISBN, creationday, creationmonth, creationyear);
            return "<p>Order created successfully</p>"
        }
        else{
            return "<p>Failed to create order</p>"
        }
    }

    @POST
    @GET
    @Produces({MediaType.TEXT_XML})
    public String updateOrderStatus(String status, Class Order){
        if(Order.getStatus() == "created" && (status.equals("charged")||status.equals("cancelled"))){
            Order.setStatus(status);
        }
        if(Order.getStatus() == "charged" && (status.equals("pending")||status.equals("completed"))){
                Order.setStatus(status);
        }
        else if(Order.getStatus() == "pending"){
            System.out.println("The order is pending due to the " + Order.getReason());
        }
        else if(Order.getStatus() == "cancelled"){
            System.out.println("The order is cancelled due to the " + Order.getReason());
        }
        Order.setStatus(status);
        return "<p>Order status: " + order.getStatus() + "</p>";
    }

    @DELETE
    @Produces({MediaType.TEXT_XML})
    public String deleteOrder(Class Order){
        if(!(Order.getStatus() == "active")){
            System.out.println("The order can't be deleted");
        }
        else{
            Order.setStatus("deleted");
            return "<p>Status: " + Order.getStatus() + "</p>";
        }
    }

    @POST
    @Produces({MediaType.TEXT_XML})
    public String setBalance(Class PurchaseCard, double balance){
        PurchaseCard.addBalance(balance);
        return "<p>Balance added</p>"
    }

    @POST
    @Produces({MediaType.TEXT_XML})
    public String generatePurchaseCardID(Class PurchaseCard){
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index = (int)(AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        PurchaseCard.setID(sb);

        return "<p>Purchase card ID generated</p>"
    }


    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost:8080/com.vogella.jersey.jaxb").build();
    }

    public static void main(String[] args) {
        String uri = "https://localhost:3308/dvd_club";
        EmpRequest request = new EmpRequest();

        request.setId(2);
        request.setName("PK");
        try {
            Client client = Client.create();
            WebResource r = client.resource(uri);
            ClientResponse response = r.type(MediaType.APPLICATION_XML).post(ClientResponse.class, request);

        }
    }
}