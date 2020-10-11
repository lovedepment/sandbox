package org.ghermann.learning.jwsbottomup;

public enum Title {
     MR,
     MS,
     MRS,
     DON;

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
