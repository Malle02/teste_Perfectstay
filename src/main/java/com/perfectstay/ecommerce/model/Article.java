
package com.perfectstay.ecommerce.model;

/**
 * Classe des article
 */
public class Article {
    private String id;          // Identifiant unique de l'article
    private String nom;         // Nom de l'article
    private double prix;        // Prix unitaire de l'article
    private int quantite;       // Quantité disponible de l'article

    /**
     * Constructeur pour initialiser un article avec un identifiant, un nom, un prix et une quantité.
     * @param id Identifiant unique de l'article
     * @param nom Nom de l'article
     * @param prix Prix unitaire de l'article
     * @param quantite Quantité disponible de l'article
     */
    public Article(String id, String nom, double prix, int quantite) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
    }

    /**
     * Méthode pour récupérer l'identifiant de l'article
     * @return L'identifiant de l'article
     */
    public String getId() {
        return id;
    }

    /**
     * Méthode pour récupérer le nom de l'article.
     * @return Le nom de l'article
     */
    public String getNom() {
        return nom;
    }

    /**
     * Méthode pour récupérer le prix unitaire de l'article
     * @return Le prix unitaire de l'article
     */
    public double getPrix() {
        return prix;
    }

    /**
     * Méthode pour récupérer la quantité disponible de l'article
     * @return La quantité disponible de l'article
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * Méthode pour définir la quantité disponible de l'article
     * @param quantite La nouvelle quantité disponible de l'article
     */
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}