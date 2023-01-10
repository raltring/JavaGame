package src.GameAttempt;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class xmlIO {

    public xmlIO(Document xmlFile){
        NodeList list = xmlFile.getElementsByTagName("screen_resolution");
        System.out.println(list.item(0));
    }

    public xmlIO(String xmlFilePath) throws ParserConfigurationException, IOException, SAXException {
        File inputFile = new File(xmlFilePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document xmlFile = dBuilder.parse(inputFile);
        xmlFile.getDocumentElement().normalize();
        System.out.println("Root element: " + xmlFile.getDocumentElement().getNodeName());
        NodeList nodeList = xmlFile.getElementsByTagName("screen_resolution");
        for(int i = 0; i < nodeList.getLength(); i++){
            Node node = nodeList.item(i);
            System.out.println("Node Name: " + node.getNodeName());
            Element element = (Element) node;
            System.out.println("width: " + element.getElementsByTagName("width").item(0).getTextContent());
        }
    }
}
