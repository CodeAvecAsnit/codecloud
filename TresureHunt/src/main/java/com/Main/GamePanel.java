package com.Main;

import Entity.Player;
import Tile.TileManager;
import object.SuperObject;
import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    // ------------------------------------------------------- SCREEN SETTINGS ----------------------------------------------------//
    final int originalTileSize = 16;
    final int scale = 3;
    public final int tileSize = originalTileSize * scale;

    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;

    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    Thread gameThread;

    KeyHandler keyHandler = new KeyHandler();

    int FPS = 60;

    public Player player = new Player(this, keyHandler);
    public TileManager manager = new TileManager(this);
    public CollisionChecker collisionChecker = new CollisionChecker(this);
    public AssetSetter assetSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    Sound sound = new Sound();
    Sound SE = new Sound();
    public SuperObject[] obj = new SuperObject[10];

    // ------------------------------------------------------- World Settings ----------------------------------------------------//
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;

    GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void setUpGame() {
        assetSetter.setObject();
        playMusic(0);
    }

    @Override
    public void run() {
        double drawInterval = 1000000000.0 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;

            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    public void update() {
        player.update();
    }

    public void paint(Graphics graphics) {
        super.paint(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;

        manager.draw(graphics2D);

        for (int i = 0; i < obj.length; i++) {
            if (obj[i] != null) {
                obj[i].draw(graphics2D, this);
            }
        }

        player.draw(graphics2D);

        ui.draw(graphics2D);

        graphics2D.dispose();
    }

    public void playMusic(int i) {
        sound.setFile(i);
        sound.play();
        sound.loop();
    }

    public void stopMusic() {
        sound.stop();
    }

    public void playSE(int i) {
        SE.setFile(i);
        SE.play();
    }
}
