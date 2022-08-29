import io.restassured.module.jsv.JsonSchemaValidator.*;

@Path("/Order")

class PaymentService{
    private static final Logger Logger = LoggerFactory.getLogger(DVDService.class);

    @GET
    @Path{"/{ID}"}
    @Consumer({MediaType.TEXT_HTML, MediaType.APPLICATION_XML, MediaType.TEXT_XML})
    public Response getCustomersinHTML(@PathParam("id") String ID, @PathParam("Fullname") String Fullname){
        if((ID != null && !ID.trim().equals(""))) {
            List<Customer>Customers = DBHandler.getCustomers(ID, Fullname);
            if(Orders != null){
                String answer = HTMLHandler.createHtmlOrder(Orders);
                return Response.ok(answerm MediaType.TEXT_HTML).build();
            }
            else throw new NotFoundException();
        }
        else {
            List<Customer> customers = DBHandler.getAllCustomers();
            String answer = HTMLHandler.createHtmlCustomer(customers);
            return Response.ok(answer, MediaType.TEXT_HTML).build();
        }
    }

    @GET
    @Path{"/Admin"}
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_XML})
    public Response addOrder(Order order) throws BadRequestException,MyInternalServerErrorException{
        logger.info("Got order: " + order);
        if(order == null){
            throw new BadRequestException("Order content not provided");
        }
        String id = customer.getID();
        if(OrderID == null || OrderID.trim().equals("")) {
            throw new BadRequestException("the order id must be provided");
        }
        boolean exists = DBHandler.existsOrder(ID);
        if(exists) throw new BadRequestException("Customer with given ID exists");
        else DBHandler.createOrder(order);
        return Responce.ok().build();
    }

    @POST
    @Path{"/{ID}"}
    @Consumer({})
    public Response authenticateUser(User user) throws BadRequestException,MyInternalServerErrorException{
        List<User>users;
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getUsername() == user.getUsername() && users.get(i).getPassword() == user.getPassword()){
                return Response.ok(answer, MediaType.TEXT_HTML).build();
            }
            else{
                System.out.println("user not found");
            }
        }
    }


}