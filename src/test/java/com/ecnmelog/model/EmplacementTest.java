package com.ecnmelog.model;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Tests unitaires pour la classe Stockage
 * @author Benjamin Vialle
 */
public class EmplacementTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public EmplacementTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( StockageTest.class );
    }
	
	public void testgetId(){
		
		Emplacement e1 = new Emplacement(0);
		Emplacement e2 = new Emplacement(1);
		Emplacement e3 = new Emplacement(2);
		
		assertEquals(1,e1.getId());
		assertEquals(2,e2.getId());
		assertEquals(3,e2.getId());
	}
	
	public void testgetType(){
		Emplacement e1 = new Emplacement(0,0);
		Emplacement e2 = new Emplacement(1,1);
		Emplacement e3 = new Emplacement(2,2);
		
		assertEquals(0,e1.getType());
		assertEquals(1,e2.getType());
		assertEquals(2,e3.getType());
	}
	
}
