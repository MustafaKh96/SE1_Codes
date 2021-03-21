package org.hbrs.se.ws20.uebung3;
import org.hbrs.se.ws20.uebung2.Container;
import org.hbrs.se.ws20.uebung2.ContainerException;
import org.hbrs.se.ws20.uebung2.Member;
import org.hbrs.se.ws20.uebung2.MemberKlasse;
import java.util.ArrayList;
import java.util.List;



public class Container3 {
    private static Container3 instance = null;
    private PersistenceStrategy strategy = null;
    private List<Member> liste = new ArrayList<Member>();

    private Container3() {
    }
    public static synchronized Container3 getInstance(){
        if(instance==null){
            instance= new Container3();
            System.out.println("Objekt vom Typ Container wurde instanziiert!");
        }
        return instance;
    }

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
    private boolean contains(Member r) {
        Integer ID = r.getID();
        for ( Member rec : liste) {
            if ( rec.getID() == ID ) {
                return true;
            }
        }
        return false;
    }
    private Member find(Integer id) {
        for ( Member rec : liste) {
            if (id == rec.getID().intValue() ){
                return rec;
            }
        }
        return null;
    }

    public void setPersistenceStrategie(PersistenceStrategy persistenceStrategy) {
        //persistenceStrategy = newpersistenceStrategyStream.
        this.strategy = persistenceStrategy;
    }
    public void store() throws PersistenceException {
        if (this.strategy == null) {
            throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet,
                    "Strategy not initialized");
        } else {
            strategy.openConnection();
            strategy.save(this.liste);
            strategy.closeConnection();
        }
    }
    public void load() throws PersistenceException {
        if (this.strategy == null) {
            throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet, "Strategy not initialized");
        }
        else{
        strategy.openConnection();
        List<Member> liste = strategy.load();
        this.liste = liste; // MayBe merge
        }
    }
    public List getCurrentList() {
        return this.liste;
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