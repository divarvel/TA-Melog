package com.ecnmelog.app;

import java.sql.*;

public class DbConn{
	/** Instance unique de la classe à la base de données*/
	private static final DbConn INSTANCE = new DbConn();
	
	/** Connexion à la base de données*/
	private Connection conn;

	/** Initialisation de la connexion à la base de données*/
	private DbConn(){
		try{
			Class.forName("org.sqlite.JDBC");
			this.conn = DriverManager.getConnection("jdbc:sqlite:stockage.db");
		}catch(ClassNotFoundException e){
			System.out.println("Driver introuvable !");
		}
		catch(SQLException e){
			System.out.println("Erreur SQL !");
		}
		catch(Exception e){
			System.out.println("Erreur inattendue");
		}
	}

	/** Renvoie l'instance unique de la connexion*/
	public static Connection getInstance() {
		return INSTANCE.conn;
	}
	
}
