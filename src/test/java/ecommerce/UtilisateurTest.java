package ecommerce;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.perfectstay.ecommerce.model.Utilisateur;

public class UtilisateurTest {
    private Utilisateur utilisateur;

    @Before
    public void setUp() {
        utilisateur = new Utilisateur("1", "Test User", 100.0);
    }

    @Test
    public void testGetId() {
        assertEquals("1", utilisateur.getId());
    }

    @Test
    public void testGetNom() {
        assertEquals("Test User", utilisateur.getNom());
    }

    @Test
    public void testGetBalance() {
        assertEquals(100.0, utilisateur.getBalance(), 0.01);
    }

    @Test
    public void testSetBalance() {
        utilisateur.setBalance(150.0);
        assertEquals(150.0, utilisateur.getBalance(), 0.01);
    }
}
