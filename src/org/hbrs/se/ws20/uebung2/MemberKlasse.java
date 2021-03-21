package org.hbrs.se.ws20.uebung2;

public class MemberKlasse implements Member{
    private Integer id ;
    public MemberKlasse(Integer id){
        this.id = id ;
    }
    @Override
    public Integer getID(){
        return this.id ;
    }
    @Override
    public String toString(){
        String erg = "Das Member mit (ID = " + this.id +")" ;
        return erg ;
    }
}