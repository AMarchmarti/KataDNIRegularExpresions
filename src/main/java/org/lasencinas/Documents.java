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

    public Boolean verify(String dni, String regex) {
        return dni.matches(regex);
    }

    public Boolean findRegex(String dni, String regex) {
        setPattern(regex);
        setMatch(dni);
        if (getMatch().find()) {
            return true;
        }
        return false;
    }


    public Integer controlNumber(String dni, String regex) {
        if (findRegex(dni, regex)) {
            Integer num = Integer.parseInt(getMatch().group());
            return num % ControlCodeDNI.values().length;
        }
        return null;
    }

    public Character findCorrectLetter(String dni, String regex) {
            for (ControlCodeDNI code : ControlCodeDNI.values()) {
                if ((code.getRest() == controlNumber(dni, regex))) {
                    return code.getLetter();
                }
            }
        return null;
    }

    public Boolean verifyLetter(String dni, String regex){
        if (findRegex(dni, Regex.DNINIELETTER.getRegex())){
            String letter = getMatch().group();
            Character correctLetter = findCorrectLetter(dni, regex);
            if(letter.equals(correctLetter.toString())){
                return true;
            }
        }
        return false;
    }
}