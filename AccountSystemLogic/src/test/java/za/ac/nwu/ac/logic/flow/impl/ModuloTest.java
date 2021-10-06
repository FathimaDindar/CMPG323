package za.ac.nwu.ac.logic.flow.impl;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class ModuloTest {

    private Modulo mod;

    @Before
    public void setUp() throws Exception {
        mod = new Modulo();
    }

    @Ignore
    @Test
    public void testMod() throws Exception {
        Integer result = mod.doMod(9, 5);
        assertNotNull("Should Not Be Null",result);
        assertEquals("Should be value 4", 4, result.intValue());
    }

    @Ignore
    @Test
    public void testModBy0() throws Exception {
        Integer result = mod.doMod(16, 0);
        assertNull("Should Not Be Null",result);
    }

    @Ignore
    @Test(expected = RuntimeException.class)
    public void testModByException() throws Exception {
        mod.doMod(16, 0);
        fail("Should throw an exception.");
    }
}
