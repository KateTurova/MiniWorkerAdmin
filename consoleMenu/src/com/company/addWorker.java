package com.company;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class addWorker {

    public static void addworker() throws ParseException, ParserConfigurationException, TransformerException, SAXException, IOException {

        ConsoleMenu cm = new ConsoleMenu();
        Scanner in = new Scanner(System.in);
        Calendar dataIn = new GregorianCalendar();

        System.out.println("Введите тип специалиста");
        String typetxt = in.nextLine();
        if (in.hasNextLine()) {
            typetxt = in.nextLine();
        }

        System.out.println("Введите фамилию");
        String surnametxt = in.toString();
        if (in.hasNextLine()) {
            surnametxt = in.nextLine();
        }

        System.out.println("Введите имя");
        String nametxt = in.toString();
        if (in.hasNextLine()) {
            nametxt = in.nextLine();
        }
        System.out.println("Введите отчество");
        String patronymictxt = in.toString();
        if (in.hasNextLine()) {
            patronymictxt = in.nextLine();
        }

        System.out.println("Введите дату рождения в формате (dd.mm.yyyy): ");
        String birthdaytxt = in.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        dataIn.setTime(sdf.parse(birthdaytxt));

        System.out.println("Введите дату принятия на работу в формате (dd.mm.yyyy): ");
        String hiringProceduretxt  = in.nextLine();
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        dataIn.setTime(df.parse(hiringProceduretxt));

       // System.out.printf("фамилия = " + surname + " " + "имя = " + name + " " + "отчество = " + patronymic + " " + "дата рождения " + birthday + "дата принятия на работу " + hiringProcedure );

        JobXml jx = new JobXml();
        jx.Сheckfile(typetxt, nametxt, surnametxt, patronymictxt, birthdaytxt, hiringProceduretxt);

        System.out.println("Запись сохранена!");
        cm.ShowMenuAddNewEmployee();

    }
}
