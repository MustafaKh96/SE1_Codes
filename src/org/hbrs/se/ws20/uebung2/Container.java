package org.hbrs.se.ws20.uebung2;

import java.util.ArrayList;
import java.util.List;
import java.util.* ;

public class Container {

    private List<Member> liste = new ArrayList<Member>();

    public void addMember(Member a) throws ContainerException {
        Integer id = a.getID();
            for (Member z : liste) {
                if (z.getID().intValue() == id) {
                    ContainerException exc = new ContainerException(a);
                    throw exc;
                }
            }
            liste.add(a);
    }
    public String deleteMember(Integer id) {
        for (Member z : liste) {
            if (z.getID().intValue() == id) {
                liste.remove(z);
                return "Das Member_Object mit der ID(" + id + ") ist geloescht";
            }
        }
        return "Das Member_Object mit der ID(" + id + ")ist in der Liste nicht vorhanden!";
    }
    public void dump() {
        for(Member z : liste){
            System.out.println(z.toString()) ;
        }
    }
    public int size(){
        return liste.size();
    }
    public static void main(String[] args) throws ContainerException {
        Member m1 = new MemberKlasse(1) ;
        Member m2 = new MemberKlasse(2) ;
        Container c = new Container() ;
        c.addMember(m1);
        c.addMember(m2);
        System.out.println(c.size());
    }
}