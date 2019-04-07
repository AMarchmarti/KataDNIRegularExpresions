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
    @Test
    public void verifyDNITest()
    {
        DNI dni = new DNI();
        for (String document : dnis){
            assertTrue(dni.verify(document, REGEXDNI));
        }

    }
}
