package org.hbrs.se.ws20.uebung3;

import java.util.List;

public class PersistenceStrategyMongoDB<Member> implements PersistenceStrategy<Member> {
    //java.lang.UnsupportedOperationException("Not implemented!").
    //Wird ausgelöst, um anzuzeigen, dass die angeforderte Operation nicht unterstützt wird.
    @Override
    public void openConnection() throws PersistenceException {
        throw new java.lang.UnsupportedOperationException("Not implemented!");
    }
    @Override
    public void closeConnection() throws PersistenceException {
        throw new java.lang.UnsupportedOperationException("Not implemented!");
    }
    @Override
    public void save(List<Member> member) {
        throw new java.lang.UnsupportedOperationException("Not implemented!");
    }
    @Override
    public List<Member> load() {
        throw new java.lang.UnsupportedOperationException("Not implemented!");
    }
}