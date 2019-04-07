package org.lasencinas;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DNI{

    //Attributes
    private Pattern pattern = null;
    private Matcher match = null;

    //Setters

    public void setPattern(String regex) {
        this.pattern.compile(regex);
    }

    public void setMatch(String dni) {
        this.match = getPattern().matcher(dni);
    }

    //Getters

    public Pattern getPattern() {
        return pattern;
    }

    public Matcher getMatch() {
        return match;
    }

    //Logic

    public Boolean verify(String dni, String regex){
        return dni.matches(regex);
    }
}