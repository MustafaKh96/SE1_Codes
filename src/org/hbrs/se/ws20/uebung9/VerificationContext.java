package org.hbrs.se.ws20.uebung9;

public class VerificationContext {

    private VerificationAlgo algo = null;

    protected void setAlgo(VerificationAlgo algo) {
        this.algo = algo;
    }
    public status verifyBooking(Buchung booking){
        return algo.verfiyBooking(booking);
    }
}