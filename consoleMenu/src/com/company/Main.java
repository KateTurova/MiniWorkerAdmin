package com.company;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException, SAXException, ParseException, IOException {
        buttonMenu menu = new buttonMenu();
        menu.buttonMenu();
    }

}

