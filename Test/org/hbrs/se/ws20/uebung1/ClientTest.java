package org.hbrs.se.ws20.uebung1;
import org.hbrs.se.ws20.uebung1.view.Client;

public class ClientTest {
    public static void main(String[] args) {
        Client clientObj = new Client();
        //Zwei positive Tests
        clientObj.display( 6 );
        clientObj.display( 3 );
        //Zwei Negative Tests
        clientObj.display( -6 );
        clientObj.display( 16 );

    }
}