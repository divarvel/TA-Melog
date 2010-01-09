package com.ecnmelog.app;


/**
 * Classe de définition des containers
 * @author Clément Delafargue
 */
public class Container
{
	/** 
	 * Type du container.
	 * O pour un container lambda
	 * 1 pour un container surtarifé
	 * 2 pour un container frigorifique
	 */
	protected int type = 0;
	
	/** Identifiant du container */
	protected int id = 0;
	
	/**
	 * Initialise un container lambda
	 * @param id L'identifiant du container
	 * */
	public Container(int id){
		this.id = id;
	}
	
	/**
	 * Initialise un container du type demandé
	 * @param id L'identifiant du container
	 * @param type Le type de container
	 */
	public Container(int id, int type){
		this.id = id;
		this.type = type;
	}
	
	/**
	 * Renvoie l'identifiant du container
	 * @return l'identifiant du container
	 */
	public int getId(){
		return this.id;
	}
	
	/**
	 * Renvoie le type du container
	 * @return le type du container
	 */
	public int getType(){
		return this.type;
	}
	
	/**
	 * Renvoie le container en ASCII Art
	 */
	public String toString(){
		String retour = new String();
		switch(this.type){
			case 2:
				retour = "[__F__]";
				break;
			case 1:
				retour = "[__P__]";
				break;
			default:
				retour = "[_____]";
				break;
				
			}
		return retour;
	}
}
