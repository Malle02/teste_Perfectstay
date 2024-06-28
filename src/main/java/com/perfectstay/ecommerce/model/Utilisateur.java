
package com.perfectstay.ecommerce.model;

/**
 * Classe représentant un utilisateur du système de gestion de panier d'achat
 */
public class Utilisateur {
    private String id;          // Identifiant unique de l'utilisateur
    private String nom;         // Nom de l'utilisateur
    private double balance;     // Solde du porte-monnaie de l'utilisateur

    /**
     * Constructeur pour initialiser un utilisateur avec un identifiant, un nom et une balance
     * @param id Identifiant de l'utilisateur
     * @param nom Nom de l'utilisateur
     * @param balance Balance du porte-monnaie de l'utilisateur
     */
    public Utilisateur(String id, String nom, double balance) {
        this.id = id;
        this.nom = nom;
        this.balance = balance;
    }

    /**
     * Méthode pour récupérer l'identifiant de l'utilisateur
     * @return L'identifiant de l'utilisateur
     */
    public String getId() {
        return id;
    }

    /**
     * Méthode pour récupérer le nom de l'utilisateur.
     * @return Le nom de l'utilisateur
     */
    public String getNom() {
        return nom;
    }

    /**
     * Méthode pour récupérer la balance du porte-monnaie de l'utilisateur.
     * @return La balance du porte-monnaie de l'utilisateur
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Méthode pour définir la balance du porte-monnaie de l'utilisateur.
     * @param balance La nouvelle balance du porte-monnaie de l'utilisateur
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
