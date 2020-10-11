package org.ghermann.learning.jwsbottomup;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@WebService(name = "GreetingServicePortType")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface GreetingServiceType {

    @WebResult(name="greeting") @XmlElement(required = true)
    String greetSimply(
        @XmlElement(required = true) @WebParam(name = "firstName") String firstName,
        @XmlElement(required = true) @WebParam(name = "lastName") String lastName
    );

    @WebResult(name="greeting") @XmlElement(required = true)
    String greetVerbosely(
        @XmlElement(required = true) @WebParam(name = "firstName") String firstName,
        @XmlElement(required = true) @WebParam(name = "lastName") String lastName
    ) throws BadNameException;


    @WebResult(name="greeting") @XmlElement(required = true)
    String greetWithTitle(
        @XmlElement(required = true) @WebParam(name = "title") Title title,
        @XmlElement(required = true) @WebParam(name = "firstName") String firstName,
        @XmlElement(required = true) @WebParam(name = "lastName") String lastName
    );

    @WebResult(name = "greeting") @XmlElement(required = true)
    String greetPerson(@XmlElement(required = true) @WebParam(name = "person") Person person);

    @WebMethod(operationName = "massGreet")
    @WebResult(name = "greetings") @XmlElement(required = true)
    List<String> greetPersons(@XmlElement(required = true) @WebParam(name = "persons") Person[] persons);
}