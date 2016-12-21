package Contra;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ContraMain extends Applet implements Runnable, KeyListener
{
    public void init()
    {
        setSize(400, 400);
        setBackground(new Color(128, 128, 128));
        addKeyListener(this);
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
