package com.Main;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Sound {
    Clip clip;
    File[] files = new File[10];

    public Sound() {
        try {
            files[0] = new File(getClass().getClassLoader().getResource("sound/BlueBoyAdventure.wav").toURI());
            files[1] = new File(getClass().getClassLoader().getResource("sound/coin.wav").toURI());
            files[2] = new File(getClass().getClassLoader().getResource("sound/powerup.wav").toURI());
            files[3] = new File(getClass().getClassLoader().getResource("sound/unlock.wav").toURI());
            files[4] = new File(getClass().getClassLoader().getResource("sound/fanfare.wav").toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setFile(int i) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(files[i]);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    public void play() {
        clip.start();
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        clip.stop();
    }
}
