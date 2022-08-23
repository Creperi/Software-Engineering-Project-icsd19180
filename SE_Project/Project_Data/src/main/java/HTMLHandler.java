import java.util.List;

class HTMLHandler() {
    public static String getList(List<String>list){
        String str = list.get(0);
        for(int i = 0; i < list.size(); i++){
            str += ", " + list.get(i);
        }
        return str;
    }
    public static String createDVDRow(List<DVD> DVDs) {
        String str +="<tr>\n";
        str += "<td>" + DVDs.getISBN() + "</td>";
        str += "<td>" + DVDs.getTitle() + "</td>";
        str += "<td>" + getList(DVDs.getActors()) + "</td>";
        str += "<td>" + DVDs.getDirector() + "</td>";
        str += "<td>" + DVDs.getLength() + "</td>";
        str += "<td>" + getList(DVDs.getDubbedLanguages()) + "</td>";
        str += "<td>" + getList(DVDs.getSubtitlesLanguages()) + "</td>";
        str += "<td>" + DVDs.getGenre() + "</td>";
        str += "<td>" + DVDs.getPrice() + "</td>";
        str += "<td>" + DVDs.getCopies() + "</td>";
        str += "</tr>";

        return str;
    }

    public static String createHtmlDVD(List<DVD> DVDs) {
        String answer +="<html>\n";
        answer += "<head>\n";
        answer += "<title>List of Customers</title>\n";
        answer += "</head>\n";
        answer += "<body>\n";
        answer += "<h1>Customers</h1>\n";
        answer += "</table border=\"1\" width=\"60%\" align=\"center\">\n";
        answer += "<tr><th>ISBN</th>" +
                "<th>Title</th>" +
                "<th>Actors</th>" +
                "<th>Director</th>" +
                "<th>Length</th>" +
                "<th>Dubbed Languages</th>" +
                "<th>Subtitles Languages</th>" +
                "<th>Genre</th>" +
                "<th>Price</th>" +
                "<th>Copies</th>" +
                "</tr>";
        answer += createDVDRow(DVDs);
        answer += "</table>\n</html>";

        return answer;
    }
    public static String createCustomerRow(List<Customer> Customers) {
        String str +="<tr>\n";
        str += "<td>" + Customers.getID() + "</td>";
        str += "<td>" + Customers.getFullname() + "</td>";
        str += "<td>" + Customers.getGender() + "</td>";
        str += "<td>" + Customers.getAge() + "</td>";
        str += "<td>" + Customers.getHomeAddress() + "</td>";
        str += "<td>" + Customers.getPhoneNumber() + "</td>";
        str += "<td>" + Customers.getCreditcardNumber() + "</td>";
        str += "<td>" + Customers.getCVV() + "</td>";
        str += "<td>" + Customers.getCreditcardType() + "</td>";
        str += "<td>" + Customers.getExpDate() + "</td>";
        str += "<td>" + +"</td>";
        str += "</tr>";

        return str;
    }

    public static String createHtmlCustomer(List<Customer> Customers) {
        String answer +="<html>\n";
        answer += "<head>\n";
        answer += "<title>List of Customers</title>\n";
        answer += "</head>\n";
        answer += "<body>\n";
        answer += "<h1>Customers</h1>\n";
        answer += "</table border=\"1\" width=\"60%\" align=\"center\">\n";
        answer += "<tr><th>ID</th>" +
                "<th>Fullname</th>" +
                "<th>Gender</th>" +
                "<th>Age</th>" +
                "<th>Home Address</th>" +
                "<th>Credit card number</th>" +
                "<th>CVV</th>" +
                "<th>Credit card type</th>" +
                "<th>Expiration Date</th>" +
                "</tr>";
        answer += createCustomerRow(Customers);
        answer += "</table>\n</html>";

        return answer;
    }

    public static String createShoppingCardRow(List<ShoppingCard> ShoppingCard) {
        String str +="<tr>\n";
        str += "<td>" + ShoppingCards.getID() + "</td>";
        str += "<td>" + ShoppingCards.getCustomerID() + "</td>";
        str += "<td>" + ShoppingCards.getCreationDate() + "</td>";
        str += "<td>" + ShoppingCards.getBalance() + "</td>";
        str += "<td>" + ShoppingCards.getAvailableDVD() + "</td>";
        str += "</tr>";

        return str;
    }

    public static String createHtmlShoppingCards(List<ShoppingCard> ShoppingCard) {
        String answer +="<html>\n";
        answer += "<head>\n";
        answer += "<title>List of Shopping Cards</title>\n";
        answer += "</head>\n";
        answer += "<body>\n";
        answer += "<h1>Shopping Cards</h1>\n";
        answer += "</table border=\"1\" width=\"60%\" align=\"center\">\n";
        answer += "<tr><th>ID</th>" +
                "<th>CustomerID</th>" +
                "<th>Creation Date</th>" +
                "<th>Balance</th>" +
                "<th>Available DVD Titles</th>" +
                "</tr>";
        answer += createShoppingCardRow(ShoppingCard);
        answer += "</table>\n</html>";

        return answer;
    }

    public static String createOrderRow(List<Order> Orders) {
        String str +="<tr>\n";
        str += "<td>" + Orders.getOrderID() + "</td>";
        str += "<td>" + Orders.getDeliveryAddress() + "</td>";
        str += "<td>" + Orders.getStatus() + "</td>";
        str += "<td>" + Orders.getCustomerID() + "</td>";
        str += "<td>" + Orders.getShoppingCardID() + "</td>";
        str += "<td>" + Orders.getISBN() + "</td>";
        str += "<td>" + Orders.getCreationDate() + "</td>";
        str += "<td>" + Orders.getCompletionDate() + "</td>";
        str += "<td>" + Orders.getTotalValue() + "</td>";
        //str += "<td>" + Orders.getExpDate() +"</td>";
        str += "</tr>";

        return str;
    }

    public static String createHtmlOrder(List<Order> Orders) {
        String answer +="<html>\n";
        answer += "<head>\n";
        answer += "<title>List of Orders</title>\n";
        answer += "</head>\n";
        answer += "<body>\n";
        answer += "<h1>Orders</h1>\n";
        answer += "</table border=\"1\" width=\"60%\" align=\"center\">\n";
        answer += "<tr><th>Order ID</th>" +
                "<th>Delivery Address</th>" +
                "<th>Status</th>" +
                "<th>Customer ID</th>" +
                "<th>Shopping Card ID</th>" +
                "<th>ISBN</th>" +
                "<th>Creation Date</th>" +
                "<th>Completion Date</th>" +
                "<th>Total Value</th>" +
                "</tr>";
        answer += createOrderRow(Orders);
        answer += "</table>\n</html>";

        return answer;
    }

    public static String createEmployerRow(List<Employer> Employers) {
        String str +="<tr>\n";
        str += "<td>" + Employers.getFullname() + "</td>";
        str += "<td>" + Employers.getRole() + "</td>";
        str += "</tr>";

        return str;
    }

    public static String createHtmlEmployer(List<Employer> Employers) {
        String answer +="<html>\n";
        answer += "<head>\n";
        answer += "<title>List of Orders</title>\n";
        answer += "</head>\n";
        answer += "<body>\n";
        answer += "<h1>Orders</h1>\n";
        answer += "</table border=\"1\" width=\"60%\" align=\"center\">\n";
        answer += "<tr><th>Order ID</th>" +
                "<th>Fullname</th>" +
                "<th>Role</th>" +
                "</tr>";
        answer += createEmployerRow(Customers);
        answer += "</table>\n</html>";

        return answer;
    }
}