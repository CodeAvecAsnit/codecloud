package com.Main;

import Entity.Entity;

public class CollisionChecker {
    GamePanel gamePanel;

    public CollisionChecker(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void checkTiles(Entity entity) {
        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTotWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX / gamePanel.tileSize;
        int entityRightCol = entityRightWorldX / gamePanel.tileSize;
        int entityTopRow = entityTotWorldY / gamePanel.tileSize;
        int entityBottomRow = entityBottomWorldY / gamePanel.tileSize;

        int tileNum1, tileNum2;

        switch (entity.direction) {
            case "up":
                entityTopRow = (entityTotWorldY - entity.speed) / gamePanel.tileSize;
                tileNum1 = gamePanel.manager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gamePanel.manager.mapTileNum[entityRightCol][entityTopRow];
                if (gamePanel.manager.tiles[tileNum1].collision || gamePanel.manager.tiles[tileNum2].collision)
                    entity.collisionON = true;
                break;
            case "down":
                entityBottomRow = (entityTotWorldY + entity.speed) / gamePanel.tileSize;
                tileNum1 = gamePanel.manager.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gamePanel.manager.mapTileNum[entityRightCol][entityBottomRow];
                if (gamePanel.manager.tiles[tileNum1].collision || gamePanel.manager.tiles[tileNum2].collision)
                    entity.collisionON = true;
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed) / gamePanel.tileSize;
                tileNum1 = gamePanel.manager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gamePanel.manager.mapTileNum[entityLeftCol][entityBottomRow];
                if (gamePanel.manager.tiles[tileNum1].collision || gamePanel.manager.tiles[tileNum2].collision)
                    entity.collisionON = true;
                break;
            case "right":
                entityRightCol = (entityRightWorldX + entity.speed) / gamePanel.tileSize;
                tileNum1 = gamePanel.manager.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gamePanel.manager.mapTileNum[entityRightCol][entityBottomRow];
                if (gamePanel.manager.tiles[tileNum1].collision || gamePanel.manager.tiles[tileNum2].collision)
                    entity.collisionON = true;
                break;
        }
    }

    public int checkObjects(Entity entity, boolean player) {
        int index = 999;

        for (int i = 0; i < gamePanel.obj.length; i++) {
            if (gamePanel.obj[i] != null) {
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;

                gamePanel.obj[i].solidArea.x = gamePanel.obj[i].worldX + gamePanel.obj[i].solidArea.x;
                gamePanel.obj[i].solidArea.y = gamePanel.obj[i].worldY + gamePanel.obj[i].solidArea.y;

                switch (entity.direction) {
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if (entity.solidArea.intersects(gamePanel.obj[i].solidArea)) {
                            if (gamePanel.obj[i].collisions) {
                                entity.collisionON = true;
                            }
                            if (player) {
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        if (entity.solidArea.intersects(gamePanel.obj[i].solidArea)) {
                            if (gamePanel.obj[i].collisions) {
                                entity.collisionON = true;
                            }
                            if (player) {
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if (entity.solidArea.intersects(gamePanel.obj[i].solidArea)) {
                            if (gamePanel.obj[i].collisions) {
                                entity.collisionON = true;
                            }
                            if (player) {
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if (entity.solidArea.intersects(gamePanel.obj[i].solidArea)) {
                            if (gamePanel.obj[i].collisions) {
                                entity.collisionON = true;
                            }
                            if (player) {
                                index = i;
                            }
                        }
                        break;
                }

                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gamePanel.obj[i].solidArea.x = gamePanel.obj[i].solidAreaDefaultX;
                gamePanel.obj[i].solidArea.y = gamePanel.obj[i].solidAreaDefaultY;
            }
        }

        return index;
    }
}
