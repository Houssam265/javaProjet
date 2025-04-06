package com.projet;  // Package racine, pas 'com.projet.controller.view'

import com.projet.controller.GameController;
import com.projet.view.PageJeu;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Initialisation du contrôleur principal
            GameController gameController = new GameController();

            // Configuration de la fenêtre
            JFrame frame = new JFrame("Jeu d'Avion");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            // Attache la vue principale
            PageJeu pageJeu = new PageJeu(gameController);
            frame.add(pageJeu);

            frame.setVisible(true);
        });
    }
}