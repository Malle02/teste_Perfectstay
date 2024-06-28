
package com.perfectstay.ecommerce.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Classe représentant une transaction d'achat réalisée par un utilisateur
 */
public class Transaction {
    private String id;              // Identifiant unique de la transaction
    private Utilisateur utilisateur;    // Utilisateur effectuant la transaction
    private List<Article> articles;     // Liste des articles achetés dans cette transaction
    private double montant;         // Montant total de la transaction
    private Date date;              // Date et heure de la transaction

    /**
     * Constructeur pour initialiser une transaction avec un identifiant, un utilisateur,
     * une liste d'articles, un montant et une date.
     * @param id Identifiant unique de la transaction
     * @param utilisateur Utilisateur effectuant la transaction
     * @param articles Liste des articles achetés dans cette transaction
     * @param montant Montant total de la transaction
     * @param date Date et heure de la transaction
     */
    public Transaction(String id, Utilisateur utilisateur, List<Article> articles, double montant, Date date) {
        this.id = id;
        this.utilisateur = utilisateur;
        this.articles = articles;
        this.montant = montant;
        this.date = date;
    }

    /**
     * Méthode pour récupérer l'identifiant de la transaction
     * @return L'identifiant de la transaction
     */
    public String getId() {
        return id;
    }

    /**
     * Méthode pour récupérer l'utilisateur effectuant la transaction
     * @return L'utilisateur effectuant la transaction
     */
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    /**
     * Méthode pour récupérer la liste des articles achetés dans cette transaction
     * @return La liste des articles achetés dans cette transaction
     */
    public List<Article> getArticles() {
        return articles;
    }

    /**
     * Méthode pour récupérer le montant total de la transaction
     * @return Le montant total de la transaction
     */
    public double getMontant() {
        return montant;
    }

    /**
     * Méthode pour récupérer la date et heure de la transaction
     * @return La date et heure de la transaction
     */
    public Date getDate() {
        return date;
    }

    /**
     * Méthode pour définir la date et heure de la transaction
     * @param date La nouvelle date et heure de la transaction
     */
    public void setDate(Date date) {
        this.date = date;
    }
}