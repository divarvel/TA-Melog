package com.ecnmelog.observer;

import com.ecnmelog.model.AbstractAttenteBean;
import com.ecnmelog.model.AbstractStockageBean;

/**
 * Interface implémentée par la vue
 */
public interface Observer {
    
    /**
     * Transmet un message d'erreur à faire afficher par la vue
     * @param msg le message d'erreur à faire afficher 
     */
    public void displayError(String error);
    
    /**
     * Transmet un message d'avertissement à faire afficher par la vue
     */
    public void displayWarning(String warning);

    /**
     * Transmet un message d'information à faire afficher par la vue
     */
    public void displayInfo(String info);
    
    /**
     * Met à jour la partie "Attente" de la vue
     * @param statutAttente Statut de la zone d'attente
     */
    public void updateAttente(AbstractAttenteBean attenteBean);
    
    /**
     * Met à jour la partie "Stockage" de la vue
     * @param statutStockage Statut de la zone de stockage
     */
    public void updateStockage(AbstractStockageBean stockageBean);

}
