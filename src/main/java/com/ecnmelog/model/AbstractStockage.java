package com.ecnmelog.model;

import java.util.ArrayList;

import com.ecnmelog.observer.Observable;
import com.ecnmelog.observer.Observer;

/**
 * Classe abstraite permettant de bien définir le comportement de l'objet stockage vis-à-vis du contrôleur
 */
public abstract class AbstractStockage implements Observable, Entrepot{
    
    private ArrayList<Observer> listObserver = new ArrayList<Observer>();
    
    public abstract int countEmplacementsDispo();
    public abstract int countEmplacementsDispo(int type);
    public abstract void storeContainer(int container_id, int emplacement_id) throws ContainerException, EmplacementException;
    public abstract int getEmplacementLibre(int containerType) throws ContainerException, EmplacementException;
    public abstract void traiterAttente();
    
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
