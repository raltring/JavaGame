package src.GameAttempt;

import java.awt.geom.Dimension2D;

public class FloatDimension extends Dimension2D {
    public float width;
    public float height;

    public FloatDimension(float width, float height){
        this.setSize(width, height);
    }

    public double getWidth(){
        return width;
    }

    public double getHeight(){
        return height;
    }

    public void setSize(double width, double height){
        this.width = (float) width;
        this.height = (float) height;
    }
}
