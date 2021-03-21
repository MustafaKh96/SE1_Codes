package org.hbrs.se.ws20.uebung4;

import java.awt.image.renderable.ContextualRenderedImageFactory;
import java.io.Serializable;

public class UserStory implements Serializable, Comparable<UserStory>{

    private String titel;
    private String beschreibung;
    private int aufwand = 0;
    private int id = 0;
    private int mehrwert = 0;
    private int risk = 0;
    private int strafe = 0;
    private double prio = 0;

    public UserStory(int id, String titel, int mehrwert, int strafe,
                     int aufwand, int risk, double prio) {
        this.id = id;
        this.titel = titel;
        this.mehrwert = mehrwert;
        this.strafe = strafe;
        this.aufwand = aufwand;
        this.risk = risk;
        this.prio = prio;
    }

    public UserStory( int id ){
        this.id = id;
    }
    public String getBeschreibung(){
        return this.beschreibung;
    }
    public void setBeschreibung(String beschreibung){
        this.beschreibung = beschreibung;
    }
    public double getPrio() {
        return prio;
    }
    public void setPrio(double prio) {
        this.prio = prio;
    }
    public String getTitel() {
        return titel;
    }
    public void setTitel(String titel) {
        this.titel = titel;
    }
    public int getAufwand() {
        return aufwand;
    }
    public void setAufwand(int aufwand) {
        this.aufwand = aufwand;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getMehrwert() {
        return mehrwert;
    }
    public void setMehrwert(int mehrwert) {
        this.mehrwert = mehrwert;
    }
    public int getRisk() {
        return risk;
    }
    public void setRisk(int risk) {
        this.risk = risk;
    }
    public int getStrafe() {
        return strafe;
    }
    public void setStrafe(int strafe) {
        this.strafe = strafe;
    }

    // toString
    public String toString(){
        return "UserStory mit der ID " + getId();
    }

    @Override
    public int compareTo(UserStory onther){
        if(this.prio<onther.prio){
            return -1;
        }
        else if(this.prio>onther.prio){
            return 1 ;
        }
        else{
        return 0;
        }
    }
}