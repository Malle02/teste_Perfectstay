package ecommerce;
import org.junit.Before;
import org.junit.Test;

import com.perfectstay.ecommerce.model.Utilisateur;
import com.perfectstay.ecommerce.model.Panier;
import com.perfectstay.ecommerce.model.Article;

import static org.junit.Assert.*;

public class PanierTest {
    private Utilisateur utilisateur;
    private Panier panier;

    @Before
    public void setUp() {
        utilisateur = new Utilisateur("1", "Test User", 100.0);
        panier = new Panier(utilisateur);
    }

    @Test
    public void testAjouterArticle() {
        Article article = new Article("1", "Test Article", 10.0, 5);
        panier.ajouterArticle(article);
        assertEquals(1, panier.getArticles().size());
    }

    @Test
    public void testPayerAvecSuffisammentDeFonds() {
        Article article = new Article("1", "Test Article", 10.0, 5);
        panier.ajouterArticle(article);
        panier.payer();
        assertEquals(90.0, utilisateur.getBalance(), 0.01);
        assertEquals(0, panier.getArticles().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPayerSansSuffisammentDeFonds() {
        Article article = new Article("1", "Test Article", 150.0, 1);
        panier.ajouterArticle(article);
        panier.payer(); // Cela devrait lancer une exception
    }
}
