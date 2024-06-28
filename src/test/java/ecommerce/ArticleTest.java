package ecommerce;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.perfectstay.ecommerce.model.Article;

public class ArticleTest {
    private Article article;

    @Before
    public void setUp() {
        article = new Article("1", "Test Article", 10.0, 5);
    }

    @Test
    public void testGetId() {
        assertEquals("1", article.getId());
    }

    @Test
    public void testGetNom() {
        assertEquals("Test Article", article.getNom());
    }

    @Test
    public void testGetPrix() {
        assertEquals(10.0, article.getPrix(), 0.01);
    }

    @Test
    public void testGetQuantite() {
        assertEquals(5, article.getQuantite());
    }

    @Test
    public void testSetQuantite() {
        article.setQuantite(3);
        assertEquals(3, article.getQuantite());
    }
}
