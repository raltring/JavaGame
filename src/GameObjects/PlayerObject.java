package src.GameObjects;

import src.GameAttempt.ButtonStates;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;

public class PlayerObject{
    private Dimension playerSize = new Dimension(20,20);
    private Point playerLocation;
    private Point.Float playerVelocity = new Point.Float(0.2f, 0.2f);
    private Boolean upHeald = false;

    public PlayerObject(Dimension screenResolution){
        playerLocation = new Point((screenResolution.width / 2) - (playerSize.width / 2),
                (screenResolution.height / 2) - (playerSize.height / 2));
    }

    public Point.Float update(long deltaTime, ButtonStates buttons){
        Point.Float movement = new Point.Float(0,0);
        if(buttons.upButtonPressed){
            movement.y = deltaTime * playerVelocity.y;
        }
        if(buttons.downButtonPressed){
            movement.y = deltaTime * -playerVelocity.y;
        }
        if(buttons.leftButtonPressed){
            movement.x = deltaTime * playerVelocity.x;
        }
        if(buttons.rightButtonPressed){
            movement.x = deltaTime * -playerVelocity.x;
        }
        return movement;
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.BLACK);
        g2.drawRect(playerLocation.x,playerLocation.y,playerSize.width,playerSize.height);
        g2.setColor(Color.RED);
        g2.fillRect(playerLocation.x,playerLocation.y,playerSize.width,playerSize.height);
    }
}
