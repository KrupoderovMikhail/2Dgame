package com.krupoderov.game.states;

import com.krupoderov.game.graphics.Font;
import com.krupoderov.game.graphics.Sprite;
import com.krupoderov.game.util.KeyHandler;
import com.krupoderov.game.util.MouseHandler;
import com.krupoderov.game.util.Vector2f;

import java.awt.*;

/**
 * Created by Krupoderov Mikhail on Oct, 2019
 */
public class PlayState extends GameState {

    private Font font;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        font = new Font("font/ZeldaFont.png", 16, 16);
    }

    @Override
    public void update() {

    }

    @Override
    public void input(MouseHandler mouse, KeyHandler key) {
    }

    @Override
    public void render(Graphics2D g) {
        Sprite.drawArray(g, font, "HELLO WORLD", new Vector2f(100, 100), 32, 32, 32, 0);
    }
}
