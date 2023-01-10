package src.GameAttempt;

import src.GameObjects.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainPanel extends JPanel {
    TreeObject tree;
    PlayerObject player;
    BackgroundObject background;
    long timeSinceLastDraw = 0;
    ButtonStates buttons = new ButtonStates();
    Dimension screenResolution;

    public MainPanel(Dimension screenResolution, AssetLoader assets){
        this.setIgnoreRepaint(true);
        this.createListener();
        this.screenResolution = screenResolution;
        tree = new TreeObject(assets.getSprite("Basic_Tree.png"));
        player = new PlayerObject(screenResolution);
        background = new BackgroundObject();
        this.setFocusable(true);
        this.grabFocus();
        MainThread thread = new MainThread(this);
        thread.start();
    }

    public void update(long deltaTime){
        timeSinceLastDraw += deltaTime;
        Point.Float movement = player.update(deltaTime, buttons);
        tree.updateLocation(movement);
        background.updateLocation(movement);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setBackground(Color.GREEN);
        long FPS = 0;
        if(timeSinceLastDraw > 0) {
            FPS = 1000 / timeSinceLastDraw;
        }
        background.draw(g2);
        player.draw(g2);
        tree.draw(g2);
        g2.setColor(Color.RED);
        g2.drawString(String.valueOf(FPS), 10, 10);
        timeSinceLastDraw = 0;
        g2.dispose();
        g.dispose();
    }

    private void createListener(){
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_UP){
                    buttons.upButtonPressed = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    buttons.downButtonPressed = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    buttons.leftButtonPressed = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    buttons.rightButtonPressed = true;
                }
            }

            public void keyReleased(KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_UP){
                    buttons.upButtonPressed = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    buttons.downButtonPressed = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    buttons.leftButtonPressed = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    buttons.rightButtonPressed = false;
                }
            }
        });


    }
}
