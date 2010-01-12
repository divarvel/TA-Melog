package com.ecnmelog.model;

import java.util.ArrayList;
import java.sql.*;

import com.ecnmelog.model.DbConn;
import com.ecnmelog.model.Container;
import com.ecnmelog.model.Emplacement;

/**
 * Objet passé à la vue par le modèle.
 * Contient l'état actuel de la zone d'attente
 */
public abstract class AbstractStockageBean {
    /** Liste des containers stockés INDEXÉS PAR LEUR EMPLACEMENT */
    protected ArrayList<Container> containers;
    /** Nombre de containers de chaque type */
    protected ArrayList<Integer> nbContainers;
    /** Liste des emplacements */
    protected ArrayList<Emplacement> emplacements;
    /** Liste des emplacements disponibles */
    protected ArrayList<Emplacement> emplacementsDispo;
    /** Nombre d'emplacements */
    protected ArrayList<Integer> nbEmplacements;
    /** Liste des emplacements disponibles */
    protected ArrayList<Integer> nbEmplacementsDispo;
    
    /** Renvoie la liste des containers stockés.
     * @return La liste des containers stockés
     */
    public ArrayList<Container> getContainers() {
        return this.containers;
    }
    
    /** Renvoie le nombre total de containers stockés
     * @return Le nombre total de containers
     */
    public int countContainers() {
        int nb = 0;
        for (int i : this.nbContainers) {
            nb += i;
        }
        
        return nb;
    }
    
    /** Renvoie le nombre de containers d'un type donné stockés
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
    
    /** Renvoie la liste des emplacements
     * @return La liste des emplacements
     */
    public ArrayList<Emplacement> getEmplacements() {
        return this.emplacements;
    }
    
    /** Renvoie la liste des emplacements disponibles
     * @return La liste des emplacements disponibles
     */
    public ArrayList<Emplacement> getEmplacementsDispo() {
        return this.emplacementsDispo;
    }
    
    /** Renvoie le nombre total d'emplacements
     * @return Le nombre total d'emplacements
     */
    public int countEmplacements() {
        int nb = 0;
        for(int i : this.nbEmplacements) {
            nb += i;
        }
        return nb;
    }
    
    /** Renvoie le nombre d'emplacements d'un type donné
     * @return Le nombre d'emplacements du type demandé
     */
    public int countEmplacements(int type) {
        int nb = 0;
        try {
            nb = this.nbEmplacements.get(type);
        } catch (IndexOutOfBoundsException e) {}
        return nb;
    }
    
    /** Renvoie le nombre d'emplacements disponibles
     * @return Le nombre d'emplacements disponibles
     */
    public int countEmplacementsDispo() {
        int nb = 0;
        for(int i : this.nbEmplacementsDispo) {
            nb += i;
        }
        return nb;
    }
    
    /** Renvoie le nombre d'emplacements disponibles d'un type donné
     * @return Le nombre d'emplacements disponibles du type demandé
     */
    public int countEmplacementsDispo(int type) {
        int nb = 0;
        try {
            nb = this.nbEmplacementsDispo.get(type);
        } catch (IndexOutOfBoundsException e) {}
        return nb;
    }
}
