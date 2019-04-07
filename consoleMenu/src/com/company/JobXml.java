package com.company;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class JobXml {

    private static final String FILENAME = "temp.xml";

    public static void Сheckfile (String typetxt, String nametxt, String surnametxt, String patronymictxt, String birthdaytxt, String hiringProceduretxt) throws ParserConfigurationException, IOException, TransformerException, SAXException {

        final String filepath = System.getProperty("user.dir") + File.separator + FILENAME;
        File tmpDir = new File(filepath);

        boolean exists = tmpDir.exists();

        if (exists == false)
        {
            XMLadd(typetxt, nametxt, surnametxt, patronymictxt, birthdaytxt, hiringProceduretxt);
        }

        if (exists == true)
        {
            Xmladdfailhave(typetxt, nametxt, surnametxt, patronymictxt, birthdaytxt, hiringProceduretxt);
        }

    }

    public static void XMLadd (String typetxt, String nametxt, String surnametxt, String patronymictxt, String birthdaytxt, String hiringProceduretxt) throws ParserConfigurationException, IOException, TransformerException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = factory.newDocumentBuilder();
        Document doc = docBuilder.newDocument();
        doc.normalize();

        Element rootElement = doc.createElement("works");
        doc.appendChild(rootElement);

        Element employees = doc.createElement("employees");
        rootElement.appendChild(employees);

        Attr type = doc.createAttribute("type");
        type.setTextContent(typetxt);
        employees.setAttributeNode(type);

        Attr surname = doc.createAttribute("surname");
        surname.setTextContent(surnametxt);
        employees.setAttributeNode(surname);

        Attr name = doc.createAttribute("name");
        name.setTextContent(nametxt);
        employees.setAttributeNode(name);

        Attr patronymic = doc.createAttribute("patronymic");
        patronymic.setTextContent(patronymictxt);
        employees.setAttributeNode(patronymic);

        Attr birthday = doc.createAttribute("birthday");
        birthday.setTextContent(birthdaytxt);
        employees.setAttributeNode(birthday);

        Attr hiringProcedure = doc.createAttribute("hiringProcedure");
        hiringProcedure.setTextContent(hiringProceduretxt);
        employees.setAttributeNode(hiringProcedure);

        Transformer t = TransformerFactory.newInstance().newTransformer();
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        t.transform(new DOMSource(doc), new StreamResult(new FileOutputStream("temp.xml")));

    }

    public static void Xmladdfailhave(String typetxt, String nametxt, String surnametxt, String patronymictxt, String birthdaytxt, String hiringProceduretxt) throws ParserConfigurationException, IOException, TransformerException, SAXException {

        final String filepath = System.getProperty("user.dir") + File.separator + FILENAME;
        final File xmlFile = new File(filepath);
        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = db.parse(xmlFile);
        doc.normalize();

        Node rootElement = doc.getFirstChild();

        Element employees = doc.createElement("employees");
        rootElement.appendChild(employees);

        Attr type = doc.createAttribute("type");
        type.setTextContent(typetxt);
        employees.setAttributeNode(type);

        Attr name = doc.createAttribute("name");
        name.setTextContent(nametxt);
        employees.setAttributeNode(name);

        Attr surname = doc.createAttribute("surname");
        surname.setTextContent(surnametxt);
        employees.setAttributeNode(surname);

        Attr patronymic = doc.createAttribute("patronymic");
        patronymic.setTextContent(patronymictxt);
        employees.setAttributeNode(patronymic);

        Attr birthday = doc.createAttribute("birthday");
        birthday.setTextContent(birthdaytxt);
        employees.setAttributeNode(birthday);

        Attr hiringProcedure = doc.createAttribute("hiringProcedure");
        hiringProcedure.setTextContent(hiringProceduretxt);
        employees.setAttributeNode(hiringProcedure);

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(filepath));
        transformer.transform(source, result);
    }
}
