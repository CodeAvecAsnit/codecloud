package Entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    public int worldX, worldY;
    public int speed;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;

    public int sprintCounter = 0, spriteNum = 1;

    public Rectangle solidArea;

    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionON = false;
}
