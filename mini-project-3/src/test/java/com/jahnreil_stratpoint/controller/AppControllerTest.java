package com.jahnreil_stratpoint.controller;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppControllerTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppControllerTest(String testName )
    {
        super( testName );
    }

    /**
     * Suite test.
     *
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppControllerTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
