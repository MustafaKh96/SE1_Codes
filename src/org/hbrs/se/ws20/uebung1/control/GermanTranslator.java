package org.hbrs.se.ws20.uebung1.control;

public class GermanTranslator implements Translator {
    public String date = "Okt/2020";
    public String translateNumber( int number ) {
        try {
            String[] a = {"Eins", "Zwei", "Drei", "Vier", "Fünf", "Sechs", "Sieben", "Acht", "Neun", "Zehn"} ;
            return a[number-1];
        }
        catch (Exception e) {
            return "Übersetzung der Zahl("+ number +") nicht möglich (" + Translator.version + ")";
        }
    }
    public void printInfo() {
        System.out.println( "GermanTranslator v1.9, erzeugt am " + this.date );
    }
    public void setDate( String date ) {
        this.date = date;
    }
}