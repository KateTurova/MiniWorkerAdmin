package com.company;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.text.ParseException;


public class buttonMenu {

    public static void buttonMenu() throws IOException, ParseException, TransformerException, ParserConfigurationException, SAXException {
        menu();

    }

    public static void menu() throws IOException, ParseException, TransformerException, ParserConfigurationException, SAXException {
        ConsoleMenu cs = new ConsoleMenu();

        char ch;
        cs.ShowMenu();
        boolean notExit = true;

        while (notExit) {

            ch = (char) System.in.read();

            switch (ch) {
                case '1':
                    addNewEmployee();
                    break;

                case '2':
                    printConsol();
                    break;

                case '0':
                    notExit = false;
                    System.exit(0);
            }
        }
    }

    public static void addNewEmployee() throws IOException, ParseException, TransformerException, ParserConfigurationException, SAXException {

        addWorker work = new addWorker();
        work.addworker();

            BackButton();


    }

    public static void printConsol() throws IOException, ParseException, TransformerException, ParserConfigurationException, SAXException {
        ConsoleMenu cm = new ConsoleMenu();
        PrintConsole print = new PrintConsole();
        print.PrintConsole();
        cm.ShowMenuPrintConsole();

        BackButton();
    }

    public static void BackButton () throws IOException, ParseException, TransformerException, ParserConfigurationException, SAXException {
        char er;
        boolean not = true;

        while (not) {
            er = (char) System.in.read();
            switch (er)
            {
                case '0':
                    not = false;
                    menu();
            }
        }
}
}