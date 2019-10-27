package com.krupoderov.game.states;

import com.krupoderov.game.util.KeyHandler;
import com.krupoderov.game.util.MouseHandler;

import java.awt.*;

/**
 * Created by Krupoderov Mikhail on Oct, 2019
 */
public abstract class GameState {

    private GameStateManager gsm;

    public GameState(GameStateManager gsm) {
        this.gsm = gsm;
    }

    public abstract void update();
    public abstract void input(MouseHandler mouse, KeyHandler key);
    public abstract void render(Graphics2D g);
}
