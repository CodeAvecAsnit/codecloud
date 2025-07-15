package com.Main;

import object.Obj_Key;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

public class UI {
    GamePanel gamePanel;
    Font font, congrats;
    BufferedImage image;
    Obj_Key key;
    public boolean messageON = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    double playTime;
    DecimalFormat decimalFormat;

    public UI(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        decimalFormat = new DecimalFormat("#0.00");

        font = new Font("Space Mono", Font.BOLD, 25);
        congrats = new Font("Space Mono", Font.BOLD, 50);
        key = new Obj_Key();
        image = key.image;
    }

    public void showMessage(String text) {
        message = text;
        messageON = true;
    }

    public void draw(Graphics2D graphics2D) {
        if (gameFinished) {
            graphics2D.setFont(font);
            graphics2D.setColor(Color.WHITE);
            String text = "You Found the Treasure!!!";
            int textLength, x, y;

            textLength = (int) graphics2D.getFontMetrics().getStringBounds(text, graphics2D).getWidth();

            x = (gamePanel.screenWidth - textLength) / 2;
            y = gamePanel.screenHeight / 2 - gamePanel.tileSize * 3;

            graphics2D.drawString(text, x, y);

            text = "Your time is : " + decimalFormat.format(playTime);

            textLength = (int) graphics2D.getFontMetrics().getStringBounds(text, graphics2D).getWidth();

            x = (gamePanel.screenWidth - textLength) / 2;
            y = gamePanel.screenHeight / 2 + gamePanel.tileSize * 5;

            graphics2D.drawString(text, x, y);

            graphics2D.setFont(congrats);
            graphics2D.setColor(Color.YELLOW);

            text = "Congratulations!!!";

            textLength = (int) graphics2D.getFontMetrics().getStringBounds(text, graphics2D).getWidth();

            x = (gamePanel.screenWidth - textLength) / 2;
            y = gamePanel.screenHeight / 2 + gamePanel.tileSize * 3;

            graphics2D.drawString(text, x, y);

            gamePanel.gameThread = null;
        } else {
            graphics2D.setFont(font);
            graphics2D.setColor(Color.WHITE);
            graphics2D.drawImage(image, gamePanel.tileSize / 2, gamePanel.tileSize / 2, gamePanel.tileSize / 2, gamePanel.tileSize / 2, null);
            graphics2D.drawString(" " + gamePanel.player.hasKey, 48, 48);

            playTime += (double) 1 / 60;
            graphics2D.drawString("Time " + decimalFormat.format(playTime), gamePanel.tileSize * 12, 48);

            if (messageON) {
                graphics2D.drawString(message, gamePanel.tileSize * 5, gamePanel.tileSize * 3);

                messageCounter++;

                if (messageCounter > 60) {
                    messageCounter = 0;
                    messageON = false;
                }
            }
        }
    }
}
