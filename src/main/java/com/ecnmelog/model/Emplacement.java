package com.ecnmelog.model;

/**
 * Classe de définition des emplacements
 * @author Clément Delafargue
 */
public class Emplacement {
    /** 
     * Type de l'empacement.
     * O pour un emplacement lambda
     */
    protected int type = 0;
    
    /** Identifiant de l'emplacement */
    protected int id = 0;
    
    
    /**
     * Initialise un emplacement lambda
     * @param id L'identifiant de l'emplacement
     * */
    public Emplacement(int id){
        this.id = id;
    }
    
    /**
     * Initialise un emplacement du type demandé
     * @param id L'identifiant de l'emplacement
     * @param type Le type d'emplacement
     */
    public Emplacement(int id, int type){
        this.id = id;
        this.type = type;
    }
    
    /**
     * Renvoie l'identifiant de l'emplacement
     * @return l'identifiant de l'emplacement
     */
    public int getId(){
        return this.id;
    }
    
    /**
     * Renvoie le type de l'emplacement
     * @return le type de l'emplacement
     */
    public int getType(){
        return this.type;
    }
}
