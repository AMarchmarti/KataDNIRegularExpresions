package org.lasencinas;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;


public class DNITest
{
    private static final String REGEXDNI = "^[0-9]{8}[^IÑOU]";
    private static final String REGEXNIE = "^[XYZ][0-9]{7}[^IÑOU]";

    private String [] dnis = {"78484464T","72376173A","01817200Q","95882054E","63587725Q",
                            "26861694V","21616083Q","26868974Y","40135330P","89044648X"};

    private String[] nies = {"Y6373752Y", "X2356162L", "Z8259178K", "X0565107C", "X6901377C", "Z7150522B","X1486138Q",
                                "X9399096P", "Y5060398K", "X3731561H"};

    private String[] falseDNI = {"98@45184M", "3577820077Y", "8477FP439A", "57333718Ñ", "479543//1B", "9199!!!3373C",
                                    "265R", "P5349239R", "3()335275P", "X4349478G"};
    @Test
    public void verifyDNITest()
    {
        DNI dni = new DNI();
        for (String document : dnis){
            assertTrue(dni.verify(document, REGEXDNI));
        }

        for (String document : falseDNI){
            assertFalse(dni.verify(document,REGEXDNI));
        }

    }

    @Test
    public void verifyNIETest(){
        DNI dni = new DNI();
        for (String document : nies){
            assertTrue(dni.verify(document, REGEXNIE));
        }
    }
}
