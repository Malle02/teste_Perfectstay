package com.perfectstay.ecommerce.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

/**
 * Classe principale pour simuler le processus d'achat dans un système de e-commerce.
 */
public class Application {
    private static Scanner scanner = new Scanner(System.in);
    private static Utilisateur utilisateur = new Utilisateur("1", "Lionel Messi", 1500.0);
    private static Panier panier = new Panier(utilisateur);
    private static List<Article> articlesDisponibles = new ArrayList<>();

    public static void main(String[] args) {
        initialiserArticlesDisponibles();

        afficherMenuPrincipal();
    }

    private static void initialiserArticlesDisponibles() {
        articlesDisponibles.add(new Article("A001", "Iphone 11", 600.0, 10));
        articlesDisponibles.add(new Article("A002", "MacBook", 1000.0, 5));
    }

    private static void afficherMenuPrincipal() {
        boolean quitter = false;
        while (!quitter) {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1. Afficher le contenu du panier");
            System.out.println("2. Ajouter un article au panier");
            System.out.println("3. Payer le panier");
            System.out.println("4. Quitter");

            System.out.print("Choisissez une option : ");
            int choix = 0;
            try {
                choix = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Erreur : Veuillez saisir un nombre correspondant à l'option.");
                continue;
            }

            switch (choix) {
                case 1:
                    afficherContenuPanier();
                    break;
                case 2:
                    ajouterArticleAuPanier();
                    break;
                case 3:
                    payerPanier();
                    break;
                case 4:
                    quitter = true;
                    break;
                default:
                    System.out.println("Erreur : Option non valide. Veuillez choisir une option de 1 à 4.");
                    break;
            }
        }
        scanner.close();
    }

    private static void afficherContenuPanier() {
        System.out.println("\n=== Contenu du panier de " + utilisateur.getNom() + " ===");
        for (Article article : panier.getArticles()) {
            System.out.println("- " + article.getNom() + " : " + article.getPrix() + " EUR");
        }
    }

    private static void ajouterArticleAuPanier() {
        System.out.println("\n=== Ajout d'un article au panier ===");

        // Affichage des articles disponibles
        System.out.println("=== Liste des articles disponibles ===");
        for (Article article : articlesDisponibles) {
            System.out.println("- " + article.getNom() + " : " + article.getPrix() + " EUR");
        }

        // Lecture du nom de l'article
        System.out.print("Entrez le nom de l'article : ");
        String nomArticle = scanner.nextLine();

        // Recherche de l'article correspondant dans les articles disponibles
        Article articleTrouve = null;
        for (Article article : articlesDisponibles) {
            if (article.getNom().equalsIgnoreCase(nomArticle)) {
                articleTrouve = article;
                break;
            }
        }

        if (articleTrouve == null) {
            System.out.println("Erreur : Article non trouvé dans la liste des articles disponibles.");
            return;
        }

        // Vérification si l'article est déjà dans le panier
        Article articleDansPanier = null;
        for (Article article : panier.getArticles()) {
            if (article.getNom().equalsIgnoreCase(nomArticle)) {
                articleDansPanier = article;
                break;
            }
        }

        if (articleDansPanier != null) {
            System.out.println("Article déjà présent dans le panier. Veuillez utiliser l'option 'Afficher le contenu du panier' pour voir la quantité actuelle.");
            return;
        }

        
        // partie non finalisé ------------------------------------------------------------
        
        
        // Lecture de la quantité à ajouter au panier
        int quantiteArticle = 0;
        boolean quantiteValide = false;
        while (!quantiteValide) {
            try {
                System.out.print("Entrez la quantité à ajouter au panier  (processus pas completement finalisé) : ");
                quantiteArticle = Integer.parseInt(scanner.nextLine());
                if (quantiteArticle <= 0) {
                    System.out.println("Erreur : La quantité doit être supérieure à zéro.");
                } else if (quantiteArticle > articleTrouve.getQuantite()) {
                    System.out.println("Erreur : Quantité disponible insuffisante pour cet article.");
                } else {
                    quantiteValide = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Erreur : La quantité doit être un nombre entier. Veuillez réessayer.");
            }
        }

        // Génération d'un ID unique pour l'article
        String articleId = UUID.randomUUID().toString();

        Article nouvelArticle = new Article(articleId, articleTrouve.getNom(), articleTrouve.getPrix(), quantiteArticle);
        panier.ajouterArticle(nouvelArticle);

        System.out.println("Article ajouté au panier : " + nouvelArticle.getNom());
    }


    private static void payerPanier() {
        System.out.println("\n=== Paiement du panier ===");

        try {
            panier.payer();
            System.out.println("Paiement effectué avec succès.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
            System.out.println("Fonds insuffisants pour payer le panier.");
            System.out.println("Veuillez recharger votre compte ou retirer des articles du panier.");
        }

        System.out.println("Nouvelle balance du porte-monnaie de " + utilisateur.getNom() + ": " + utilisateur.getBalance() + " EUR");
    }
}