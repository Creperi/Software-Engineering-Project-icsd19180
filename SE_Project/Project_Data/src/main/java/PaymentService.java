import io.restassured.module.jsv.JsonSchemaValidator.*;

@Path("/Order")

class PaymentService{
    private static final Logger Logger = LoggerFactory.getLogger(DVDService.class);

    @GET
    @Path{"/{OrderID}"}
    @Consumer({MediaType.TEXT_HTML, MediaType.APPLICATION_XML, MediaType.TEXT_XML})
    public Response getOrderinHtml(@PathParam("OrderID") String OrderID, @PathParam("CustomerID") String CustomerID){
        if((OrderID != null && !OrderID.trim().equals(""))) {
            List<Order>Orders = DBHandler.getOrders(OrderID, CustomerID);
            if(Orders != null){
                String answer = HTMLHandler.createHtmlOrder(Orders);
                return Response.ok(answerm MediaType.TEXT_HTML).build();
            }
            else throw new NotFoundException();
        }
        else {
            List<DVD> DVDs = DBHandler.getAllDVDs();
            String answer = HTMLHandler.createHtmlDVD(DVDs);
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
        String OrderID = order.getOrderID();

    }

    @POST
    @Path{"/{OrderID}"}
    @Consumer({})
    public Response updateOrderStatus(Order, order) throws BadRequestException,MyInternalServerErrorException{
        logger.info("")
    }
}