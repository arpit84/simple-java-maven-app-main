package com.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    @Test
    public void testAppInstancesReturnSameMessage() {
        App app1 = new App();
        App app2 = new App();
        assertEquals(app1.getMessage(), app2.getMessage(), "Messages from different App instances should be equal.");
    }

    @Test
    public void testAppMessage() {
        App app = new App();
        assertEquals("Hello World!", app.getMessage(), "The message should be 'Hello World!'");
    }

    @Test
    public void testBasicTrueAssertion() {
        assertTrue(true, "This test should always pass.");
    }
}
