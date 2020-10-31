package org.gubenc.learning.ws.server;

import org.gubenc.learning.ws.EmptyNameException;
import org.gubenc.learning.ws.GreetingService;

import javax.jws.WebService;

@WebService(wsdlLocation = "wsdl/GreetingDocumentService.wsdl",
            targetNamespace = "http://ws.learning.gubenc.org",
            serviceName = "GreetingDocumentWebService", portName = "GreetingEndpoint")
public class GreetingEndpoint implements GreetingService {

    @Override
    public String sayHello(String title, String firstName, String lastName) throws EmptyNameException {
        if (title.isBlank() || firstName.isBlank() || lastName.isBlank()) {
            throw new EmptyNameException();
        }

        return "Hello " + title + " " + firstName + " " + lastName;
    }
}
