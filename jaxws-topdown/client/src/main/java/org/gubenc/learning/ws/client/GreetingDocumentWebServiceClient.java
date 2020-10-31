package org.gubenc.learning.ws.client;

import org.gubenc.learning.ws.EmptyNameException;
import org.gubenc.learning.ws.GreetingDocumentWebService;
import org.gubenc.learning.ws.GreetingService;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;

public class GreetingDocumentWebServiceClient {
    private static final String SERVICE_URL_VARIABLE = "SERVICE_URL";
    private static final String SERVICE_NAMESPACE = "http://ws.learning.gubenc.org";
    private static final String SERVICE_NAME = "GreetingDocumentWebService";

    public static void main(String[] args) throws MalformedURLException {
        try {
            URL serviceUrl = new URL(System.getenv(SERVICE_URL_VARIABLE));
            QName qname = new QName(SERVICE_NAMESPACE, SERVICE_NAME);
            GreetingDocumentWebService greetingWebervice = new GreetingDocumentWebService(serviceUrl, qname);
            GreetingService greetingPort = greetingWebervice.getGreetingEndpoint();
            String greeting = greetingPort.sayHello("Mr", "James", "Bond");
            System.err.println("Greeting: " + greeting);
        } catch (EmptyNameException ex) {
            ex.printStackTrace(System.err);
        }
    }
}
