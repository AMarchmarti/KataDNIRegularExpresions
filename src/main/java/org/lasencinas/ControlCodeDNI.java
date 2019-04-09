package org.lasencinas;

public enum ControlCodeDNI {

    ZERO('T', 0), ONE('R', 1),	TWO('W', 2), THREE('A', 3),
    FOUR('G', 4), FIVE('M', 5),	SIX('Y', 6), SEVEN('F', 7),
    EIGHT('P', 8), NINE('D', 9), TEN('X', 10), ELEVEN('B', 11),
    TWELVE('N', 12), THIRTEEN('J', 13),	FOURTEEN('Z', 14),
    FIFTEEN('S', 15), SIXTEEN('Q', 16), SEVENTEEN('V',17),
    EIGHTEEN('H', 18), NINETEEN('L', 19), TWENTY('C', 20),
    TWENTYONE('K', 21), TWENTYTWO('E', 22);


    private Integer code;
    private Character letter;


    ControlCodeDNI(Character letter, Integer code){
        this.code = code;
        this.letter = letter;
    }

    public Character getLetter() {
        return letter;
    }

    public Integer getRest() {
        return code;
    }

}
