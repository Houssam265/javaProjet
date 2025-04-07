package com.projet.utils;

import javafx.scene.image.Image;

import java.io.IOException;
import java.io.InputStream;

public class ImageChargement {
    private Image image;

    public ImageChargement(String chemin) {
        try (InputStream is = getClass().getResourceAsStream(chemin)) {
            if (is == null) {
                throw new RuntimeException("Image non trouvée: " + chemin);
            }
            this.image = new Image(is);
        } catch (IOException e) {
            throw new RuntimeException("Erreur de chargement: " + chemin, e);
        }
    }

    public Image getImage() {
        return image;
    }

    public static Image ObtenirImage(String chemin) {

        return new ImageChargement(chemin).getImage();
    }
}