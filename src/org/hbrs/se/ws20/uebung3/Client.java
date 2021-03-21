package org.hbrs.se.ws20.uebung3;


import org.hbrs.se.ws20.uebung2.ContainerException;
import org.hbrs.se.ws20.uebung2.Member;
import org.hbrs.se.ws20.uebung2.MemberKlasse;

import java.util.List;

public class Client {
    private Container3 con;
    List<Member> liste;

    public void create() throws ContainerException {
        con = Container3.getInstance();
        con.addMember(new MemberKlasse(1));
        con.addMember(new MemberKlasse(2));
        con.addMember(new MemberKlasse(3));

        liste = con.getCurrentList();

        MemberView m= new MemberView();
        m.dump(liste);
    }
}