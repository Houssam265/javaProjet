package com.projet.controller;

import com.projet.model.Avion;
import com.projet.model.Joueur;
import com.projet.model.ProfilJoueur;
import com.projet.utils.BaseDeDonnees;
import com.projet.utils.Son;

public class MainMenuController {
    private BaseDeDonnees bdd;
    private Son musique;

    public MainMenuController() {
        bdd = new BaseDeDonnees();
        musique = new Son();
        musique.playArrierePlanMusic("/sounds/background.mp3"); // Déplacé dans le constructeur
    }

    public void selectLevel(int niveau) {
        bdd.ChargerScore();
        // Chargement du niveau sélectionné
    }

    public void startGame() {
        Avion avion = Avion.getAvionsDisponibles().get(0); // Sélection par défaut
        ProfilJoueur profil = new ProfilJoueur();
        profil.creerProfilJoueur("Joueur1", avion);
        new GameController(new Joueur(profil));
    }

    public void MontrerMenu() {
        // Affiche l'UI du menu
    }

    public void stopMusic() {
        musique.stopMusic(); // Méthode utile pour arrêter la musique
    }
}