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

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public int getArticleCount() {
        if (articles == null) {
            return 0;
        } else {
            return articles.size();
        }
    }

    public List<Article> getTopHeadlinesAustria() {
        if (articles != null) {
            return articles;
        } else {
            return new ArrayList<>();
        }
    }

    protected List<Article> filterList(String query, List<Article> articles) {

        List<Article> filteredArticles = new ArrayList<>();

        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getTitle().toLowerCase().contains(query.toLowerCase())) {
                filteredArticles.add(articles.get(i));
            }
        }
        return filteredArticles;
    }

    public List<Article> getAllNewsBitcoin () {
        return filterList("bitcoin", articles);
    }
}

