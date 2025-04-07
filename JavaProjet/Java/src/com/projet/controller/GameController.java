package com.projet.controller;


import com.projet.model.Adversaire;
import com.projet.model.Joueur;
import com.projet.model.Niveau;
import com.projet.model.Projectile;

import java.util.List;

public class GameController {
    private int score;
    private Niveau niveau;
    private List<Projectile> projectiles;
    private List<Adversaire> adversaires;
    private Joueur joueur;

    public GameController() {
    }

    public GameController(Joueur joueur) {
        this.joueur = joueur;
    }

    public void levelSuivant() {
        niveau.AugmenterDifficulter();
    }

    public void VerfierCollisions() {
        for (Projectile p : projectiles) {
            for (Adversaire a : adversaires) {
                if (p.getX() == a.getX() && p.getY() == a.getY()) {
                    a.SubirDammage();
                    projectiles.remove(p);
                    score += 10;
                }
            }
        }
    }

    public void StartGame() {
        niveau = new Niveau(1);
        joueur = new Joueur("Joueur1");
    }

    public void render() {
        // Rendu graphique (appelé par la boucle de jeu)
    }

    public void MiseAjour() {
        joueur.MiseAjour();
        adversaires.forEach(Adversaire::Deplacer);
    }
}
