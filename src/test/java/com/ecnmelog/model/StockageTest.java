package com.ecnmelog.model;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Tests unitaires pour la classe Stockage
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
        assertEquals(100, stock.countEmplacementsDispo());
        assertEquals(5, stock.countEmplacementsDispo(1));
        assertEquals(65, stock.countEmplacementsDispo(2));
        assertEquals(30, stock.countEmplacementsDispo(0));
    }
    
    
    /**
     * Test de vérification de la méthode de stockage des containers
     */
    public void testStoreContainer()
    {
      
      Stockage stock = new Stockage(100);
      Attente att = new Attente();
      try{
        att.addContainer(new Container(1, 0));
        att.addContainer(new Container(2, 1));
        att.addContainer(new Container(3, 1));
        att.addContainer(new Container(4, 1));
        att.addContainer(new Container(5, 1));
      }catch(ContainerException e){
        System.out.println(e.getMessage());
      }
      try{
        stock.storeContainer(1, 1);
        stock.storeContainer(2, 31);
      }
      catch(ContainerException e)
      {
        System.out.println(e.getMessage());
      }
      catch(EmplacementException e)
      {
        System.out.println(e.getMessage());
      }
      assertEquals(3, att.countContainers());
      assertEquals(2, stock.countContainers());
      assertEquals(1, stock.countContainers(1));
      assertEquals(0, stock.countContainers(2));
    }
}
