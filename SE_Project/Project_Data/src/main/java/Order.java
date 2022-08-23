@XmlRootElement(name = "order")
class Order{
    private String Order_ID;
    private String Deliveraddress;
    private String status;
    private String Customer_ID;
    private String ShoppingCard_ID;
    private String ISBN;
    private int creationday;
    private int creationmonth;
    private int creationyear;
    private int completionday;
    private int completionmonth;
    private int completionyear;
    private int totalValue;
    private String CancellationReason;
    private int remainingValue;
    private boolean paid = false;
    Order(String Order_ID, String Deliveraddress, String status, String Customer_ID, String ShoppingCard_ID, String ISBN, int creationday, int creationmonth, int creationyear){
        this.Order_ID = Order_ID;
        this.Deliveraddress = Deliveraddress;
        this.status = "Created";
        this.Customer_ID = Customer_ID;
        this.ShoppingCard_ID = ShoppingCard_ID;
        this.ISBN = ISBN;
        this.creationday = creationday;
        this.creationmonth = creationmonth;
        this.creationyear = creationyear;
        this.totalValue = totalValue;
    }

    String getOrderID(){return Order_ID;}
    String getDeliveraddress(){return Deliveraddress;}
    String getStatus(){
        return status;
    }
    String getShoppingCardID(){return ShoppingCard_ID;}
    String getISBN(){return ISBN};
    String getCreationDate(){return Integer.parseInt}
    void setStatus(String status){this.status = status;}
    void payOrder(int balance){

        remainingValue = totalValue - balance;
        if(remainingValue == 0){
            paid = true;
        }
    }
    boolean isPaid(){
        return paid;
    }
    void updateStatus(){
        String update sc.nextLine();
        if(update.equals("update") && Order.status == "created"  && remainingValue == 0){
            setStatus("charged");
            break;
        }
        else if(update.equals("update") && Order.status == "created"  && remainingValue != 0){
            setStatus("cancelled");
            break;
        }
        else if(update.equals("update") && Order.status == "charged"){
            setStatus("pending");
            break;
        }
        else if(update.equals("update") && Order.status == "pending"){
            setStatus("completed");
            break;
        }

    }
}