import java.sql.Connection;

public class DBHandler{
    static {createTable(String Query);}

    private static void createTable(String Query){
        if(PropertyReader.isSqlLite()){
            try {
                class.forName("org.sqlite.JDBC");
                Connection con = DriverManager.getConnection("jdbc:sqlite:./DVDshop.db");
                Statement stmt = com.createStatement();
                stmt.execute(Query);//Δημιουργούμε καινούργιο πίνακα
                stmt.close();
                con.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    private static Connection getConnection() throws MyEternalServerErrorException{
        try{
            Connection con = null;
            if(PropertyReader.isSqlite()){
                Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection("jdbc:sqlite./my.db");
            } else{
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://" + PropertyReader.getDBPost() + ":" + PropertyReader.getDBPort() + "/DVD", PropertyReader.getLogin(),PropertyReader.getPwd());
            }
            return con;
        }
        catch(Exception e) {
            throw new MyinternalServerErrorException("Cannot connect to the database");
        }
    }

    private static List<DVD> getDVDs(String isbn, String title, String director){
        List<DVD> dvd = null;
        boolean hasIsbn = false, hasTitle = false, hasDirector = false;
        hasIsbn = (isbn != null && (isbn.trim().equals("")));
        hasTitle = (title != null && (title.trim().equals("")));
        hasDirector = (director != null && (director.trim().equals("")));
        Connection con = getConnection();
        try{
            Statement stmt = con.createStatement();
            String query = "select * from dvd";
            if(hasIsbn || hasTitle || hasDirector) query += "where ";
            if(hasTitle) query += "title = '" + title + "' ";
            if(hasDirector) query += " and director = '" + director + "'";
            ResultSet rs = stmt.execQuery(query);
            if(rs.next()){
                dvd = new ArrayList<DVD>();
                dvd.add(getDVDsfromDB(rs));
                while(rs.next()){
                    dvd.add(getDVDsfromDB(rs));
                }
            }
            con.close();
        } catch(Exception e){
            System.out.println("An error has occured");
        }
        return dvd;
    }

    private static List<DVD> getOrders(String OrderID, String CustomerID){
        List<DVD> dvd = null;
        boolean hasOrderId = false, hasCustomerId = false;
        hasOrderId = (OrderID != null && (OrderID.trim().equals("")));
        hasCustomerId = (CustomerID != null && (CustomerID.trim().equals("")));
        Connection con = getConnection();
        try{
            Statement stmt = con.createStatement();
            String query = "select * from order";
            if(hasOrderId || hasCustomerId) query += "where ";
            if(hasOrderId) query += "OrderID = '" + OrderID + "' ";
            if(hasCustomerId) query += " and CustomerID = '" + CustomerID + "'";
            ResultSet rs = stmt.execQuery(query);
            if(rs.next()){
                orders = new ArrayList<Order>();
                orders.add(getOrdersfromDB(rs));
                while(rs.next()){
                    orders.add(getOrdersfromDB(rs));
                }
            }
            con.close();
        } catch(Exception e){
            System.out.println("An error has occured");
        }
        return orders;
    }

    private static List<Customer> getCustomers(String ID, String Fullnme){
        List<Customer> Customers = null;
        boolean hasID = false, hasFullname = false;
        hasID = (ID != null && (ID.trim().equals("")));
        hasFullname = (Fullnme != null && (Fullnme.trim().equals("")));
        Connection con = getConnection();
        try{
            Statement stmt = con.createStatement();
            String query = "select * from customer";
            if(hasID || hasFullname) query += "where ";
            if(hasID) query += "ID = '" + ID + "' ";
            if(hasFullname) query += " and fullname = '" + Fullname + "'";
            ResultSet rs = stmt.execQuery(query);
            if(rs.next()){
                customers = new ArrayList<Customer>();
                customers.add(getCustomersfromDB(rs));
                while(rs.next()){
                    customers.add(getCustomersfromDB(rs));
                }
            }
            con.close();
        } catch(Exception e){
            System.out.println("An error has occured");
        }
        return orders;
    }

    private static DVD getDVDsfromDB(ResultSet rs) throws SQLException{
        DVD dvd = new DVD(rs.getString("title"), rs.getString("director"), rs.getString("duration"), rs.getString("genre"), rs.getString("ISBN"),);
        String actors = rs.getString("actors");
        List<String>Actors = DVD.getActors(actors);
        DVD.setActors();
    }

    private static ShoppingCard getShoppingCardsfromDB(ResultSet rs) throws SQLException{
        ShoppingCard shoppingcard = new ShoppingCard(rs.getString("id"),  rs.getString("customerID"), rs.getInteger("creationday"),  rs.getInteger("creationmonth"),  rs.getInteger("creationyear"));
        List<String>Actors = DVD.getActors(actors);
    }
    private static User getUsersfromDB(ResultSet rs) throws SQLException{
        User user = new User(rs.getString("username"), rs.getString("password"));
        return user;
    }

    private static Customer getCustomersfromDB(ResultSet rs) throws SQLException{
        Customer customer = new Customer(rs.getString("ID"), rs.getString("fullname"), rs.getString("gender"), rs.getString("age"),rs.getString("homeaddress"), rs.getString("phonenumber"), rs.getString("creditcardnumber"), rs.getString("cvv"), rs.getString("creditcardtype"), rs.getString("expmonth"),rs.getString("expyear"));
        return customer;
    }

    private static Employer getEmployersfromDB(ResultSet rs) throws SQLException{
        Employer employer = new Customer(rs.getString("fullname"), rs.getString("role"));
        return employer;
    }

    private static Order getOrdersfromDB(ResultSet rs) throws SQLException{
        Order order = new Order(rs.getString("order_id"), rs.getString("deliveryaddress"), rs.getString("status"), rs.getString("customer_id"), rs.getString("shoppingcard_id"), rs.getString("isbn", )rs.getString("creationday"), rs.getString("creationmonth"), rs.getString("creationyear"), rs.getString("totalvalue"));
        return order;
    }

    public static void updateOrderStatus(Order order, String status){
        Connection con = getConnection();
        try{
            Statement stmt = con.createStatement();
            String query = "update order set status = " + status + " where order_id = " + order.getOrderID();
            stmt.execute(query);
            con.close();
        }catch(Exception e){
            throw new MyInternalServerErrorException("Error");
        }
    }

    public static void updateShoppingCardStatus(ShopppingCard shoppingcard, String status){
        Connection con = getConnection();
        try{
            Statement stmt = con.createStatement();
            String query = "update shoppingcard set status = " + status + " where id = " shoppingcard.getID();
            stmt.execute(query);
            con.close();
        }catch(Exception e){
            throw new MyInternalServerErrorException("Error");
        }
    }

    public static void updateDVDNumberofCopies(DVD dvd, int copies){
        Connection con = getConnection();
        try{
            Statement stmt = con.createStatement();
            String query = "update dvd set copies = " + copies + " where id = " dvd.getISBN();
            stmt.execute(query);
            con.close();
        }catch(Exception e){
            throw new MyInternalServerErrorException("Error");
        }
    }

    public static void updateDVDNumberofCopies(DVD dvd, int copies){
        Connection con = getConnection();
        try{
            Statement stmt = con.createStatement();
            String query = "update dvd set copies = " + copies + " where id = " dvd.getISBN();
            stmt.execute(query);
            con.close();
        }catch(Exception e){
            throw new MyInternalServerErrorException("Error");
        }
    }

    public static void
}