package com.projet.Interface;

public interface Entite {
    void deplacer();  // Déplace l'entité (joueur, ennemi, projectile, etc.)
    void afficher(Graphics g);  // Affiche l'entité à l'écran
    Rectangle getBorne();  // Retourne la zone de collision (hitbox)
    void setPosition(int x, int y);  // Met à jour la position



}
