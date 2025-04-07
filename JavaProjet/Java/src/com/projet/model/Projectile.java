package com.projet.model;

public class Projectile {
    private int X, Y;
    private final int vitesse = 10;

    public Projectile(int startX, int startY) {
        this.X = startX;
        this.Y = startY;
    }

    public void Deplacer() {
        Y -= vitesse; // Se déplace vers le haut
    }

    // Getters
    public int getX() { return X; }
    public int getY() { return Y; }
}