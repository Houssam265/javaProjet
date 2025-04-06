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

    public PageJeu(GameController gameController) {
        setPreferredSize(new Dimension(800, 600));
        hud = new Hud();
        add(hud, BorderLayout.NORTH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Fond
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Joueur (carré bleu pour l'exemple)
        g.setColor(Color.BLUE);
        g.fillRect(joueur.getX(), joueur.getY(), 30, 30);

        // Adversaires (carrés rouges)
        g.setColor(Color.RED);
        for (Adversaire a : adversaires) {
            g.fillRect(a.getX(), a.getY(), 30, 30);
        }

        // Projectiles (lignes jaunes)
        g.setColor(Color.YELLOW);
        for (Projectile p : projectiles) {
            g.fillRect(p.getX(), p.getY(), 5, 15);
        }
    }

    public void miseAjour(Joueur joueur, List<Adversaire> adversaires, List<Projectile> projectiles) {
        this.joueur = joueur != null ? joueur : this.joueur;
        this.adversaires = adversaires != null ? adversaires : this.adversaires;
        this.projectiles = projectiles != null ? projectiles : this.projectiles;

        repaint();

        if(hud != null && joueur != null) {
            hud.mettreAJour(joueur.getScore(), joueur.getVies());
        }
    }
}
