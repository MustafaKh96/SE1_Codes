package org.hbrs.se.ws20.uebung3;

public class PersistenceException extends Exception {
    private ExceptionType exceptionType;

    public ExceptionType getExceptionTypeType() {
        return this.exceptionType;
    }

    public PersistenceException( ExceptionType exceptionType, String message) {
        super(message);
        this.exceptionType = exceptionType;
    }
    public enum ExceptionType {
        ImplementationNotAvailable, ConnectionNotAvailable, NoStrategyIsSet, SaveFailure, LoadFailure
    }
}