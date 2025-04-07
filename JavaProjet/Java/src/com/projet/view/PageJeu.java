package com.projet.view;

import com.projet.controller.GameController;
import com.projet.model.Adversaire;
import com.projet.model.Joueur;
import com.projet.model.Projectile;

import java.awt.*;
import javax.swing.*;
import java.util.List;

public class PageJeu extends JPanel {
    private Joueur joueur;
    private List<Adversaire> adversaires;
    private List<Projectile> projectiles;
    private Hud hud;

    // Constructor with GameController
    public PageJeu(GameController gameController) {
        setPreferredSize(new Dimension(800, 600));
        joueur = new Joueur(100, 200); // Ensure joueur is initialized
        hud = new Hud();
        add(hud, BorderLayout.NORTH);
    }

    // Default no-arg constructor
    public PageJeu() {
        setPreferredSize(new Dimension(800, 600));
        joueur = new Joueur(100, 200); // Ensure joueur is initialized
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Safeguard null check for joueur
        if (joueur != null) {
            // Joueur (blue square)
            g.setColor(Color.BLUE);
            g.fillRect(joueur.getX(), joueur.getY(), 30, 30);
        }

        // Safeguard for potential null adversaires
        if (adversaires != null) {
            // Adversaires (red squares)
            g.setColor(Color.RED);
            for (Adversaire a : adversaires) {
                g.fillRect(a.getX(), a.getY(), 30, 30);
            }
        }

        // Safeguard for potential null projectiles
        if (projectiles != null) {
            // Projectiles (yellow lines)
            g.setColor(Color.YELLOW);
            for (Projectile p : projectiles) {
                g.fillRect(p.getX(), p.getY(), 5, 15);
            }
        }
    }

    public void miseAjour(Joueur joueur, List<Adversaire> adversaires, List<Projectile> projectiles) {
        this.joueur = joueur != null ? joueur : this.joueur; // Keep the current joueur if null is passed
        this.adversaires = adversaires != null ? adversaires : this.adversaires; // Update or keep existing adversaires
        this.projectiles = projectiles != null ? projectiles : this.projectiles; // Update or keep existing projectiles

        repaint(); // Repaint the panel to reflect updates

        // Update HUD if not null and joueur is present
        if (hud != null && joueur != null) {
            hud.mettreAJour(joueur.getScore(), joueur.getVies());
        }
    }
}