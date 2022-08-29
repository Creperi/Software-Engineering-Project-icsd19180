import io.restassured.module.jsv.JsonSchemaValidator.*;

@Path("/DVD")

class DVDService{
    private static final Logger Logger = LoggerFactory.getLogger(DVDService.class);

    @POST
    @Path ("/DVD/{isbn}")
    @Consumer({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_XML})
    public Response addDVD(DVD dvd) throws BadRequestException, MyInternalServerErrorException{
        logger.info("Get dvd: " + dvd);
        if(dvd == null){
            throw new BadRequestException("Did not provide DVD content");
        }
        String dvdIsbn = dvd.getISBN();
        if(dvdIsbn == null || dvdIsbn.trim().equals("")){
            throw new BadRequestException("DVD ISBN not provided");
        }
        List<String>Director = dvd.getDirectors();
        if(Director == null || Director.isEmpty()){
            throw new BadRequestException("MUST provide the director of the movie")
        }
        String Title = dvd.getTitle();
        if(Title == null || Title.trim().equals("")){
            throw new BadRequestException("MUST provide the title of the movie")
        }
        boolean exists = DBHandler.existsDvd(dvdIsbn);
        if(exists) throw new BadRequestException("DVD with given isbn exists");
        else DBHandler.createDvd(dvd);
        return Responce.ok().build();
    }

    @Produces({MediaType.TEXT_HTML, MediaType.TEXT_PLAIN})
    public Response getDVDinHTML(@QueryParam("isbn") @DefaultValue("") String isbn, @QueryParam("title") @DefaultValue("") String title, @QueryParam("director") @DefaultValue("") String director) throws BadRequestException, MyInternalServerErrorException{
        if((isbn != null && !isbn.trim().equals(""))) {
            List<DVD>DVDs = DBHandler.getDVDs(isbn, title, director);
            if(DVDs != null){
                String answer = HTMLHandler.createHtmlDVD(DVDs);
                return Response.ok(answer, MediaType.TEXT_HTML).build();
            }
            else throw new NotFoundException();
        }
        else {
            List<DVD> DVDs = DBHandler.getAllDVDs();
            String answer = HTMLHandler.createHtmlDVD(DVDs);
            return Response.ok(answer, MediaType.TEXT_HTML).build();
        }

    }


    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_XML})
    public Response InsertDVDToShoppingCard(ShoppingCard shoppingcard, DVD dvd, int requestedcopies) throws BadRequestException, MyInternalServerErrorException{
        if(shoppingcard == null){
            System.out.println("DVDs can't be added to shopping card")
        }else{
            if(requestedcopies <= dvd.getAvailableCopies()){
                shoppingcard.addDVDTitle(dvd.getTitle());
                shoppingcard.addDVDCopies(requestedcopies);
                dvd.setCopies(dvd.getAvailableCopies() - requestedcopies);
                String answer = HTMLHandler.
            }
            else{
                System.out.println("The DVD can't be added due to insufficient number of copies");
            }
        }
        return Response.ok(answer, MediaType.TEXT_HTML).build();
    }

    @GET
    @Produces({MediaType.TEXT_HTML, MediaType.TEXT_PLAIN})
    public Response getShoppingCardHTML(@QueryParam("Title") @DefaultValue("") String title,
                               @QueryParam("Actor") @DefaultValue("") String actor,
                               @QueryParam("Director") @DefaultValue("") String director) throws BadRequestException, MyInternalServerErrorException{
        if((title != null && !title.trim().equals("")) || (actor != null && !actor.isEmpty()) || (director != null && !director.isEmpty())) {
            List<DVD>DVDs = DBHandler.getDVDs(title, actor, director);
            if(DVDs != null){
                String answer = HTMLHandler.createHtmlDVD(DVDs);
                return Response.ok(answer, MediaType.TEXT_HTML).build();
            }
            else throw new NotFoundException();
        }
        else {
            List<DVD> DVDs = DBHandler.getAllDVDs();
            String answer = HTMLHandler.createHtmlDVD(DVDs);
            return Response.ok(answer, MediaType.TEXT_HTML).build();
        }

    }

}