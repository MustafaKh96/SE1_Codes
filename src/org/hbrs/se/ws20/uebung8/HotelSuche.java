package org.hbrs.se.ws20.uebung8;

public class HotelSuche {

    public void start() {
        ExternalHotelsucheInterface adapter = new ReiseAnbieterAdapter(); // Factory
        SuchErgebnis ergebnis = adapter.suche( new SuchAuftrag() );
    }
}