package org.hbrs.se.ws20.uebung2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {
    Member a,b,c,d ;
    Container con ;

    @BeforeEach
    public void setup(){
        a = new MemberKlasse(1);
        b = new MemberKlasse(2);
        c = new MemberKlasse(3);
        d = new MemberKlasse(3);
        con = new Container() ;
    }

    @AfterEach
    public void clean(){
        a = null ;
        b = null ;
        c = null ;
        con = null ;
    }

    @Test
    void addMember() throws ContainerException {
        try {
            assertEquals(0, con.size());
            con.addMember(a);
            con.addMember(b);
            assertEquals(2, con.size());
            con.addMember(c);
            assertEquals(3, con.size());
            con.addMember(a);
            assertEquals(3, con.size());
        } catch (ContainerException e) {
            e.printStackTrace();
        }
    }

    @Test
    void deleteMember(){
        try {
            con.addMember(a);
            con.addMember(b);
            con.addMember(c);
            assertEquals(3,con.size());
            con.deleteMember(1) ;
            assertEquals(2,con.size());
            con.deleteMember(3) ;
            assertEquals(1,con.size());
        } catch (ContainerException e) {
            e.printStackTrace();
        }
    }


    }