package org.hbrs.se.ws20.uebung9.controller;

import org.hbrs.se.ws20.uebung9.Buchung;
import org.hbrs.se.ws20.uebung9.VerificationContext;
import org.hbrs.se.ws20.uebung9.status;


public class ReiseAnbieterController{
    private VerificationContext context = null;

    public void doSomething() {
        status status = context.verifyBooking( new Buchung() );
    }
}