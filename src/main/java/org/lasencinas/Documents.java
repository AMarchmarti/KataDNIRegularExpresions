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

    public Boolean verify(String documents, String regex) {
        return documents.matches(regex);
    }

    public Boolean findRegex(String documents, String regex) {
        setPattern(regex);
        setMatch(documents);
        if (getMatch().find()) {
            return true;
        }
        return false;
    }
    public String nieNumber(String nie){
        if (findRegex(nie, Regex.NIEFIRSTLETTER.getRegex())){
            String letter = getMatch().group();
            String[] nieSplit = nie.split(Regex.NIEFIRSTLETTER.getRegex());
            switch (letter){
                case "X":
                    return letter.replace('X', '0') + nieSplit[1] ;

                case "Y":
                    return letter.replace('Y', '1')+ nieSplit[1];

                case "Z":
                    return letter.replace('Z', '2') + nieSplit[1] ;

                default:
                    return letter;
            }
        }
            return null;
    }

    public Integer controlNumber(String documents, String regex) {
        if (findRegex(documents, regex)) {
            Integer num = Integer.parseInt(getMatch().group());
            return num % ControlCodeDNI.values().length;
        }
        return null;
    }

    public Integer controlNumberDocument(String documents, String regex){
        if (regex == Regex.DNINUM.getRegex()){
            return controlNumber(documents, Regex.DNINUM.getRegex());
        }else if (regex == Regex.NIENUM.getRegex()){
            String nie = nieNumber(documents);
            return controlNumber(nie, Regex.DNINUM.getRegex());
        }
        return null;
    }

    public Character findCorrectLetter(String documents, String regex) {
            for (ControlCodeDNI code : ControlCodeDNI.values()) {
                if ((code.getRest() == controlNumberDocument(documents, regex))) {
                    return code.getLetter();
                }
            }
        return null;
    }

    public Boolean verifyLetter(String documents, String regex){
        if (findRegex(documents, Regex.DNINIELETTER.getRegex())){
            String letter = getMatch().group();
            Character correctLetter = findCorrectLetter(documents, regex);
            if(letter.equals(correctLetter.toString())){
                return true;
            }
        }
        return false;
    }

    public Boolean verifyDocument(String documents, String regex, String regex2){
        if (verify(documents, regex)){
           return verifyLetter(documents, regex2);
        }
        return false;
    }
}