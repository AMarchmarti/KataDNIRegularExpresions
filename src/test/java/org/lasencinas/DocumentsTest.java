package org.lasencinas;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;


public class DocumentsTest
{
    private String [] dnis = {"78484464T","72376173A","01817200Q","95882054E","63587725Q",
                            "26861694V","21616083Q","26868974Y","40135330P","89044648X"};

    private String[] nies = {"Y6373752Y", "X2356162L", "Z8259178K", "X0565107C", "X6901377C", "Z7150522B","X1486138Q",
                                "X9399096P", "Y5060398K", "X3731561H"};

    private String[] cifs = {"R8771524I", "H39679857", "C9163827J", "A95894291", "G1925194A", "N9427139B", "U0432547H",
                                "J2385481C", "N7286889F", "P3429275E"};

    private String[] falseDNI = {"98@45184M", "3577820077Y", "8477FP439A", "57333718Ñ", "479543//1B", "9199!!!3373C",
                                    "265R", "P5349239R", "3()335275P", "X4349478G"};

    private String[] falseNies = {"46373752Y", "X2356162Ñ", "@8259178K", "X03565107C", "XL6901377C", "47150522B","X148618Q",
            "X939//9096P", "A5060398K", "X3731561O"};

    private String[] falseCifs = {"M8771524I", "T8484464T", "@9163827I", "M6373752Y", "G1925194", "9044648X", "098765",
            "ASDFGHJ", "snfduioeosr9wF", "12345678P"};

    @Test
    public void verifyDNITest()
    {
        Documents documents = new Documents();
        for (String document : dnis){
            assertTrue(documents.verify(document, Regex.DNI.getRegex()));
        }

        for (String document : falseDNI){
            assertFalse(documents.verify(document,Regex.DNI.getRegex()));
        }

    }

    @Test
    public void verifyNIETest(){
        Documents documents = new Documents();
        for (String document : nies){
            assertTrue(documents.verify(document,Regex.NIE.getRegex()));
        }

        for (String document : falseNies){
            assertFalse(documents.verify(document, Regex.NIE.getRegex()));
        }
    }

    @Test
    public void verifyCIFTest(){
        Documents documents = new Documents();
        for (String document : cifs){
            assertTrue(documents.verify(document,Regex.CIF.getRegex()));
        }

        for (String document : falseCifs){
            assertFalse(documents.verify(document,Regex.CIF.getRegex()));
        }
    }


    @Test
    public void controlNumberTest(){
        Documents documents = new Documents();
        String regex = Regex.DNINUM.getRegex();
        String dni = "78484464T";
        String dniDos = "72376173A";
        String dniTres = "01817200Q";
        assertEquals(0, documents.controlNumber(dni, regex), 0);
        assertEquals(3, documents.controlNumber(dniDos, regex), 0);
        assertEquals(16, documents.controlNumber(dniTres, regex), 0);
    }

    @Test
    public void findLetterTest(){
        Documents documents = new Documents();
        String regex = Regex.DNINUM.getRegex();
        String dni = "78484464T";
        String dniDos = "72376173A";
        String dniTres = "01817200Q";
        assertThat('T').isEqualTo(documents.findCorrectLetter(dni, regex));
        assertThat('A').isEqualTo(documents.findCorrectLetter(dniDos, regex));
        assertThat('Q').isEqualTo(documents.findCorrectLetter(dniTres, regex));
    }

    @Test
    public void verifyLetterTest(){
        Documents documents = new Documents();
        String regex = Regex.DNINUM.getRegex();
        String dni = "78484464T";
        String falseDni = "78484464O";
        assertTrue(documents.verifyLetter(dni, regex));
        assertFalse(documents.verifyLetter(falseDni, regex));
        for (String document : dnis){
            assertTrue(documents.verifyLetter(document, regex));
        }

    }

    @Test
    public void verifyDocumentsTest(){
        Documents documents = new Documents();
        for (String document : dnis){
            assertTrue(documents.verifyDocument(document, Regex.DNI.getRegex(), Regex.DNINUM.getRegex()));
        }

        for (String document : falseDNI){
            assertFalse(documents.verifyDocument(document, Regex.DNI.getRegex(), Regex.DNINUM.getRegex()));
        }

        for (String document : nies){
            assertTrue(documents.verifyDocument(document, Regex.NIE.getRegex(),Regex.NIENUM.getRegex()));
        }

        for (String document : falseNies){
            assertFalse(documents.verifyDocument(document, Regex.NIE.getRegex(), Regex.NIENUM.getRegex()));
        }
    }

    @Test
    public void nieNumberTest(){
        Documents documents = new Documents();
        String nie = "Y6373752Y";
        String nieDos = "X2356162L";
        String nieTres = "Z8259178K";
        assertEquals("16373752Y", documents.nieNumber(nie));
        assertEquals("02356162L", documents.nieNumber(nieDos));
        assertEquals("28259178K", documents.nieNumber(nieTres));
    }

    @Test
    public void controlNumberDocumentTest(){
        Documents documents = new Documents();
        String dni = "78484464T";
        String dniDos = "72376173A";
        String dniTres = "01817200Q";
        String nie = "Y6373752Y";
        String nieDos = "X2356162L";
        String nieTres = "Z8259178K";
        assertEquals(0, documents.controlNumberDocument(dni, Regex.DNINUM.getRegex()), 0);
        assertEquals(3, documents.controlNumberDocument(dniDos, Regex.DNINUM.getRegex()), 0);
        assertEquals(16, documents.controlNumberDocument(dniTres, Regex.DNINUM.getRegex()), 0);
        assertEquals(6, documents.controlNumberDocument(nie, Regex.NIENUM.getRegex()), 0);
        assertEquals(19, documents.controlNumberDocument(nieDos, Regex.NIENUM.getRegex()), 0);
        assertEquals(21, documents.controlNumberDocument(nieTres, Regex.NIENUM.getRegex()), 0);

    }

}
