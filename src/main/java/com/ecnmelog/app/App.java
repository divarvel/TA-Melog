package com.ecnmelog.app;

/**
 * Classe principale de l'application
 */
public class App 
{
	/**
	 * Méthode principale de l'application
	 */
	public static void main( String[] args )
	{
		Stockage stock = new Stockage(100);
		stock.addContainer(new Container(1));
	}
}
