package org.hbrs.se.ws20.uebung1;

import org.hbrs.se.ws20.uebung1.control.GermanTranslator;
import org.hbrs.se.ws20.uebung1.control.Translator;
import static org.junit.jupiter.api.Assertions.*;

class GermanTranslatorTest {

    @org.junit.jupiter.api.Test
    void translateNumber() {
        Translator germanTranslator = new GermanTranslator() ;
        // positiv
        assertEquals("Sieben", germanTranslator.translateNumber(7));
        assertEquals("Neun",germanTranslator.translateNumber(9));
        // negativ
        assertEquals("Übersetzung der Zahl ("+30
                + ") nicht möglich (" +Translator.version+")",germanTranslator.translateNumber(30));
        assertEquals("Übersetzung der Zahl ("+ -1
                + ") nicht möglich (" +Translator.version+")",germanTranslator.translateNumber(-1));
    }
}