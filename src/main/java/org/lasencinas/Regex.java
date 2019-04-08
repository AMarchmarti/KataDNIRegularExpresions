package org.lasencinas;

public enum Regex {

    DNI("^[0-9]{8}[^IÑOU]"),
    NIE("^[XYZ][0-9]{7}[^IÑOU]"),
    NIF("^[KLM][0-9]{7}[^IÑOU]");

    private String regex;

    Regex(String regex){
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
