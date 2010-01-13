package com.ecnmelog.model;

import java.util.TreeMap;
import java.sql.*;

import com.ecnmelog.model.DbConn;
import com.ecnmelog.model.Container;

/**
 * Objet passé à la vue par le modèle.
 * Contient l'état actuel de la zone d'attente
 */
public abstract class AbstractAttenteBean {
    /** Liste des containers */
    protected TreeMap<Integer, Container> containers;
    /** Nombre de containers de chaque type */
    protected TreeMap<Integer, Integer> nbContainers;
    
    /** Renvoie la liste des containers en attente */
    public TreeMap<Integer, Container> getContainers() {
        return this.containers;
    }
    
    /** Renvoie le nombre total de containers en attente
     * @return Le nombre total de containers
     */
    public int countContainers() {
        int nb = 0;
        for (int i : this.nbContainers.keySet()) {
            nb += this.nbContainers.get(i);
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
