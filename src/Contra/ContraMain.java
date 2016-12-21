package Contra;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.MalformedURLException;
import java.net.URL;

public class ContraMain extends Applet implements Runnable, KeyListener
{
    MapSpriteSheet maps[];

    public void init()
    {
        setSize(400, 400);
        setBackground(new Color(128, 128, 128));
        addKeyListener(this);

        if (createMapSpriteSheet(1) == 12)
        {
            System.out.println("Something went wrong with initializing the map sprite sheet");
            stop();
        }
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
        /*
        File file = new File(getClass().getResource("/map_bg.png").getFile());
        BufferedImage image;
        try{
            image = ImageIO.read(file);
            g.drawImage(image, 0, 0, this);
        }
        catch (IOException ex) {}*/
    }

    private int createMapSpriteSheet(int i)
    {
        try
        {
            URL resource = new URL(getClass().getClassLoader().getResource("stage_" + i + ".map").toString());
            maps[i] = new MapSpriteSheet(resource, i);
        }
        catch (MalformedURLException ex)
        {
            return 12;
        }
        return 0;
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
