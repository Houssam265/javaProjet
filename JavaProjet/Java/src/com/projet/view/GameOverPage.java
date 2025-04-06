package com.projet.view;

import javax.swing.*;
import java.awt.*;

public class GameOverPage extends JPanel {
    public GameOverPage(Runnable restartAction, Runnable menuAction) {
        setLayout(new GridBagLayout());
        setBackground(new Color(0, 0, 0, 200)); // Semi-transparent

        JPanel content = new JPanel(new GridLayout(3, 1, 10, 10));
        content.setBackground(Color.BLACK);

        JLabel gameOverLabel = new JLabel("GAME OVER", SwingConstants.CENTER);
        gameOverLabel.setForeground(Color.RED);
        gameOverLabel.setFont(new Font("Arial", Font.BOLD, 40));

        JButton restartBtn = new JButton("Rejouer");
        JButton menuBtn = new JButton("Menu Principal");

        restartBtn.addActionListener(e -> restartAction.run());
        menuBtn.addActionListener(e -> menuAction.run());

        content.add(gameOverLabel);
        content.add(restartBtn);
        content.add(menuBtn);
        add(content);
    }
}