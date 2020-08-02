package org.ghermann.learning.jaxwsbottomup.server;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum(Byte.class)
public enum Title {

    @XmlEnumValue("0") MR,
    @XmlEnumValue("1") MS,
    @XmlEnumValue("2") MRS,
    @XmlEnumValue("42") DON;

    public String toString() {
        switch (this) {
            case MR: return "Mr.";
            case MS: return "Ms.";
            case MRS: return "Mrs.";
            case DON: return "Don";
            default : throw new AssertionError();
        }
    }
}
