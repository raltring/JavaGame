package src.objects;

import java.awt.*;
import java.awt.geom.AffineTransform;

public interface GameObject {

    void draw(Graphics2D g2);

    void updateLocation(Point.Float update);
}
