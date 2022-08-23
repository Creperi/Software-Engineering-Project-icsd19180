package com.vogella.jersey.jaxb;

import javax.ws.rs.*;
import javax.xml.bind.annotation.XmlRootElement;

//Δημιουργεί κάρτα αγορών ξεχωριστά για κάθε πελάτη
@POST
@Produces({MediaType.TEXT_HTML})
@apa
List<Object>DVD;
List<Object>Customers;
List<Object>ShoppingCards;
public String generateShoppingCardID(Class ShoppingCard){
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
        int index = (int)(AlphaNumericString.length() * Math.random());
        sb.append(AlphaNumericString.charAt(index));
        }
        ShoppingCard.setID(sb);
        return "<p>Shopping card ID generated</p>"
        }