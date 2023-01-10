package src.GameObjects;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BackgroundObject implements GameObject{
    BufferedImage background;
    private final String TREE_PATH = "src\\main\\resources\\Test_Background.png";
    private Point.Float backgroundLocation = new Point.Float(-300,-300);

    public BackgroundObject(){
        try{
            background = ImageIO.read(new File(TREE_PATH));
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void updateLocation(Point.Float update){
        backgroundLocation.setLocation(backgroundLocation.x + update.x, backgroundLocation.y + update.y);
    }

    public void draw(Graphics2D g2){
        g2.drawImage(background, (int) backgroundLocation.x, (int) backgroundLocation.y,null);
    }

    public Graphics getGraphics(){
        return background.getGraphics();
    }
}
