package org.ghermann.learning.jwsbottomup.server;

import org.ghermann.learning.jwsbottomup.BadNameException;
import org.ghermann.learning.jwsbottomup.GreetingServiceType;
import org.ghermann.learning.jwsbottomup.Person;
import org.ghermann.learning.jwsbottomup.Title;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService(serviceName="GreetingWebService", portName = "GreetingWebServicePort")
public class GreetingService implements GreetingServiceType {
    private static final int NAME_LENGTH_MAX = 100;

    @Override
    public String greetSimply(String firstName, String lastName) {
        return "Hello " + firstName + " " + lastName + "!";
    }

    @Override
    public String greetVerbosely(String firstName, String lastName) throws BadNameException {
        if (firstName.length() > NAME_LENGTH_MAX) {
            throw new BadNameException(firstName);
        }
        if (lastName.length() > NAME_LENGTH_MAX) {
            throw new BadNameException(lastName);
        }

        return "Hello " + firstName + " " + lastName + ", How do you do!";
    }

    @Override
    public String greetWithTitle(Title title, String firstName, String lastName) {
        return "Hello " + title + " " + firstName + " " + lastName + "!";
    }

    @Override
    public String greetPerson(Person person) {
        return greetWithTitle(person.getTitle(), person.getFirstName(), person.getLastName());
    }

    @Override
    public List<String> greetPersons(Person[] persons) {
        List<String> result = new ArrayList<>();
        for (var person : persons) {
            String greeting = greetWithTitle(person.getTitle(), person.getFirstName(), person.getLastName());
            result.add(greeting);
        }
        return result;
    }
}
