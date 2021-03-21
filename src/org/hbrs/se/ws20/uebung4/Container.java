package org.hbrs.se.ws20.uebung4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Container {

    // Interne ArrayList zur Abspeicherung der Objekte
    private List<UserStory> liste = null;


    // Statische Klassen-Variable, um die Referenz
    // auf das einzige Container-Objekt abzuspeichern
    private static Container instance = new Container();
    private Container(){
        liste = new ArrayList<UserStory>();
    }
    public static Container getInstance() {
        return instance;
    }

    private boolean find(UserStory r) {
        int ID = r.getId();
        for ( UserStory rec : liste) {
            if ( rec.getId() == ID ) {
                return true;
            }
        }
        return false;
    }
    public void addUserStory ( UserStory r ) throws ContainerException {
        if ( find(r) == true ) {
            ContainerException ex = new ContainerException("ID bereits vorhanden!");
            throw ex;
        }
        liste.add(r);
    }
    private UserStory getEinebestimmteUserStory(int id) {
        for ( UserStory rec : liste) {
            if (id == rec.getId() ){
                return rec;
            }
        }
        return null;
    }
    public int size(){
        return liste.size();
    }
    public List<UserStory> getCurrentList() {
        return this.liste;
    }


    public void startEingabe() throws ContainerException, Exception {

        String strInput = null;
        Scanner scanner = new Scanner(System.in);

        int ID ;
        int mehrwert;
        int risk ;
        int strafe ;
        int aufwand ;
        String titel;

        // Begruessung
        System.out.println("UserStory-Tool V1.5 by Musti");

        while (true) {
            try {
                System.out.print("> ");
                strInput = scanner.nextLine();
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Extrahiert ein Array aus der Eingabe
            String[] strings = strInput.split(" ");

            // 	Falls 'help' eingegeben wurde, werden alle Befehle ausgedruckt
            if (strings[0].equals("help")) {
                System.out.println("Folgende Befehle stehen zur Verfuegung: help, dump, exit" +
                        " load, store, enter");
            } else if (strings[0].equals("dump")) {
                startAusgabe();
            } else if (strings[0].equals("store")) {
                this.store();
            } else if (strings[0].equals("load")) {
                this.load();
            } else if (strings[0].equals("enter")) {

                // Ausgabe einer Eingabeaufforderung
                System.out.println("Geben sie die Grunddaten der User Story ein:");
                // Eingabe der ID:
                while(true) {
                    System.out.print("ID der User Story: ");
                    try {
                        ID = scanner.nextInt();
                    } catch (Exception e) {
                        System.out.println("Die Eingabe ist falsch, versuchen Sie nochmal");
                        scanner.next(); // schreib die falsche Eingabe hier
                        continue;
                    }
                    break;
                }

                // Titel der User Story:
                System.out.print("Titel der User Story: ");
                titel = scanner.next();

                // Eingabe des Aufwands:
                while(true) {
                    System.out.print("Aufwand der User Story: ");
                    try {
                        aufwand = scanner.nextInt();
                    } catch (Exception e) {
                        System.out.println("Die Eingabe ist falsch, versuchen Sie nochmal");
                        scanner.next(); // lösche die Eingabe
                        continue;
                    }
                    break;
                }

                // Eingabe des Risikos:
                while(true) {
                    System.out.print("Risiko der User Story: ");
                    try {
                        risk = scanner.nextInt();
                    } catch (Exception e) {
                        System.out.println("Die Eingabe ist falsch, versuchen Sie nochmal");
                        scanner.next(); // lösche die Eingabe
                        continue;
                    }
                    break;
                }

                // Eingabe des Mehrwerts:
                while(true) {
                    System.out.print("Mehrwert der User Story: ");
                    try {
                        mehrwert = scanner.nextInt();
                    } catch (Exception e) {
                        System.out.println("Die Eingabe ist falsch, versuchen Sie nochmal");
                        scanner.next(); // lösche die Eingabe
                        continue;
                    }
                    break;
                }

                // Eingabe des Strafe:
                while(true) {
                    System.out.print("Strafe der User Story: ");
                    try {
                        strafe = scanner.nextInt();
                    } catch (Exception e) {
                        System.out.println("Die Eingabe ist falsch, versuchen Sie nochmal");
                        scanner.next(); // lösche die Eingabe
                        continue;
                    }
                    break;
                }

                // Berechnung der Priorisierung
                double prio =  ( (mehrwert + strafe ) / ( aufwand + risk ) );
                System.out.println("User Story mit ID: " + ID + " hat die Prio: " + prio);
                // Neues Objekt vom Typ UserStory
                UserStory us = new UserStory( ID, titel, mehrwert, strafe, aufwand, risk , prio );
                // Hinzufügen
                try {
                    addUserStory(us);
                } catch (ContainerException e) {
                    System.out.println("Fehler beim Abspeichern der User Story!");
                }
            }

            else if(strings[0].equals("exit")){
                break;
            }
        }
    }

    public void startAusgabe(){
        // mit einem Sortieralgorithmus sortieren.
        java.util.Collections.sort(liste);
        for(UserStory us : liste){
            System.out.println(us.toString());
        }
    }
    public void store() throws ContainerException {
        String FileName = "UserStory.bin";

        try{
            FileOutputStream fos = new FileOutputStream(FileName);

            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(this.liste);

            fos.close();
            oos.close();

            System.out.println( this.size() + " User Stories wurden erfolgreich gespeichert!");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void load() throws ContainerException {
        String FileName = "UserStory.bin";

        try {
            FileInputStream fis = new FileInputStream(FileName);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                this.liste = (List<UserStory>) obj;
            }
            System.out.println("Es wurden " + this.size() + " User Stories erfolgreich reingeladen!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}