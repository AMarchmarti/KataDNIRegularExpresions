package org.lasencinas;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class ControlCodeTest {

    public static String[] controlCode;


    @Test
    public  void creationEnumType() {
        controlCode = new String[23];
        int codes = 0;
        for (ControlCodeDNI code : ControlCodeDNI.values()) {
            controlCode[code.ordinal()] = code.name();
            codes += 1;
        }
        assertThat(codes).isEqualTo(ControlCodeDNI.values().length);
    }
}
