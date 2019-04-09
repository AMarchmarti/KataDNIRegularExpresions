package org.lasencinas;

public enum Regex {

    DNI("^[0-9]{8}[^IÑOU]"),
    NIE("^[XYZ][0-9]{7}[^IÑOU]"),
    CIF("^[A-IJNP-SU-W]([0-9]{7})([0-9]|[A-Z])$"),
    DNINUM("^[0-9]{8}"),
    DNINIELETTER("[^IÑOU]$"),
    NIEFIRSTLETTER("^[XYZ]"),
    NIENUM("[0-9]{7}");

    private String regex;

    Regex(String regex){
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
