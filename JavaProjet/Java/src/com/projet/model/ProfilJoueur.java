package com.projet.model;

import com.projet.utils.BaseDeDonnees;

public class ProfilJoueur {
    private String pseudo;
    private Avion avionChoisi;
    private int highScore;
    private BaseDeDonnees bdd;

    public ProfilJoueur() {
        this.bdd = new BaseDeDonnees();
    }

    public Avion getAvionChoisi() {
        return avionChoisi;
    }

    public void creerProfilJoueur(String pseudo, Avion avion) {
        this.pseudo = pseudo;
        this.avionChoisi = avion;
        this.highScore = 0;
        bdd.saveScore(0);  // Initialisation du score
    }

    public void mettreAJourScore(int nouveauScore) {
        if (nouveauScore > highScore) {
            highScore = nouveauScore;
            bdd.saveScore(nouveauScore);
        }
    }

    // Méthode pour le menu de sélection
    public void choisirAvion(Avion avion) {
        this.avionChoisi = avion;
        System.out.println("Avion sélectionné : " + avion.getNom());
    }
}