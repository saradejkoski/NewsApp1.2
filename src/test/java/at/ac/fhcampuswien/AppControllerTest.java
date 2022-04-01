package at.ac.fhcampuswien;

import org.junit.jupiter.api.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class AppControllerTest {

    private AppController ctrl;
    private List<Article> mockList;
    private Article goetheArticle;
    private Article testArticle;
    private Article dummyArticle;


    @BeforeEach
    void setup() {
        ctrl = new AppController();
        mockList = new ArrayList<>();
        goetheArticle = (new Article("Goethe", "Faust"));
        mockList.add(goetheArticle);
        testArticle = new Article("Test", "TestTestTest");
        mockList.add(testArticle);
        dummyArticle = new Article("Dummy", "All About Bitcoins!");
        mockList.add(dummyArticle);
        ctrl.setArticles(mockList);
    }

    @Test
    @DisplayName("test ArticleCount with comparing mockList and getArticleCount")
    public void testArticleCount() {
        Assertions.assertEquals(mockList.size(), ctrl.getArticleCount());
    }

    @Test
    @DisplayName("test article count without overriding articles")
    public void testArticleCountWithoutOverridingArticles() {
        Assertions.assertEquals(3, ctrl.getArticleCount());  // Wir wissen das die Liste drei Elemente hat, deswegen muss es gleich sein wie der getArticleCount
    }

    // Auch ein Test für setArticles, weil wenn wir die articles zu 0 setten muss es articles geben
    @Test
    @DisplayName("test if ArticleCount is zero when articles are null")
    public void testIfArticleCountIsZeroWhenArticlesNull() {
        ctrl.setArticles(null);
        Assertions.assertEquals(0, ctrl.getArticleCount());
    }

    @Test
    @DisplayName("test if getTopHeadlinesAustria returns empty list when is not null")
    public void testIfGetTopHeadlinesAustriaIsNotNull() {
        Assertions.assertFalse(ctrl.getTopHeadlinesAustria().isEmpty()); // Wir testen ob der Inhlat der Klammer falsch ist und weil er falsch ist ist der Test richtig
    }

    @Test
    @DisplayName("test if GetTopHeadlinesAustria is empty when List Null")
    public void testIfGetTopHeadlinesAustriaIsEmptyWhenListNull() {
        ctrl.setArticles(null);
        Assertions.assertEquals(0, ctrl.getTopHeadlinesAustria().size(), 0);
    }

    @Test
    @DisplayName("test if filter list contains searched element")
    public void testIfFilterListContainsSearchedElement() {
        String query = "Test";
        List<Article> filteredList = ctrl.filterList(query, mockList); // erstellt neue Liste mit artikeln, deren Titel query beinhalten
        Boolean containsQuery = null;                                  // containsQuery wird initialisiert
        if (filteredList.isEmpty()) {                                  // Wenn die Liste leer ist, ist query in keinem artikel der Liste mockList enthlten
            containsQuery = false;                                     // somit ist containString false
        } else {
            for (Article article : filteredList) {
                /*
                Article = Typ von der Liste, die durchsucht wird
                article = element in der Liste, die durchsucht wird
                filteredList = Liste, die durchsucht wird
                 */
                if (article.getTitle().toLowerCase().contains(query.toLowerCase())) { // checken, ob query in dem Titel des article vorkommt
                    containsQuery = true; // wenn ja: containsQuery wird auf true gesetzt
                } else {
                    containsQuery = false; // sonst auf false
                }
            }
        }
        Assertions.assertTrue(containsQuery);
    }

    @Test
    @DisplayName("test if filter list does not contains searched element")
    public void testIfFilterListDoesNotContainsSearchedElement() {
        String query = "NonExistingWord";
        List<Article> filteredList = ctrl.filterList(query, mockList); // Liste ist Leer wenn der Titel nicht dabei ist
        Assertions.assertTrue(filteredList.isEmpty());                 // Test funktioniert, weil das query nirgends vorkommt
    }

    @Test
    @DisplayName("test to check if a list contains the word bitcoin")
    public void testIfFilterListContainsBitcoinNews() {
        String query = "bitcoin";
        ctrl.setArticles(mockList);                                 //articles werden mit mockList überschrieben

        List<Article> bitcoinNewsList = ctrl.getAllNewsBitcoin();  // bitcoinNewsList ist eine Erweiterung der filterList aus getAllNewsBitcoin
        boolean containsBitcoin = true;                            // wenn query im Titel enthalten ist wird containsBitcoin auf true gesetzt
        for (Article article : bitcoinNewsList) {                  // in bitcoinsNewsList wird gesucht
            if (!article.getTitle().toLowerCase().contains(query.toLowerCase())) {
                containsBitcoin = false;                           // wenn das query nicht in dem Titel enthalten ist, wird containsBitcoin auf false gesetzt
            }
        }
        Assertions.assertTrue(containsBitcoin);
    }
}