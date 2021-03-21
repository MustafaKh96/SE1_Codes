package org.hbrs.se.ws20.uebung2;

public class DumpTest {

    public void dumptest() throws ContainerException{
        Member a = new MemberKlasse(1);
        Member b = new MemberKlasse(2);
        Member c = new MemberKlasse(3);
        Container con = new Container() ;
        try {
            con.addMember(a);
            con.addMember(b);
            con.addMember(c);
        } catch (ContainerException e) {
            e.printStackTrace();
        }
        con.dump();
    }
    public static void main(String[] args) throws ContainerException {
        DumpTest a = new DumpTest() ;
        a.dumptest() ;
    }
}