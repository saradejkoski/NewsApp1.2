package at.ac.fhcampuswien;

import java.util.ArrayList;
import java.util.List;

public class AppController {

    private List<Article> articles;

    public AppController() {
    }

    private static List<Article> generateMockList() { // List filled with dummies
        List<Article> articles = new ArrayList<>();
        articles.add(new Article("Goethe", "Faust"));
        articles.add(new Article("Shakespeare", "Hamlet"));
        articles.add(new Article("Dummy", "From Dummies For Dummies"));
        return articles;
    }

}
