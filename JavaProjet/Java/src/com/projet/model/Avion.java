package com.projet.model;

import com.projet.utils.ImageChargement;

import java.util.List;

public class Avion {
    private String nom;
    private double vitesse;  // Pourcentage (ex: 1.0 = 100%)
    private double attack;   // Pourcentage
    private double dureeDeVie;
    private ImageChargement sprite;

    public String getNom() {
        return nom;
    }

    // Constructeur
    public Avion(String nom, double vitesse, double attack) {
        this.nom = nom;
        this.vitesse = vitesse;
        this.attack = attack;
        this.dureeDeVie = 100.0;
        this.sprite = new ImageChargement("/images/avions/" + nom + ".png");
    }

    // Getters/Setters
    public double getVitesse() {
        return vitesse * 2.0; // Exemple: bonus de vitesse
    }

    public void ameliorerStatistiques(double boost) {
        this.vitesse += boost;
        this.attack += boost;
    }

    // Lier au Joueur
    public static List<Avion> getAvionsDisponibles() {
        return List.of(
                new Avion("chasseur", 1.2, 1.5),
                new Avion("bombardier", 0.8, 2.0),
                new Avion("reconnaissance", 1.5, 0.5)
        );
    }
}