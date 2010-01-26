package com.ecnmelog.model;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;

/**
 * Tests unitaires pour la classe Container
 * @author Benjamin Vialle
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
	
	public void testgetEmplacement(){
        Stockage stock = new Stockage(100);
        Attente att = new Attente();
        Container container = new Container(1);
        Container containerFrigo = new Container(2, 1);
		
		//Pas d'emplacement
		assertEquals(container.getEmplacement(),0);				
		assertEquals(containerFrigo.getEmplacement(),0);
	}
	
	public void testgetId(){
        Stockage stock = new Stockage(100);
        Attente att = new Attente();
        Container container = new Container(1);
        Container containerFrigo = new Container(2, 1);
		
		//On teste les IDs
		assertEquals(container.getId(),1);				
		assertEquals(containerFrigo.getId(),2);
	}
	
		public void testgetType(){
        Stockage stock = new Stockage(100);
        Attente att = new Attente();
        Container container = new Container(1);
        Container containerFrigo = new Container(2, 1);
		Container containerSurTarife = new Container(3, 2);
		
		//On teste les types
		assertEquals(container.getType(),0);				
		assertEquals(containerFrigo.getType(),1);
		assertEquals(containerSurTarife.getType(),2);
	}
	
	
	
	
	
}
