package org.ghermann.learning.jaxwsbottomup.server;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService
public class GreetingWebService {
    public String greet(String firstName, String lastName) {
        return "Hello " + firstName + " " + lastName + "!";
    }

    public String greetWithTitle(String title, String firstName, String lastName) {
        return "Hello " + title + " " + firstName + " " + lastName + "!";
    }

    public List<String> massGreet(Person[] persons) {
        List<String> result = new ArrayList<>();
        for (Person person: persons) {
            String greeting = greetWithTitle(person.getTitle(), person.getFirstName(), person.getLastName());
        }
        return result;
    }
}
