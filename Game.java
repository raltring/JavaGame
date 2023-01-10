import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import src.GameAttempt.AssetLoader;
import src.GameAttempt.MainWindow;
import src.GameAttempt.xmlIO;

public class Game {

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        GraphicsDevice myDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        DisplayMode[] myDisplays = myDevice.getDisplayModes();
        DisplayMode myDisplay = myDisplays[18];
        AssetLoader assets = new AssetLoader(new Dimension(myDisplay.getWidth(), myDisplay.getHeight()));
        MainWindow window = new MainWindow(assets, myDevice, myDisplay);


        xmlIO xml = new xmlIO("src\\GameAttempt\\UserSettings.xml");
    }
}
