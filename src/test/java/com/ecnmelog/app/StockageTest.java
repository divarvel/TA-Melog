package com.ecnmelog.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class StockageTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public StockageTest( String testName )
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

    /**
     * Test de vérification d'initialisation des emplacements
     */
    public void testInitEmplacement()
    {
        Stockage stock = new Stockage(100);
        Attente att = new Attente();
        assertEquals(100, stock.getNbEmplacementsDispo());
        assertEquals(5, stock.getNbEmplacementsFrigoDispo());
        assertEquals(65, stock.getNbEmplacementsSurtarifesDispo());
        assertEquals(30, stock.getNbEmplacementsNormauxDispo());
    }
    
    /**
     * Test de vérification du chargement d'un container dans la zone d'attente
     */
    public void testAddContainer()
    {
        Stockage stock = new Stockage(100);
        Attente att = new Attente();
        att.addContainer(new Container(1, 2));
        att.addContainer(new Container(2, 1));
        att.removeContainerByType(2);
        System.out.println(att.countContainers());
        assertEquals(att.countContainers(), 1);
        assertEquals(att.countContainersByType(0), 0);
        assertEquals(att.countContainersByType(1), 1);
        assertEquals(att.countContainersByType(2), 0);
    }
}
