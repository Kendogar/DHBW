package xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Lars on 30.06.2015.
 */
public class GoogleMapsGazette {
    String url, adresse, name, location, bounds;
    double north, south, west, east, newNorth, newEast, newWest, newSouth;
    ArrayList<double[]> coordinates = new ArrayList<>();

    public GoogleMapsGazette(String url){
        this.url = url;
    }

    public static Element getNamedChildElement(Node n, String name, int count) {
        for (int i=0; i<n.getChildNodes().getLength();i++) {
            if (n.getChildNodes().item(i).getNodeType()== Node.ELEMENT_NODE &&
                    n.getChildNodes().item(i).getNodeName().equals(name)) {
                if (count==0)
                    return (Element) n.getChildNodes().item(i);
                count--;
            }
        }
        return null;
    }

    public void doIt() throws IOException, SAXException, ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();
        DocumentBuilder parser = factory.newDocumentBuilder();
        Document doc = parser.parse(url);

        /*TransformerFactory tFactory = TransformerFactory.newInstance();
        tFactory.setAttribute("indent-number", 4); // Einrückung festlegen
        Transformer transformer = tFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes"); //schön!
        // Das Argument von DOMSource kann ein Document oder
        // ein beliebiger Node sein (Unterbaum!)
        DOMSource source = new DOMSource(doc);
        // StreamResult auf File, einen OutputStream oder Writer
        StreamResult result = new StreamResult(System.out);
        transformer.transform(source, result);*/


        adresse = doc.getElementsByTagName("formatted_address").item(0).getTextContent();
        name = doc.getElementsByTagName("address_component").item(0).getChildNodes().item(1).getTextContent();
        org.w3c.dom.NodeList locs = doc.getElementsByTagName("location").item(0).getChildNodes();
        location = "latitude: " + locs.item(1).getTextContent() + "  longitude: " + locs.item(3).getTextContent();
        org.w3c.dom.NodeList boundaries1 = doc.getElementsByTagName("southwest").item(1).getChildNodes();
        org.w3c.dom.NodeList boundaries2 = doc.getElementsByTagName("northeast").item(1).getChildNodes();
        bounds = "east " + boundaries1.item(1).getTextContent() + " north " + boundaries1.item(3).getTextContent() + " west " + boundaries2.item(1).getTextContent() + " south " + boundaries2.item(3).getTextContent();

        System.out.println(adresse);
        System.out.println(name);
        System.out.println(location);
        System.out.println(bounds);

        east = Double.valueOf(boundaries1.item(1).getTextContent());
        north = Double.valueOf(boundaries1.item(3).getTextContent());
        west = Double.valueOf(boundaries2.item(1).getTextContent());
        south = Double.valueOf(boundaries2.item(3).getTextContent());
    }

    public void toKML() throws ParserConfigurationException, TransformerException, FileNotFoundException {
        double längengradMitte = (north + south) / 2.0;
        double breitengradMitte = (east + west) / 2.0;
        double distLänge = Math.abs(north - längengradMitte);
        double distBreite = Math.abs(west - breitengradMitte);

        if (distLänge > distBreite){
            newNorth = längengradMitte + distLänge;
            newSouth = längengradMitte - distLänge;
            newEast = breitengradMitte + distLänge;
            newWest = breitengradMitte - distLänge;
        } else {
            newNorth = längengradMitte + distBreite;
            newSouth = längengradMitte - distBreite;
            newEast = breitengradMitte + distBreite;
            newWest = breitengradMitte - distBreite;
        }
        double stepSize = newNorth - newSouth;
        double[] startingPoint = {newNorth, newWest};
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                double[] temp = {startingPoint[0] + (j * stepSize), startingPoint[1] + (i * stepSize)};
                coordinates.add(temp);
            }
        }

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder parser = factory.newDocumentBuilder();
        Document doc = parser.newDocument();
        Element kml = doc.createElementNS("http://earth.google.com/kml/2.2", "kml");
        Element document = doc.createElement("Document");

        for (double[] coordipair : coordinates){
            Element placemark = doc.createElement("Placemark");
            Element point = doc.createElement("Point");
            Element coordinates = doc.createElement("coordinates");
            coordinates.setTextContent(coordipair[0] + ","+ coordipair[1]);
            point.appendChild(coordinates);
            placemark.appendChild(point);
            document.appendChild(placemark);
        }

        kml.appendChild(document);
        doc.appendChild(kml);

        TransformerFactory tFactory = TransformerFactory.newInstance();
        tFactory.setAttribute("indent-number", 4); // Einrückung festlegen
        Transformer transformer = tFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new FileOutputStream(new File("C:\\Users\\Lars\\IdeaProjects\\DHBW\\raster.kml")));
        transformer.transform(source, result);

    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {


        GoogleMapsGazette myTown = new GoogleMapsGazette("http://maps.googleapis.com/maps/api/geocode/xml?address=karlsruhe&sensor=false");
        myTown.doIt();
        myTown.toKML();

    }


}

