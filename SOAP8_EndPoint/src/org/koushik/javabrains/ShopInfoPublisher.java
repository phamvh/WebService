package org.koushik.javabrains;

import javax.xml.ws.Endpoint;

/**
 * This class shows how to publish a webservice by just using JDK (not use glassfish or any server).
 * This is because JDK is also bundled with Metro, which handles publishing.
 * Note that Glassfish is also bundled with Metro as well, that's why glassfish can publish web services.
 */
public class ShopInfoPublisher {
    public static void main(String[] args) {
        System.out.println("Launching...");
        //The last part of the URL in here can be anything, such as "shopinformation". Make sure the port is not used.
        //Access this by typing: http://localhost:1234/shopinformation?wsdl
        Endpoint.publish("http://localhost:1234/shopinformation",new ShopInfo());
    }
}
