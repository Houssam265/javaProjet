package com.projet.Interface;

public interface Joueur extends Entite, Score, Tir {
    void seDeplacer(int directionX, int directionY);  // Déplace le joueur
    void tirer();  // Le joueur effectue un tir
}
