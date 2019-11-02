package com.krupoderov.game.tiles;

import com.krupoderov.game.graphics.Sprite;
import com.krupoderov.game.tiles.blocks.Block;
import com.krupoderov.game.tiles.blocks.NormBlock;
import com.krupoderov.game.util.Vector2f;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Krupoderov Mikhail on Nov, 2019
 */
public class TileMapNorm extends TileMap {

    private ArrayList<Block> blocks;

    public TileMapNorm(String data, Sprite sprite, int width, int height, int tileWidth, int tileHeight, int tileColumns) {
        blocks = new ArrayList<Block>();

        String[] block = data.split(",");
        for (int i = 0; i < (width * height); i++) {
            int temp = Integer.parseInt(block[i].replaceAll("\\s+", ""));
            if (temp != 0) {
                blocks.add(new NormBlock(
                        sprite.getSprite((int) ((temp - 1) % tileColumns),
                                (int) ((temp - 1) / tileColumns)),
                        new Vector2f((int) (i % width) * tileWidth, (int) (i / height) * tileHeight),
                        tileWidth,
                        tileHeight));
            }
        }
    }

    @Override
    public void render(Graphics2D g) {
        for (int i = 0; i < blocks.size(); i++) {
            blocks.get(i).render(g);
        }
    }
}
