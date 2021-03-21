package org.hbrs.se.ws20.uebung3;

import java.io.*;
import java.util.List;

public class PersistenceStrategyStream<Member> implements PersistenceStrategy {

    // Serialisierung ist ein Mechanismus, bei dem Objekte in eine
    // Folge von Bytes verwandelt und umgekehrt daraus wieder Objekte
    // erzeugt werden.
    // Man braucht solche Mechanismen beispielsweise für das Aufrufen
    // über ein Netzwerk oder um Objekte in einer Datenbank zu speichern.
    private String LOCATION = "Objects.ser";
    private OutputStream out ;
    private ObjectInputStream ois;
    //ObjectInputStream ois : Das Einlesen von Objekten (,die als Bytefolge dargestellt sind )
    // funktioniert analog zum Schreiben, durch ois.readObject(...)
    private FileInputStream fis;
    //FileInputStream fis : ermöglicht das Lesen des Inhalts einer Datei als Bytestrom.
    private ObjectOutputStream oos;
    // ObjectOutputStream oos : Durch oos.writeObject(...) wird das Objekt
    // intern in eine Bytefolge umgewandelt und gibt diese an
    // den FileOutputStream weiter.
    private FileOutputStream fos;
    // erstellt dir Datei.
    List<Member> member ;
    public void setLOCATION(String LOCATION) {
        this.LOCATION = LOCATION;
    }
    @Override
    public void openConnection() throws PersistenceException {
        try {
            fis = new FileInputStream("UserStories.java");
            ois = new ObjectInputStream(fis);
            fos = new FileOutputStream("UserStories.java");
            oos = new ObjectOutputStream(fos);
        }
        catch (IOException e ){
            throw new  PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable, "open connection" );
            //ConnectionNotAvailable .. es könnte sein, dass wir was öffnen, was es nicht gibt.
        }
    }
    @Override
    public void closeConnection() throws PersistenceException {
        try {
            fis.close();
            ois.close();
            fos.close();
            oos.close();

        } catch (IOException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable, "Close Connention");
            //ConnectionNotAvailable .. es könnte sein, dass wir was schließen, was es nicht gibt.
        }
    }
    @Override
    public void save(List member) throws PersistenceException  {
        try {
            oos.writeObject(member);
        }
        catch (IOException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.SaveFailure, "save error");
            // SaveFailure : Fehler beim saving.
        }
    }
    @Override
    public List<Member> load() throws PersistenceException  {
        try {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) { // instanceof : Vergleichen zwei Objekte.
                member = (List) obj;
                return member;
            }
        }
        catch (IOException | ClassNotFoundException e){
            throw new PersistenceException(PersistenceException.ExceptionType.LoadFailure, "load error");
        }
        return null ;
    }
}