import java.util.List;
//Αντικείμενο DVD
@XmlRootElement(name = "dvd")
class DVD{
    private String title;
    private List<String>actors = null;
    private String director;
    private int length;
    private List<String> dub_languages = null;
    private List<String> sub_languages = null;
    private String genre;
    private double price = 0.0f;
    private int copies = 0;
    private String ISBN;
    String getISBN(){return ISBN;}
    String getTitle(){return title;}
    List<String>getActors(){return actors;}
    String getDirector(){return director;}
    int getLength(){return length;}
    List<String>getDubbedLanguages(){return dub_languages;}
    List<String>getSubtitlesLanguages(){return sub_languages;}
    String getGenre(){return genre;}
    double getPrice(){return price;}
    int getCopies(){return copies;}
    void setPrice(double price){
        this.price = price;
    }
    void setCopies(int copies){
        this.copies = copies;
    }
    DVD(String title, List<String>actors, String director, int duration, List<String>dub_languages, List<String>sub_languages, String genre, String ISBN){
        this.title = title;
        this.actors = actors;
        this.director = director;
        this.duration = duration;
        this.dub_languages = dub_languages;
        this.sub_languages = sub_languages;
        this.genre = genre;
        this.ISBN = ISBN;
    }
    void UpdateDVDQuantity(int Copies) {
        System.out.println("Invorking PUT /DVDStore/Employee/");
        webTarget r = getTarget("/Employee");
        DVD dvd = createDVD();
        dvd.setCopies(this.copies + Copies);
        Invocation.Builder builder = r.request();
        Responce response = builder.post(Entity.entity(DVD.MediaType.APPLICATION_JSON).Responce(class);
        int status = response.getStatus();
        if(status >= 300) {
            System.out.println("Something went wrong updating DVD copies");
            System.out.println(response.readEntity(String.class));
        }
        else {
            System.out.println("Got successful result from invocation");
            System.out.printlm(responce.readEntity(String.class));
        }
    }
}
