package com.krupoderov.game.states;

import com.krupoderov.game.GamePanel;
import com.krupoderov.game.entity.Player;
import com.krupoderov.game.graphics.Font;
import com.krupoderov.game.graphics.Sprite;
import com.krupoderov.game.tiles.TileManager;
import com.krupoderov.game.util.KeyHandler;
import com.krupoderov.game.util.MouseHandler;
import com.krupoderov.game.util.Vector2f;

import java.awt.*;

/**
 * Created by Krupoderov Mikhail on Oct, 2019
 */
public class PlayState extends GameState {

    private Font font;
    private Player player;
    private TileManager tm;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        tm = new TileManager("tile/tilemap.xml");
        font = new Font("font/font.png", 10, 10);
        player = new Player(new Sprite("entity/linkFormatted.png"), new Vector2f(300, 300), 128);
    }

    @Override
    public void update() {
        player.update();
    }

    @Override
    public void input(MouseHandler mouse, KeyHandler key) {
        player.input(mouse, key);
    }

    @Override
    public void render(Graphics2D g) {
        tm.render(g);
        Sprite.drawArray(g, font, GamePanel.oldFrameCount + " FPS", new Vector2f(GamePanel.width - 192, 32), 32, 32, 24, 0);
        player.render(g);
    }
}
