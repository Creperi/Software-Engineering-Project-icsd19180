@XmlRootElement(name = "Shopping Card")
class ShoppingCard{
    private String ID;
    private String customerID;
    private int creationday;
    private int creationmonth;
    private int creationyear;
    private double balance;
    List<String>DVDTitles = null;
    List<Intefer>DVDCopies = null;
    private boolean cancelled = false;
    ShoppingCard(String ID, String customerID, int creationday, int creationmonth, int creationyear){
        if(DVDs == null){
            this.ID = ID;
            this.CustomerID = customerID;
            this.creationday = creationday;
            this.creationmonth = creationmonth;
            this.creationyear = creationyear;
            this.balance = 0.0f;
            DVDTitles = new ArrayList<String>;
            DVDCopies = new ArrayList<Integer>;
            this.DVDTitles = DVDTitles;
            this.DVDCopies = DVDCopies;
        }
    }
    void setID(String ID){
        this.ID = ID;
    }
    String getID(){return ID;}
    String getCustomerID(){return CustomerID;}
    String getCreationDate(){return Integer.parseInt(creationday) + "/" + Integer.parseInt(creationmonth) + "/" + Integer.parseInt(creationyear);}
    double getBalance(){return balance;}
    boolean isCancelled(){
        return cancelled;
    }
    void addDVDTitle(String title){
        if(DVDTitles != null){
            DVDTitles.add(title);
        }
    }
    void addDVDCopies(String copies){
        if(DVDCopies != null){
            DVDCopies.add(copies);
        }
    }
    List<String>getDVDTitles(){
        List<String>titles() = new ArrayList<String>();
        String[]res = str.split(", ");
        for(String s: res) authors.add(i);
        return
    }
    void addBalance(double balance){ this.balance += balance; }

    void addAvailableDVDCatalogue(string Title, int Copies){
        if(DVDs == null && DVDAvailableCapacities == null){
            List<String>DVDs = new List<>();
            List<Integer>DVDAvailableCapacities = new List<>();
        }
        DVDs.add(Title);
        DVDAvailableCopies.add(Copies);
    }
}