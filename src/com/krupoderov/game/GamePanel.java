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

        final double GAME_HERTZ = 60.0;
        final double TBU = 1_000_000_000 / GAME_HERTZ; // Time before update

        final int MUBR = 5; // Must update before render

        double lastUpdateTime = System.nanoTime();
        double lastRenderTime;

        final double TARGER_FPS = 60;
        final double TTBR = 1_000_000_000 / TARGER_FPS; // Total time before render

        int frameCount = 0;
        int lastSecondTime = (int) (lastUpdateTime / 1_000_000_000);
        int oldFrameCount = 0;

        while (running) {
            double now = System.nanoTime();
            int updateCount = 0;
            while (((now - lastUpdateTime) > TBU) && (updateCount < MUBR)) {
                update();
                input();
                lastUpdateTime += TBU;
                updateCount++;
            }

            if (now - lastUpdateTime > TBU) {
                lastUpdateTime = now - TBU;
            }

            input();
            render();
            draw();
            lastRenderTime = now;
            frameCount++;

            int thisSecond = (int) (lastUpdateTime / 1_000_000_000);
            if (thisSecond > lastSecondTime) {
                if (frameCount != oldFrameCount) {
                    System.out.println("NEW SECOND " + thisSecond + " " + frameCount);
                    oldFrameCount = frameCount;
                }
                frameCount = 0;
                lastSecondTime = thisSecond;

                while (now - lastRenderTime < TTBR && now - lastUpdateTime < TBU) {
                    Thread.yield();

                    try {
                        Thread.sleep(1);
                    }catch (Exception e) {
                        System.out.println("ERROR: yielding thread");
                    }

                    now = System.nanoTime();
                }
            }
        }
    }

    public void update() {
    }

    public void input(){

    }

    public void render() {
        if (graphics2D != null) {
            graphics2D.setColor(new Color(40, 132, 244));
            graphics2D.fillRect(0, 0, width, height);
        }
    }

    public void draw() {
        Graphics graphics = (Graphics) this.getGraphics();
        graphics.drawImage(image, 0, 0, width, height, null);
        graphics.dispose();
    }
}
