import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employee")
class Employee extends User{
    private String role;
    Customer(String Fullname, String username, String password, String role){
        Super(username, password);
        this.Fullname = Fullname;
        this.role = role;
    }
    String getFullname() { return Fullname; }
    String getPassword(){
        return Password;
    }
}