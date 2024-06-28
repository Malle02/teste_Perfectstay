package ecommerce;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.*;
import com.perfectstay.ecommerce.model.Utilisateur;

import com.perfectstay.ecommerce.model.Transaction;
import com.perfectstay.ecommerce.model.Article;

public class TransactionTest {
    private Utilisateur utilisateur;
    private List<Article> articles;
    private Transaction transaction;

    @Before
    public void setUp() {
        utilisateur = new Utilisateur("1", "Test User", 100.0);
        articles = new ArrayList<>();
        articles.add(new Article("1", "Test Article", 10.0, 2));
        articles.add(new Article("2", "Test Article 2", 5.0, 3));
        double montantTotal = articles.stream().mapToDouble(Article::getPrix).sum();
        transaction = new Transaction("1", utilisateur, articles, montantTotal, new Date());
    }

    @Test
    public void testGetId() {
        assertEquals("1", transaction.getId());
    }

    @Test
    public void testGetUtilisateur() {
        assertEquals(utilisateur, transaction.getUtilisateur());
    }

    @Test
    public void testGetArticles() {
        assertEquals(articles, transaction.getArticles());
    }

    @Test
    public void testGetMontant() {
        assertEquals(20.0, transaction.getMontant(), 0.01);
    }

    @Test
    public void testGetDate() {
        assertNotNull(transaction.getDate());
    }
}
