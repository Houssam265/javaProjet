package com.projet.model;

import com.projet.utils.ImageChargement;
public class Joueur {
    private ProfilJoueur profil;
    private Avion avion;
    private String nom;
    private int score;
    private int vies = 3;
    private int X, Y;
    private ImageChargement sprite= new ImageChargement("/images/player_avion.png");

    public Joueur(ProfilJoueur profil) {
        this.profil = profil;
        this.avion = profil.getAvionChoisi();
    }
    public Joueur(String nom) {
        this.nom = nom;
        this.sprite = new    ImageChargement("/images/player_avion.png");
    }

    public Joueur(int i, int i1) {
        X = i;
        Y = i1;
    }

    public void tirer() {
        Projectile p = new Projectile(X, Y);
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public int getScore() {
        return score;
    }

    public int getVies() {
        return vies;
    }

    public void deplacerGauche() { X -= 5; }
    public void deplacerDroit() { X += 5; }
    public void deplacerHaut() { Y -= 5; }
    public void deplacerBas() { Y += 5; }

    public void subirDegats() {
        vies--;
        if (vies <= 0) {
            // Game Over
        }
    }

    public void MiseAjour() {
        // Mise à jour de la position/logique
    }
}