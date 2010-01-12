package com.ecnmelog.model;

import java.util.ArrayList;

import com.ecnmelog.observer.Observable;
import com.ecnmelog.observer.Observer;

/**
 * Classe abstraite permettant de bien définir le comportement de l'objet attente vis-à-vis du contrôleur
 */
public abstract class AbstractAttente implements Observable, Entrepot {
    
    private ArrayList<Observer> listObserver = new ArrayList<Observer>();
    
    /**
     * Ajouter un container
     * @param container Le container à ajouter
     */
    public abstract void addContainer(Container container) throws ContainerException;
    
    //**************************************************
    //           IMPLÉMENTATION PATTERN OBSERVER
    //**************************************************
    public void addObserver(Observer obs) {
        this.listObserver.add(obs);
    }
    
    public void notifyAttenteObserver(AbstractAttenteBean attenteBean) {
        for(Observer obs : listObserver)
            obs.updateAttente(attenteBean);
    }

    public void notifyStockageObserver(AbstractStockageBean stockageBean) {
        for(Observer obs : listObserver)
            obs.updateStockage(stockageBean);
    }

    public void removeObserver() {
        listObserver = new ArrayList<Observer>();
    }

    
}
