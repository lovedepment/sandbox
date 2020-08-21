package org.ghermann.learning.jaxwsbottomup.server;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

@WebService(name = "GreetingServiceInterface",
            serviceName="GreetingService", portName = "GreetingServicePort")
@SOAPBinding(style = Style.DOCUMENT, parameterStyle = SOAPBinding.ParameterStyle.BARE)
public class GreetingWebService {
    private static final int NAME_LENGTH_MAX = 100;

    @WebResult(name="greeting") @XmlElement(required = true)
    @WebMethod(operationName = "greetSimply")
    public String greet(
        @XmlElement(required = true) @WebParam(name = "firstName") String firstName,
        @XmlElement(required = true) @WebParam(name = "lastName") String lastName
    ) {
        return "Hello " + firstName + " " + lastName + "!";
    }

    @WebResult(name="greeting") @XmlElement(required = true)
    public String greetVerbosely(
        @XmlElement(required = true) @WebParam(name = "firstName") String firstName,
        @XmlElement(required = true) @WebParam(name = "lastName") String lastName
    ) throws BadNameException {
        if (firstName.length() > NAME_LENGTH_MAX) {
            throw new BadNameException(firstName);
        }
        if (lastName.length() > NAME_LENGTH_MAX) {
            throw new BadNameException(lastName);
        }

        return "Hello " + firstName + " " + lastName + ", How do you do!";
    }

    @WebResult(name="greeting") @XmlElement(required = true)
    public String greetWithTitle(
        @XmlElement(required = true) @WebParam(name = "title") Title title,
        @XmlElement(required = true) @WebParam(name = "firstName") String firstName,
        @XmlElement(required = true) @WebParam(name = "lastName") String lastName
    ) {
        return "Hello " + title + " " + firstName + " " + lastName + "!";
    }

    @WebResult(name = "greeting") @XmlElement(required = true)
    public String greetPerson(@XmlElement(required = true) @WebParam(name = "person") Person person) {
        return greetWithTitle(person.getTitle(), person.getFirstName(), person.getLastName());
    }

    @WebResult(name = "greetings") @XmlElement(required = true)
    public List<String> massGreet(@XmlElement(required = true) @WebParam(name = "persons") Person[] persons) {
        List<String> result = new ArrayList<>();
        for (var person : persons) {
            String greeting = greetWithTitle(person.getTitle(), person.getFirstName(), person.getLastName());
            result.add(greeting);
        }
        return result;
    }
}
