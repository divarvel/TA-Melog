package com.ecnmelog.model;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;

/**
 * Tests unitaires pour la classe Container
 */
public class ContainerTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ContainerTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ContainerTest.class );
    }

    /**
     * Test de vérification du bon fonctionnement de l'objet container
     */
    public void testInit()
    {
        Container container = new Container(1);
        Container containerFrigo = new Container(2, 1);
        
        assertEquals(0, container.getType());
        assertEquals(1, container.getId());
        assertEquals(1, containerFrigo.getType());
        assertEquals(2, containerFrigo.getId());
    }
    
    /**
     * Test de vérification de la méthode statique qui renvoie les types disponibles
     */
    public void testGetTypes()
    {
        try {
        Stockage stock = new Stockage(100);
        Attente att = new Attente();
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("------"+e.getMessage());
        } 
        ArrayList<Integer> typesAttendus = new ArrayList<Integer>();
        typesAttendus.add(0);
        typesAttendus.add(1);
        typesAttendus.add(2);
        
        ArrayList<Integer> types = Container.getTypes();
        
        assertEquals(typesAttendus, types);
    }
}
