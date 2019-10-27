package com.krupoderov.game;

import javax.swing.*;

/**
 * Created by Krupoderov Mikhail on Oct, 2019
 */
public class Window extends JFrame {

    public Window() {
        setTitle("Title");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new GamePanel(1280, 720));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
