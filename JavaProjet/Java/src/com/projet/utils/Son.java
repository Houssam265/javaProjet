package com.projet.utils;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class Son {
    private Clip clip;

    public void playArrierePlanMusic(String chemin) {
        try {
            URL url = getClass().getResource(chemin);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void PlaySon(String chemin, float volume) {
        try (AudioInputStream audioIn = AudioSystem.getAudioInputStream(getClass().getResource(chemin))) {
            Clip soundClip = AudioSystem.getClip();
            soundClip.open(audioIn);

            // Contrôle du volume
            FloatControl gainControl = (FloatControl) soundClip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(volume); // Réduction en décibels (ex: -10.0f)

            soundClip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopMusic() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }
}