package com.projet.model;

public class Adversaire {
    private int X, Y;
    private int dégâts = 1;
    private int santé;

    public void Deplacer() {
        Y += 2; // Descend vers le joueur
    }

    public void SubirDammage() {
        santé -= dégâts;
        if (santé <= 0) {
            detruire();
        }
    }

    private void detruire() {
        // Suppression de l'adversaire
    }
    public int getX() { return X; }
    public int getY() { return Y; }
}