package org.hbrs.se.ws20.uebung1.control;

public class Factory {
    public static Translator createGermanTranslator() {
        return  new GermanTranslator();
    }
    public static Translator createEnglishTranslator(){ return new EnglishTranslator(); }
    // Die Methoden sollen static sein, dann kann ich über den Klassennamen auf die beiden
    // Methoden createGermanTranslator und createEnglishTranslator in Client zugreifen.
    // Wenn die Methoden Nicht-Static sind, dann muss ich ein Objekt der Klasse Factory
    // in Client erzeugen und dann auf die Methoden der Klasse Factory zugreifen.
    // (muss mit new sein, aber es ist verboten)
}