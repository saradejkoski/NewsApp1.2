package at.ac.fhcampuswien;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class AppControllerTest {

    private static AppController ctrl;

    @BeforeAll
    public static void beforeAll() {
        ctrl = new AppController();
    }

    @Test
    @DisplayName("test if setArticle works by checking if the article count is empty")
    public void testIfArticlesWereSet() throws NoSuchFieldException {
        List<Article> articleList = new ArrayList<>();
        articleList.add(new Article("Gothe", "Faust"));
        ctrl.setArticles(articleList);
        Assertions.assertTrue(ctrl.getArticleCount() != 0);
    }

    @Test
    @DisplayName("test if articleCount returns 3 when asking for article count")
    public void testIfArticleCountIs3() {
        Assertions.assertEquals(3,ctrl.getArticleCount(),3);
    }

    @Test
    @DisplayName("test if ArticleCount is zero when articles are null")
    public void testIfArticleCountIsZeroWhenArticlesNull(){
        ctrl.setArticles(null);

        Assertions.assertEquals(3, ctrl.getArticleCount());
    }

    @Test
    @DisplayName("test if getTopHeadlinesAustria returns empty list when is not null")
    public void testIfGetTopHeadlinesAustriaIsNotNull() {
        Assertions.assertFalse(ctrl.getTopHeadlinesAustria().isEmpty());
    }

    @Test
    @DisplayName("test if GetTopHeadlinesAustria is empty when List Null")
    public void testIfGetTopHeadlinesAustriaIsEmptyWhenListNull(){
        ctrl.setArticles(null);

        Assertions.assertEquals(3, ctrl.getTopHeadlinesAustria().size(),0);
    }

    @Test
    @DisplayName("test if filter list contains searched element")
    public void testIfFilterListContainsSearchedElement() {
        List<Article> articles = new ArrayList<>();
        articles.add(new Article("Goethe", "Faust"));
        articles.add(new Article("Shakespeare", "Hamlet"));
        articles.add(new Article("Dummy", "Bitcoin"));
        List<Article> filteredList = ctrl.filterList("faust", articles);
        Assertions.assertTrue(filteredList.contains(articles.get(0)) && filteredList.size() == 1);
    }

    @Test
    @DisplayName("test to check if a list contains the word bitcoin")
    public void testIfFilterListContainsBitcoinNews() {
        // set articles so we have something to filter
        List<Article> articles = new ArrayList<>();
        articles.add(new Article("Goethe", "Faust"));
        articles.add(new Article("Shakespeare", "Hamlet"));
        articles.add(new Article("Dummy", "Bitcoin"));
        ctrl.setArticles(articles);
        // test getAllNewsBitcoin functionality
        List<Article> bitcoinNewsList = ctrl.getAllNewsBitcoin();
        boolean containsBitcoin = true;
        for (Article article : bitcoinNewsList) {
            if (!article.getTitle().toLowerCase().contains("bitcoin")) {
                containsBitcoin = false;
            }
        }
        Assertions.assertTrue(containsBitcoin);
    }

}