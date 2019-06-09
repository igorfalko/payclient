package gpb.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContextServiceTest {
    @Test
    public void testCtx() {
        String[] validArgs = new String[]{"offices.txt", "10000", "http://localhost:8080/pay", "payments.txt"};
        ContextService ctx_valid = new ContextService(validArgs);
        assertTrue(ctx_valid.isValid());
        assertEquals(ctx_valid.getOfficesFileName(), "offices.txt");
        assertEquals(ctx_valid.getN(), 10000);
        assertEquals(ctx_valid.getUrl(), "http://localhost:8080/pay");
        assertEquals(ctx_valid.getPaymentsFileName(), "payments.txt");

        String[] notValidArgs_1 = new String[]{"10000", "http://localhost:8080/pay", "payments.txt"};
        ContextService ctx_notValid = new ContextService(notValidArgs_1);
        assertFalse(ctx_notValid.isValid());
        assertNull(ctx_notValid.getOfficesFileName());
        assertEquals(ctx_notValid.getN(), 0);
        assertNull(ctx_notValid.getUrl());
        assertNull(ctx_notValid.getPaymentsFileName());
    }

}