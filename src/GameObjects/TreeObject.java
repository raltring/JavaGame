package src.GameObjects;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TreeObject implements GameObject{
    //private final String TREE_PATH = "src\\main\\resources\\Basic_Tree.png";
    private Point.Float spriteLocation = new Point.Float(100,100);
    //private Point2D.Float spriteScale = new Point2D.Float(1.0f, 2.0f);
    //private Dimension spriteSize = new Dimension(120, 90);
    private BufferedImage sprite = null;
    //private BufferedImage drawnSprite = null;
    //private Integer stroke = 5;

    public TreeObject(BufferedImage sprite){
        this.sprite = sprite;
        /*try{
            sprite = ImageIO.read(new File(TREE_PATH));
            drawnSprite = scaleSprite(sprite, 180, 130);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }*/
    }

    /*private BufferedImage scaleSprite(BufferedImage sprite, int newWidth, int newHeight){
        Image scaledSprite = sprite.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        BufferedImage newSprite = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = newSprite.createGraphics();
        g2d.drawImage(scaledSprite, 0, 0, null);
        g2d.dispose();
        return newSprite;
    }*/

    public void updateLocation(Point.Float update){
        spriteLocation.setLocation(spriteLocation.x + update.x, spriteLocation.y + update.y);
    }

    public void draw(Graphics2D g2){
        //g2.transform(getAffineTransform(g2.getTransform()));
        g2.drawImage(sprite,(int) spriteLocation.x, (int) spriteLocation.y,null);
    }

    private AffineTransform getAffineTransform(AffineTransform at){
        //at.scale(spriteScale.x, spriteScale.y);
        return at;
    }
}
