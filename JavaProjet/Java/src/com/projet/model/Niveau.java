package com.projet.model;

import java.util.ArrayList;
import java.util.List;

public class Niveau {
    private int numéroNiveau;
    private int vitesseAdversaires;
    private int nombreAdversaires;

    public Niveau(int num) {
        this.numéroNiveau = num;
        this.vitesseAdversaires = num * 2;
    }

    public void AugmenterDifficulter() {
        numéroNiveau++;
        vitesseAdversaires += 1;
    }

    public void spawnAdversaires() {
        List<Adversaire> adversaires = new ArrayList<>();
        for (int i = 0; i < nombreAdversaires; i++) {
            adversaires.add(new Adversaire());
        }
    }
}