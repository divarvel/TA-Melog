package com.ecnmelog.model;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Tests unitaires pour la classe Attente
 */
public class AttenteTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AttenteTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AttenteTest.class );
    }


    /**
     * Test de vérification du chargement d'un container dans la zone d'attente
     */
    public void testAddContainer()
    {
        Stockage stock = new Stockage(100);
        Attente att = new Attente();
        try{
            att.addContainer(new Container(1, 2));
            att.addContainer(new Container(2, 1));
        }catch(ContainerException e){
            System.out.println(e.getMessage());
            assertTrue(false);
        }
        att.removeContainerByType(2);
        assertEquals(att.countContainers(), 1);
        assertEquals(att.countContainers(0), 0);
        assertEquals(att.countContainers(1), 1);
        assertEquals(att.countContainers(2), 0);
    }
    
    /**
     * Test qui vérifie qu'une exception est bien levée quand on essaie d'ajouter un container qui existe déjà
     */
    public void testFailContainer()
    {
        Stockage stock = new Stockage(100);
        Attente att = new Attente();
        try{
            att.addContainer(new Container(1, 2));
            att.addContainer(new Container(1, 1));
            fail();
        }catch(ContainerException e){
            assertTrue(true);
        }
    }
}
