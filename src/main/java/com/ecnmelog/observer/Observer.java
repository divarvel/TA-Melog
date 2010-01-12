package com.ecnmelog.observer;

import com.ecnmelog.model.AbstractAttenteBean;
import com.ecnmelog.model.AbstractStockageBean;

/**
 * Interface implémentée par la vue
 */
public interface Observer {
    
    /**
     * Affiche un message d'erreur transmis par le modèle
     * @param error Le message à afficher
     */
    public void displayError(String error);
    
    /**
     * Affiche un message d'avertissement transmis par le modèle
     * @param warning Le message à afficher
     */
    public void displayWarning(String warning);

    /**
     * Affiche un message d'information transmis par le modèle
     * @param info Le message à afficher
     */
    public void displayInfo(String info);
    
    /**
     * Met à jour la partie "Attente" de la vue
     * @param attenteBean Statut de la zone d'attente
     */
    public void updateAttente(AbstractAttenteBean attenteBean);
    
    /**
     * Met à jour la partie "Stockage" de la vue
     * @param stockageBean Statut de la zone de stockage
     */
    public void updateStockage(AbstractStockageBean stockageBean);

}
