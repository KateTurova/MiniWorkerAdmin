package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class PrintConsole {

    private static final String FILENAME = "temp.xml";

    public static void PrintConsole() {
        try {
            final String filepath = System.getProperty("user.dir") + File.separator + FILENAME;
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(new File(filepath)); // fileName - путь до xml
            Element root = document.getDocumentElement();

            NodeList list = root.getElementsByTagName("employees");
            for (int i = 0; i < list.getLength(); i++) {
                Element element = (Element) list.item(i);
                System.out.println(element.getAttribute("type") + " | " + element.getAttribute("name") + " | " + element.getAttribute("surname") + " | " + element.getTextContent());
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

}
