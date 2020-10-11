package org.ghermann.learning.jwsbottomup;

import javax.xml.ws.WebFault;

@WebFault
public class BadNameException extends Exception {
    private final String name;

    public BadNameException(String name) {
        this.name = name;
    }

    @Override
    public String getMessage() {
        return "Too long first or last name:'" + name + "'";
    }
}
