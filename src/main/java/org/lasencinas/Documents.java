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
    public String nieNumber(String dni){
        if (findRegex(dni, Regex.NIEFIRSTLETTER.getRegex())){
            String letter = getMatch().group();
            String[] dniSplit = dni.split(Regex.NIEFIRSTLETTER.getRegex());
            switch (letter){
                case "X":
                    return letter.replace('X', '0') + dniSplit[1] ;

                case "Y":
                    return letter.replace('Y', '1')+ dniSplit[1];

                case "Z":
                    return letter.replace('Z', '2') + dniSplit[1] ;

                default:
                    return letter;
            }
        }
            return null;
    }

    public Integer controlNumber(String dni, String regex) {
        if (findRegex(dni, regex)) {
            Integer num = Integer.parseInt(getMatch().group());
            return num % ControlCodeDNI.values().length;
        }
        return null;
    }

    public Integer controlNumberDocument(String dni, String regex){
        if (regex == Regex.DNINUM.getRegex()){
            return controlNumber(dni, Regex.DNINUM.getRegex());
        }else if (regex == Regex.NIENUM.getRegex()){
            String nie = nieNumber(dni);
            return controlNumber(nie, Regex.DNINUM.getRegex());
        }
        return null;
    }

    public Character findCorrectLetter(String dni, String regex) {
            for (ControlCodeDNI code : ControlCodeDNI.values()) {
                if ((code.getRest() == controlNumberDocument(dni, regex))) {
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

    public Boolean verifyDocument(String dni, String regex, String regex2){
        if (verify(dni, regex)){
           return verifyLetter(dni, regex2);
        }
        return false;
    }
}