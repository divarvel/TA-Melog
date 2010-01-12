package com.ecnmelog.model;

import java.sql.*;
import java.util.ArrayList;

/**
 * Classe de définition des containers
 * @author Clément Delafargue
 */
public class Container
{
    /** 
     * Type du container.
     * O pour un container lambda
     */
    protected int type = 0;
    
    /** Identifiant du container */
    protected int id = 0;
    
    /** Emplacement de stockage du container */
    protected int emplacement = 0;
    
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
     * Initialise un container du type demandé, stocké à l'emplacement demandé
     * @param id L'identifiant du container
     * @param type Le type de container
     * @param emplacement L'emplacement du container
     */
    public Container(int id, int type, int emplacement){
        this.id = id;
        this.type = type;
        this.emplacement = emplacement;
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
     * Renvoie l'emplacement du container
     * @return l'emplacement du container
     */
    public int getEmplacement(){
        return this.emplacement;
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
    
    
    public static ArrayList<Integer> getTypes(){
        ArrayList<Integer> types = new ArrayList<Integer>();
        
        Connection conn = DbConn.getInstance();
        
        try{
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("SELECT type_id FROM type");
            while(rs.next()){
                types.add(rs.getInt("type_id"));
            }
            rs.close();
        }
        catch(SQLException e){
            System.out.println("Erreur SQL");
        }
        
        return types;
    }
}
