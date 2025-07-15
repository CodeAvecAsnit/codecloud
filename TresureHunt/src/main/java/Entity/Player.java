package Entity;

import com.Main.GamePanel;
import com.Main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends Entity {
    GamePanel gamePanel;
    KeyHandler keyHandler;

    public final int screenX;
    public final int screenY;

    public int hasKey = 0;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        screenX = (gamePanel.screenWidth - gamePanel.tileSize) / 2;
        screenY = (gamePanel.screenHeight - gamePanel.tileSize) / 2;

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;

        setDefaults();
        getPlayerImage();
        direction = "down";
    }

    public void setDefaults() {
        worldX = gamePanel.tileSize * 23;
        worldY = gamePanel.tileSize * 21;
        speed = 4;
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void update() {
        if (keyHandler.rightPressed || keyHandler.leftPressed || keyHandler.upPressed || keyHandler.downPressed) {
            if (keyHandler.upPressed) {
                direction = "up";
            } else if (keyHandler.downPressed) {
                direction = "down";
            } else if (keyHandler.leftPressed) {
                direction = "left";
            } else if (keyHandler.rightPressed) {
                direction = "right";
            }

            collisionON = false;
            gamePanel.collisionChecker.checkTiles(this);
            int objectIndex = gamePanel.collisionChecker.checkObjects(this, true);
            pickUpObject(objectIndex);

            if (!collisionON) {
                switch (direction) {
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                }
            }

            sprintCounter++;
            if (sprintCounter > 8) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                sprintCounter = 0;
            }
        }
    }

    public void pickUpObject(int index) {
        if (index != 999) {
            String objectName = gamePanel.obj[index].name;
            switch (objectName) {
                case "Key":
                    hasKey++;
                    gamePanel.obj[index] = null;
                    gamePanel.playSE(1);
                    gamePanel.ui.showMessage("You got a key!!!");
                    break;
                case "Door":
                    if (hasKey > 0) {
                        gamePanel.obj[index] = null;
                        hasKey--;
                        gamePanel.playSE(3);
                        gamePanel.ui.showMessage("You opened a door!!!");
                    } else {
                        gamePanel.ui.showMessage("You need a key!!!");
                    }
                    break;
                case "Boots":
                    speed += 2;
                    gamePanel.obj[index] = null;
                    gamePanel.playSE(2);
                    gamePanel.ui.showMessage("Speed up!!!");
                    break;
                case "Chest":
                    gamePanel.stopMusic();
                    gamePanel.playMusic(4);
                    gamePanel.ui.gameFinished = true;
                    break;
            }
        }
    }

    public void draw(Graphics2D graphics2D) {
        BufferedImage image = null;

        switch (direction) {
            case "up":
                if (spriteNum == 1)
                    image = up1;
                if (spriteNum == 2)
                    image = up2;
                break;
            case "down":
                if (spriteNum == 1)
                    image = down1;
                if (spriteNum == 2)
                    image = down2;
                break;
            case "left":
                if (spriteNum == 1)
                    image = left1;
                if (spriteNum == 2)
                    image = left2;
                break;
            case "right":
                if (spriteNum == 1)
                    image = right1;
                if (spriteNum == 2)
                    image = right2;
                break;
        }

        graphics2D.drawImage(image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
    }
}
