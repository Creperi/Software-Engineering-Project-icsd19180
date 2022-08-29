import static org.junit.jupiter.api.Assertions.*;

class testing{

    @Test
    void insertDVD(){
        List<String>actors = new ArrayList<String>;
        actors.add("Timothée Chalamet");
        actors.add("Rebecca Ferguson");
        actors.add("Oscar Isaac");
        actors.add("Josh Brolin");
        actors.add("Stellan Skarsgård");
        List<String>sub_languages = new ArrayList<String>;
        sub_languages.add("English");
        sub_languages.add("German");
        sub_languages.add("French");
        DVD dvd = new DVD("DUNE", actors, "Dennis Villeneue", 155, "English", sub_languages, "Science Fiction", "8923j239-2");
    }
}