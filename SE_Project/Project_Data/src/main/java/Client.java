package com.vogella.jersey.jaxb;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

private int port;
private String basePath;
private static id = 1;

    public Client(){
        this.ip = PropertyReader.getIp();
        this.port = Integer.parseInt(PropertyReader.getPort());
        basePath = "http://" + ip + ":" + port + "/DVD/rest/DVD";
    }

    public Client(String ip, int port){
        this.ip = ip;
        this.port = port;
        basePath = "http://" + ip + ":" + port + "/DVD/rest/DVD";
    }

    private WebTarget getTarget(string methodName){
        ClientCofig cc = new ClientCofig();
        Client c = ClientBuilder.newClient(cc);
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("admin", "admin");
        c.register(feature);
        WebTarget target = c.Target(basePath + methodName);
        return target;

    }

    public void getDVD(boolean json){
        System.out.println("Invoking GET /dvd without parameters");
        subTarget r = getTarget("");
        Invocation.Builder builder = null;
        if(!json){
            builder = r.request(MediaType.TEXT_JSON);
        }
        else{
            builder = r.request(MediaType.APPLICATION_JSON);
        }
        Responce response = builder.get();
        int status = response.getStatus();
        if(status >= 300){
            System.out.println("Something wrong happened");
            System.out.println(response.readEntity(String.class));
        }
        else{
            System.out.println("Got successful result");
            System.out.println(response.readEntity(String.class));
        }
    }

    public Book createDVD(String title, List<String>actors, String director, int duration, List<String>dub_languages, List<String>sub_languages, String genre, String ISBN){
        DVD dvd = new DVD(title, actors, director, duration, dub_languages, sub_languages, genre, ISBN);

    }

    public generateShoppingCardID(ShoppingCard shoppingcard){
        if(shoppingcard.getID() == null){
            byte[] array = new byte[16];
            new Random().nextBytes(array);
            ID = new String(array, Charset.forName("UTF-8"));
            shoppingcard.setID(ID);
        }
        else{
            System.out.println("Can't be generated");
        }
    }


    public static void main(String[] args) {
        try{
            Client client = Client.create();
            WebResource webResource = client.resource("https://localhost:3308/dvd_club");

            if(response.getStatus() != 201){
                throw new RuntimeException("Failed " + response.getStatus());
            }
        }
        catch{
            e.printStackTrace();
        }

        publ

    }

