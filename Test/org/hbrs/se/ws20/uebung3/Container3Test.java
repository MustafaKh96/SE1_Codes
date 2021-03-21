package org.hbrs.se.ws20.uebung3;

import org.hbrs.se.ws20.uebung2.ContainerException;
import org.hbrs.se.ws20.uebung2.Member;
import org.hbrs.se.ws20.uebung2.MemberKlasse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Container3Test {

    private Container3 container;

    @BeforeEach
    void setUp() {
        container = Container3.getInstance();
    }

    @Test
    void testNoStrategeySet() {
        try {
            container.setPersistenceStrategie(null);
            container.store();

        } catch (PersistenceException e) {
            System.out.println("Message: " + e.getMessage() );
            assertEquals( e.getMessage() , "Strategy not initialized" );
            assertEquals(  e.getExceptionTypeType() , PersistenceException.ExceptionType.NoStrategyIsSet );
        }
    }
    @Test
    void testMongoDBNotImplemented() {
        try {
            container.setPersistenceStrategie( new PersistenceStrategyMongoDB<Member>() );
            container.store();
        } catch (PersistenceException e) {
            System.out.println("Message: " + e.getMessage() );
            assertEquals( e.getMessage() , "Not implemented!" );
            assertEquals(  e.getExceptionTypeType() , PersistenceException.ExceptionType.ImplementationNotAvailable );
        }
    }
    @Test
    void testStoreAndLoad() {
        try {
            container.setPersistenceStrategie( new PersistenceStrategyStream<Member>() );
            container.addMember(new MemberKlasse(1));

            assertEquals( 1 , container.size() );
            container.store();

            container.deleteMember(1);
            assertEquals(0 , container.size() );

            container.load();
            assertEquals( 1 , container.size() );

        } catch (PersistenceException | ContainerException e) {
            System.out.println("Message: " + e.getMessage() );
        }
    }
}