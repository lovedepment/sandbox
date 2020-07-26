package org.ghermann.learning.jaxwsbottomup.server;

import javax.jws.WebService;

@WebService
public class GreetingWebService {
    private static final String WELCOME_MESSAGE = "Welcome to Budapest1";

    public String greet(String firstName, String lastName) {
        return "Hello " + firstName + " " + lastName + "!";
    }

    public String greetDetailed(String firstName, String lastName) {
        return greet(firstName, lastName) + "\n"
            + WELCOME_MESSAGE + "\n";
    }

    public String greetWithTitle(String title, String firstName, String lastName) {
        return "Hello " + title + " " + firstName + " " + lastName + "!";
    }

    public String greetWithTitleDetailed(String title, String firstName, String lastName) {
        return greetWithTitle(title, firstName, lastName)  + "\n"
            + WELCOME_MESSAGE + "\n";
    }
}
