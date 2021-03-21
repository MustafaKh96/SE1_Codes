package org.hbrs.se.ws20.uebung1.control;

import org.hbrs.se.ws20.uebung1.view.Client;

public class Black_Box {
    // Positivtests
    // Äquivalenzklasse AK (1 <= x <=10)
    // Negativtests
    // Äquivalenzklasse AK (x > 10)
    // Äquivalenzklasse AK (x < 0)
    // (x = 0) Spezial-Testfall
    public void test() {
        GermanTranslator tran = new GermanTranslator() ;
        String erg = tran.translateNumber(1) ;
        if(erg.equals("Eins")){
            System.out.println("Der Test ist erfolgreich");
        }
        else{
            System.out.println("Der Test ist nicht erfolgreich");
        }
    }
    public static void main(String[] args) {
        Black_Box b = new Black_Box();
        b.test();
     }
}
