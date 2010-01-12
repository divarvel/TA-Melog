package com.ecnmelog.model;

import java.util.ArrayList;
import java.sql.*;

import com.ecnmelog.model.DbConn;
import com.ecnmelog.model.Container;

/**
 * Objet passé à la vue par le modèle.
 * Contient l'état actuel de la zone d'attente
 */
public abstract class AbstractAttenteBean {
    /** Liste des containers */
    protected ArrayList<Container> containers;
    /** Nombre de containers de chaque type */
    protected ArrayList<Integer> nbContainers;
    
    /** Renvoie la liste des containers en attente */
    public ArrayList<Container> getContainers() {
        return this.containers;
    }
    
    /** Renvoie le nombre total de containers en attente
     * @return Le nombre total de containers
     */
    public int countContainers() {
        int nb = 0;
        for (int i : this.nbContainers) {
            nb += i;
        }
        
        return nb;
    }
    
    /** Renvoie le nombre de containers d'un type donné en attente
     * @param type Le type de containers à compter
     * @return Le nombre de containers du type indiqué
     */
    public int countContainers(int type) {
        int nb = 0;
        try {
            nb = this.nbContainers.get(type);
        } catch (IndexOutOfBoundsException e) {}
        
        return nb;
    }
}
