package src.gui;

import javax.imageio.ImageIO;

import src.objects.*;

import java.awt.*;
import java.awt.geom.Dimension2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AssetLoader {
    private final FloatDimension BASE_RESOLUTION = new FloatDimension(1920.0f, 1080.0f);
    private FloatDimension spriteSize;
    private final String IMAGE_PATH = "src\\resources\\";
    private final String[] IMAGES = {"Basic_Coal_Mine.png","Basic_Copper_Mine.png", "Basic_Gold_Mine.png",
            "Basic_Silver_Mine.png", "Basic_Tree.png"};
    private BufferedImage[] loadedImages = new BufferedImage[IMAGES.length];

    public AssetLoader(Dimension screenResolution) throws IOException {
        spriteSize = new FloatDimension(screenResolution.width / BASE_RESOLUTION.width,
                screenResolution.height / BASE_RESOLUTION.height);
        int i = 0;
        for(String image : IMAGES){
            String spritePath = IMAGE_PATH + image;
            BufferedImage sprite = ImageIO.read(new File(spritePath));
            loadedImages[i] = scaleSprite(sprite, spriteSize.width, spriteSize.height);
            i++;
        }
    }

    private BufferedImage scaleSprite(BufferedImage sprite, float newWidthFactor, float newHeightFactor){
        float newWidth = sprite.getWidth() * newWidthFactor;
        float newHeight = sprite.getHeight() * newHeightFactor;
        Dimension resizedSprite = new Dimension( (int) newWidth,(int) newHeight);
        Image scaledSprite = sprite.getScaledInstance(resizedSprite.width, resizedSprite.height, Image.SCALE_SMOOTH);
        BufferedImage newSprite = new BufferedImage(resizedSprite.width, resizedSprite.height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = newSprite.createGraphics();
        g2d.drawImage(scaledSprite, 0, 0, null);
        g2d.dispose();
        return newSprite;
    }

    public BufferedImage getSprite(String imageTitle){
        int imageIndex = 0;
        for(int i = 0; i < IMAGES.length; i++){
            if(IMAGES[i].equals(imageTitle)){
                imageIndex = i;
            }
        }
        return loadedImages[imageIndex];
    }
}
