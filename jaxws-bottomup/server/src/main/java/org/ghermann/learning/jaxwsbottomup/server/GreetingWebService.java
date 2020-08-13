package org.ghermann.learning.jaxwsbottomup.server;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;

@WebService(name = "GreetingServiceInterface",
            serviceName="GreetingService", portName = "GreetingServicePort")
@SOAPBinding(style = Style.DOCUMENT, parameterStyle = ParameterStyle.BARE)
public class GreetingWebService {
    private static final int NAME_LENGTH_MAX = 100;

    @WebResult(name="greeting")
    public String greet(
        @WebParam(name = "firstName") String firstName,
        @WebParam(name = "lastName") String lastName
    ) {
        return "Hello " + firstName + " " + lastName + "!";
    }

    @WebResult(name="greeting")
    public String greetVerbosely(
        @WebParam(name = "firstName") String firstName,
        @WebParam(name = "lastName") String lastName
    ) throws BadNameException {
        if (firstName.length() > NAME_LENGTH_MAX) {
            throw new BadNameException(firstName);
        }
        if (lastName.length() > NAME_LENGTH_MAX) {
            throw new BadNameException(lastName);
        }

        return "Hello " + firstName + " " + lastName + ", How do you do!";
    }

    @WebResult(name="greeting")
    @WebMethod(operationName = "greetPersonUsingTitle")
    public String greetWithTitle(
        @WebParam(name = "title") Title title,
        @WebParam(name = "firstName") String firstName,
        @WebParam(name = "lastName") String lastName
    ) {
        return "Hello " + title + " " + firstName + " " + lastName + "!";
    }

    @WebResult(name = "greeting")
    public String greetPerson(@WebParam(name = "person") Person person) {
        return greetWithTitle(person.getTitle(), person.getFirstName(), person.getLastName());
    }
}
