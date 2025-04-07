package com.projet.Interface;

public interface Ennemi extends Entite, Mouvement {
    void attaquer(Joueur joueur);  // Logique d'attaque de l'ennemi sur le joueur
}
