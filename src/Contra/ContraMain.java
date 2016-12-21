package Contra;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ContraMain extends Applet implements Runnable, KeyListener
{
    Icon bgIcon;
    public void init()
    {
        setSize(400, 400);
        setBackground(new Color(128, 128, 128));
        addKeyListener(this);
        System.out.println(getCodeBase() + "./Resources/map_bg.png");
        bgIcon = new ImageIcon("Resources/map_bg.png");

    }

    public void start()
    {
        Thread th = new Thread(this);
        th.start();
        setFocusable(true);
    }

    public void stop() {System.exit(0);}

    public void paint(Graphics g)
    {
        File file = new File(getClass().getResource("/map_bg.png").getFile());
        BufferedImage image;
        try{
            image = ImageIO.read(file);
            g.drawImage(image, 0, 0, this);
        }
        catch (IOException ex) {}

    }

    @Override
    public void run()
    {
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        while (true)
        {
            try
            {
                Thread.sleep(3);
            }
            catch (InterruptedException ex)
            {
                stop();
            }

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
