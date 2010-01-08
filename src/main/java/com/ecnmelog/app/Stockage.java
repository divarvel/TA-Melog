package com.ecnmelog.app;

import java.util.*;
import java.sql.*;

/**
 * Classe du système de stockage de container
 * @author Clément Delafargue
 */
public class Stockage
{
	/** Containers en attente d'être stockés*/
	protected Vector<Container> attente;
	
	/** Containers stockés*/
	protected Vector<Container> stockage;
	
	/** Contenance de l'espace de stockage*/
	protected int contenance;
	
	/** Nombre d'emplacements frigorifiques disponibles */
	protected int nbEmplacementsFrigoDispo;
	
	/** Nombre d'empacements sur-tarifés disponibles */
	protected int nbEmplacementsSurtarifesDispo;
	
	/** Nombre d'empacements normaux disponibles */
	protected int nbEmplacementsNormauxDispo;
	
	
	/**
	 * Initialise un espace de stockage 
	 * @param contenance Contenance de la zone de stockage
	 */
	public Stockage(int contenance){
		// Initialisation des espaces de stockage
		this.attente = new Vector<Container>();
		this.stockage = new Vector<Container>();
		
		// Initialisation des nombres d'emplacements libres
		this.contenance = contenance;
		
		// Un emplacement sur 20 est frigorifique
		this.nbEmplacementsFrigoDispo = (int) contenance / 20;
		
		// 65% des emplacements sont sur-tarifés
		this.nbEmplacementsSurtarifesDispo = (int) (this.contenance * 0.65);
		
		// Le reste est normal
		this.nbEmplacementsNormauxDispo = this.contenance - this.nbEmplacementsFrigoDispo - this.nbEmplacementsSurtarifesDispo;
		
		
		Connection conn = DbConn.getInstance();
		
		try{
			Statement stat = conn.createStatement();
			// On vide le schéma (si on reconstruit l'espace de stockage alors qu'il existe déjà, ça évite des bugs)
			stat.executeUpdate("DROP TABLE IF EXISTS type;");
			stat.executeUpdate("DROP TABLE IF EXISTS container;");
			stat.executeUpdate("DROP TABLE IF EXISTS emplacement;");
			
			// On initialise le schéma (les tables disparaissent à la fermeture de la connexion)
			stat.executeUpdate("CREATE TEMPORARY TABLE type (type_id INTEGER, type_nom, type_couleur, PRIMARY KEY(type_id ASC));");
			stat.executeUpdate("CREATE TEMPORARY TABLE container (container_id INTEGER, type_id INTEGER REFERENCES type (type_id) ON DELETE CASCADE, emplacement_id INTEGER REFERENCES emplacement (emplacement_id) ON DELETE SET NULL, PRIMARY KEY(container_id ASC));");
			stat.executeUpdate("CREATE TEMPORARY TABLE emplacement (emplacement_id INTEGER, type_id INTEGER REFERENCES type (type_id) ON DELETE CASCADE, PRIMARY KEY(emplacement_id ASC));");

			// On crée les 3 types de containers / emplacements
			PreparedStatement types = conn.prepareStatement("INSERT INTO type (type_id, type_nom, type_couleur) VALUES (?, ?, ?);");

				types.setInt(1, 0);
				types.setString(2, "Normal");
				types.setString(3, "0xFFFFFF");
				types.addBatch();
				types.setInt(1, 1);
				types.setString(2, "Frigo");
				types.setString(3, "0x0000FF");
				types.addBatch();
				types.setInt(1, 2);
				types.setString(2, "Prioritaire");
				types.setString(3, "0xFF0000");
				types.addBatch();

				conn.setAutoCommit(false);
				types.executeBatch();
				conn.setAutoCommit(true);
				
			// On crée les différents emplacements
			PreparedStatement emplacements = conn.prepareStatement("INSERT INTO emplacement (type_id) VALUES (?);");
				
				for(int i=0; i<this.nbEmplacementsNormauxDispo; i++){
					emplacements.setInt(1, 0);
					emplacements.addBatch();
				}
				for(int i=0; i<this.nbEmplacementsFrigoDispo; i++){
					emplacements.setInt(1, 1);
					emplacements.addBatch();
				}
				for(int i=0; i<this.nbEmplacementsSurtarifesDispo; i++){
					emplacements.setInt(1, 2);
					emplacements.addBatch();
				}

				conn.setAutoCommit(false);
				emplacements.executeBatch();
				conn.setAutoCommit(true);
		}
		catch(SQLException e){
			System.out.println("Impossible de créer l'espace de stockage !");
		}
	}
	
	/**
	 * Renvoie le nombre d'emplacements libres (tous types confondus) 
	 * @return Nombre d'emplacements libres
	 */
	public int getNbEmplacementsDispo(){
		return this.nbEmplacementsNormauxDispo + this.nbEmplacementsFrigoDispo + this.nbEmplacementsSurtarifesDispo;
	}
	
	/**
	 * Renvoie le nombre d'emplacements normaux libres
	 * @return Nombre d'emplacements libres
	 */
	public int getNbEmplacementsNormauxDispo(){
		return this.nbEmplacementsNormauxDispo;
	}
	
	/**
	 * Renvoie le nombre d'emplacements frigorifiques libres 
	 * @return Nombre d'emplacements libres
	 */
	public int getNbEmplacementsFrigoDispo(){
		return this.nbEmplacementsFrigoDispo;
	}
	
	/**
	 * Renvoie le nombre d'emplacements frigorifiques libres 
	 * @return Nombre d'emplacements libres
	 */
	public int getNbEmplacementsSurtarifesDispo(){
		return this.nbEmplacementsSurtarifesDispo;
	}
	
	
	/**
	 * Ajoute un container à la zone d'attente
	 * @param container Le container à ajouter à la zone d'attente
	 */
	public void addContainer(Container container){
		this.attente.addElement(container);
	}
	
	/**
	 * Traite les containers en attente. Stocke les containers qui peuvent l'être, laisse les autres dans la zone de stockage
	 */
	public void traiterAttente(){
		// C'est là qu'est le gros du travail ;-)
	}
	
	/**
	 * Retire un container de la zone de stockage (on retire préférentiellement les containers placés sur des emplacements non prévus pour eux)
	 * @param type Type du container à enlever.
	 */
	public void removeContainer(int type){
		
	}
}
