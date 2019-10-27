package com.krupoderov.game;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Krupoderov Mikhail on Oct, 2019
 */
public class GamePanel extends JPanel implements Runnable {

    public static int width;
    public static int height;

    private Thread thread;
    private boolean running = false;

    private BufferedImage image;
    private Graphics2D graphics2D;

    public GamePanel(int width, int height) {
        this.width = width;
        this.height = height;
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        requestFocus();
    }

    @Override
    public void addNotify() {
        super.addNotify();

        if (thread == null) {
            thread = new Thread(this,"GameThread");
            thread.start();
        }
    }

    public void init() {
        running = true;

        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        graphics2D = (Graphics2D)image.getGraphics();
    }

    @Override
    public void run() {
        init();

        while (running) {
            update();
            render();
            draw();
        }
    }

    private int x = 0;

    public void update() {
    }

    public void render() {

    }

    public void draw() {

    }
}
