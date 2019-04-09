package org.lasencinas;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Documents {

    //Attributes
    private Pattern pattern;
    private Matcher match;

    //Setters

    public void setPattern(String regex) {
        this.pattern = Pattern.compile(regex);
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

    public Integer controlNumber(String dni){
        setPattern(Regex.DNINUM.getRegex());
        setMatch(dni);
        if (getMatch().find()){
            Integer num = Integer.parseInt(getMatch().group());
            return num % ControlCodeDNI.values().length;}
        return null;
    }







}