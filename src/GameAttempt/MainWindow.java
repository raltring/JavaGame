package src.GameAttempt;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    MainPanel panel;
    Dimension screenResolution = new Dimension(800,600);


    public MainWindow(AssetLoader assets, GraphicsDevice myDevice, DisplayMode myDisplay){
        this.setUndecorated(true);                                  //Removes "decorations" e.g. menu bar
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        screenResolution = new Dimension(myDisplay.getWidth(), myDisplay.getHeight());
        panel = new MainPanel(screenResolution, assets);
        this.add(panel);
        this.setResizable(false);
        this.setVisible(true);

        if(myDevice.isFullScreenSupported()) {
            try {
                myDevice.setFullScreenWindow(this);
                myDevice.setDisplayMode(myDisplay);
            } catch (Exception e) {
                myDevice.setFullScreenWindow(null);
                this.setSize(screenResolution);
            }
        }
    }
}
