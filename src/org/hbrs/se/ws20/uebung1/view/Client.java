package org.hbrs.se.ws20.uebung1.view;
import org.hbrs.se.ws20.uebung1.control.Factory;
import org.hbrs.se.ws20.uebung1.control.Translator;

public class Client {
    public void display(int aNumber){
        Translator translator = Factory.createGermanTranslator() ;
        System.out.println("Das Ergebnis der Berechnung: " + translator.translateNumber(aNumber));
    }
}