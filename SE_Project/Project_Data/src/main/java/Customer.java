import javax.xml.bind.annotation.XmlRootElement;

//Αντικείμενο κλάσης Πελάτη
@XmlRootElement(name = "user")
class Customer extends User{
    private String ID;
    private String Fullname;
    private String Gender;
    private int Age;
    private String HomeAddress;
    private String PhoneNumber;
    private String Creditcardnumber;
    private int CVV;
    private String Creditcardtype;
    private String expmonth;
    private String expyear;
    Customer(String username, String password, String Fullname, String Gender, int Age, String HomeAddress, String Creditcardnumber, int CVV, String Creditcardtype, int expmonth, int expyear) {
        Super(username, password);
        this.Fullname = Fullname;
        this.Gender = Gender;
        this.Age = Age;
        this.HomeAddress = HomeAddress;
        this.Creditcardnumber = Creditcardnumber;
        this.CVV = CVV;
        this.Creditcardtype = Creditcardtype;
        this.expmonth = expmonth;
        this.expyear = expyear;
    }
    String getID() {return ID;}
    String getFullname(){
        return Fullname;
    }
    String getGender(){
        return Gender;
    }
    int getAge(){return Age;}
    String getHomeAddress(){
        return HomeAddress;
    }
    String getCreditcardnumber(){return Creditcardnumber;}
    int getCVV(){
        return CVV;
    }
    String getExpDate(){
        return expmonth + "/" + expyear;
    }
    String getCreditCardType(){
        return Creditcardtype;
    }
}
}