package org.hbrs.se.ws20.uebung1.control;

public class EnglishTranslator implements Translator {
    public String date = "Okt/2020";
    public String translateNumber( int number ) {
        try {
            String[] a = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"} ;
            return a[number-1];
        }
        catch (Exception e) {
            return "Übersetzung der Zahl("+ number +") nicht möglich (" + Translator.version + ")";
        }
    }
    public void printInfo() {
        System.out.println( "EnglishTranslator v1.9, erzeugt am " + this.date );
    }
    public void setDate( String date ) {
        this.date = date;
    }
}
