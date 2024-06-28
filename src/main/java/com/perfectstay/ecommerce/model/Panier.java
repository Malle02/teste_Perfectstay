
package com.perfectstay.ecommerce.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Date;

public class Panier {
    private Utilisateur utilisateur;
    private List<Article> articles;

    public Panier(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
        this.articles = new ArrayList<>();
    }

    /**
     * Méthode pour ajouter un article au panier
     * @param article L'article à ajouter
     */
    public void ajouterArticle(Article article) {
        articles.add(article);
    }

    /**
     * Méthode pour procéder au paiement du panier
     * le montant total du porte-monnaie de l'utilisateur et enregistre une transaction
     * @throws IllegalArgumentException Si le solde de l'utilisateur est insuffisant pour le paiement
     */
    public void payer() {
        double montantTotal = 0;
        for (Article article : articles) {
            montantTotal += article.getPrix();
        }

        if (utilisateur.getBalance() >= montantTotal) {
            utilisateur.setBalance(utilisateur.getBalance() - montantTotal);
            Transaction transaction = new Transaction(UUID.randomUUID().toString(), utilisateur, articles, montantTotal, new Date());
            articles.clear(); // Vide le panier après paiement
        } else {
            throw new IllegalArgumentException("Fonds insuffisants");
        }
    }


    /**
     * Méthode privée pour calculer le montant total du panier
     * @return Le montant total du panier
     */
    private double calculerMontantTotal() {
        double montantTotal = 0;
        for (Article article : articles) {
            montantTotal += article.getPrix();
        }
        return montantTotal;
    }

    /**
     * Méthode pour récupérer la liste des articles dans le panier
     * @return La liste des articles dans le panier
     */
    public List<Article> getArticles() {
        return articles;
    }
}