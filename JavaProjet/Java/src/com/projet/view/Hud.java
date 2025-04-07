package com.projet.view;

import javax.swing.*;
import java.awt.*;

public class Hud extends JPanel {
    private JLabel scoreLabel;
    private JLabel viesLabel;

    public Hud() {
        setLayout(new FlowLayout());
        scoreLabel = new JLabel("Score: 0");
        viesLabel = new JLabel("Vies: 3");

        scoreLabel.setForeground(Color.WHITE);
        viesLabel.setForeground(Color.WHITE);
        setBackground(Color.DARK_GRAY);

        add(scoreLabel);
        add(viesLabel);
    }

    public void mettreAJour(int score, int vies) {
        scoreLabel.setText("Score: " + score);
        viesLabel.setText("Vies: " + vies);
    }
}