package com.projet.Interface;

public interface InterfaceGraphique {
    void dessiner(Graphics g);  // Dessine tous les éléments du jeu à l'écran
    void mettreAJour();  // Mise à jour graphique (ex : animations, mouvements)
    void afficherScore(int score);
}
