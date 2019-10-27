package com.krupoderov.game.states;

import com.krupoderov.game.util.KeyHandler;
import com.krupoderov.game.util.MouseHandler;

import java.awt.*;

/**
 * Created by Krupoderov Mikhail on Oct, 2019
 */
public class PlayState extends GameState {

    public PlayState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void update() {

    }

    @Override
    public void input(MouseHandler mouse, KeyHandler key) {

    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.RED);
        g.fillRect(0, 0, 64, 64);
    }
}
