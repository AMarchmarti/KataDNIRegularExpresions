package org.lasencinas;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;


public class DNITest
{
    private static final String REGEXDNI = "^[0-9]{8}[^IÑU]";
    private static final String REGEXNIE = "^[XYZ][0-9]{7}[^IÑU]";
    private String [] dnis = {"78484464T","72376173A","01817200Q","95882054E","63587725Q",
                            "26861694V","21616083Q","26868974Y","40135330P","89044648X"};
    private String[] nies = {"Y6373752Y", "X2356162L", "Z8259178K", "X0565107C", "X6901377C", "Z7150522B","X1486138Q",
                                "X9399096P", "Y5060398K", "X3731561H"};
    @Test
    public void verifyDNITest()
    {
        DNI dni = new DNI();
        for (String document : dnis){
            assertTrue(dni.verify(document, REGEXDNI));
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
