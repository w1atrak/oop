package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    void testingInvalidArgumentFor_parseMethod() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new OptionsParser().parse(new String[]{"f","ba"}));
        assertEquals("ba is not a valid argument", exception.getMessage());
    }
    @Test
    void testingValidArgumentFor_parseMethod(){
        assertDoesNotThrow(() -> new OptionsParser().parse(new String[]{"f","b"}));
    }

}