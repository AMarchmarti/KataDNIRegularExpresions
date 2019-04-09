package org.lasencinas;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class ControlCodeTest {

    public static String[] controlCode;


    @BeforeClass
    public static void creationEnumType() {
        controlCode = new String[23];
        int codes = 0;
        for (ControlCodeDNI code : ControlCodeDNI.values()) {
            controlCode[code.ordinal()] = code.name();
            codes += 1;
        }
        assertThat(codes).isEqualTo(ControlCodeDNI.values().length);
        assertEquals(23, ControlCodeDNI.values().length);
    }

    @Test
    public void controlCodeConstructorTest() {
        ControlCodeDNI code = ControlCodeDNI.FIFTEEN;
        assertThat(code).isInstanceOf(ControlCodeDNI.class);
        assertThat(code.ordinal()).isEqualTo(15);
        assertThat(code.equals(code.FIFTEEN)).isEqualTo(true);
        assertThat(code.values()[15]).isEqualTo(code);
    }

    @Test
    public void ControlCodeLetterTest() {
        ControlCodeDNI code = ControlCodeDNI.TWENTY;
        assertThat(code.getLetter()).isEqualTo('C');
    }

    @Test
    public void ControlCodeRestTest() {
        ControlCodeDNI code = ControlCodeDNI.TWENTY;
        assertThat(code.getRest()).isEqualTo(20);
    }

}
