package org.hbrs.se.ws20.uebung3;

import java.util.List;

public interface PersistenceStrategy <E> {
    public void openConnection() throws PersistenceException;
    public void closeConnection() throws PersistenceException;
    void save(List<E> member) throws PersistenceException;
    List<E> load() throws PersistenceException;
}