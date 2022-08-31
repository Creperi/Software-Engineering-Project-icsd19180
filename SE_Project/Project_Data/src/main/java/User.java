import javax.xml.bind.annotation.XmlRootElement;

@WebServlet("/loginServlet")
class User{
    private String username;
    private String password;
    User(String username, String password){
        this.username = username;
        this.password = password;
    }
    String getUsername(){return username};
    void Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String htmlResponse = "<html>";
        htmlResponse += "<h2>Your username is: " + username + "</h2><br/>";
        htmlResponse += "<h2>Your password is: " + password + "</h2>";
        htmlResponse += "</html>";
        request.login(username, password);
    }
}
