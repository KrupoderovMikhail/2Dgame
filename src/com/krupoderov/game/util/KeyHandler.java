package com.krupoderov.game.util;

import com.krupoderov.game.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krupoderov Mikhail on Oct, 2019
 */
public class KeyHandler implements KeyListener {

    public static List<Key> keys = new ArrayList<>();

    public class Key {
        public int presses, absorbs;
        public boolean down, clicked;

        public Key() {
            keys.add(this);
        }

        public void toogle(boolean pressed) {
            if (pressed != down) {
                down = pressed;
            }

            if (pressed) {
                presses++;
            }
        }

        public void tick() {
            if (absorbs < presses) {
                absorbs++;
                clicked = true;
            } else {
                clicked = false;
            }
        }
    }

    public Key up = new Key();
    public Key down = new Key();
    public Key left = new Key();
    public Key right = new Key();
    public Key attack = new Key();
    public Key menu = new Key();
    public Key enter = new Key();
    public Key escape = new Key();

    public KeyHandler(GamePanel game) {
        game.addKeyListener(this);
    }

    public void releaseAll() {
        for (int i = 0; i < keys.size(); i++) {
            keys.get(i).down = false;
        }
    }

    public void tick() {
        for (int i = 0; i < keys.size(); i++) {
            keys.get(i).tick();
        }
    }

    public void toogle(KeyEvent e, boolean pressed) {
        if (e.getKeyCode() == KeyEvent.VK_W) up.toogle(pressed);
        if (e.getKeyCode() == KeyEvent.VK_S) down.toogle(pressed);
        if (e.getKeyCode() == KeyEvent.VK_A) left.toogle(pressed);
        if (e.getKeyCode() == KeyEvent.VK_D) right.toogle(pressed);
        if (e.getKeyCode() == KeyEvent.VK_SPACE) attack.toogle(pressed);
        if (e.getKeyCode() == KeyEvent.VK_E) menu.toogle(pressed);
        if (e.getKeyCode() == KeyEvent.VK_ENTER) enter.toogle(pressed);
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) escape.toogle(pressed);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // do nothing
    }

    @Override
    public void keyPressed(KeyEvent e) {
        toogle(e, true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        toogle(e, false);
    }
}
