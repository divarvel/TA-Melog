package com.ecnmelog.app;


import java.sql.*;
import com.ecnmelog.view.Interface;

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
		
		Interface fenetre = new Interface();
		
		// Fin du programme, on ferme la connexion à la DB
		try{
			DbConn.getInstance().close();
		}
		catch(SQLException e){
			System.out.println("Erreur SQL");
		}

	}
}
