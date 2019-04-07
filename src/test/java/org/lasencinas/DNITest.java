package org.lasencinas;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class DNITest
{
    private String [] dnis = {"78484464T","72376173A","01817200Q","95882054E","63587725Q",
                            "26861694V","21616083Q","26868974Y","40135330P","89044648X"};

    @BeforeClass
    public static void creationTest(){
        DNI dni = new DNI();
    }
    @Test
    public void verifyDNITest()
    {
        for (String document : dnis){
            assertTrue(dni.verify(document));
        }

    }
}
