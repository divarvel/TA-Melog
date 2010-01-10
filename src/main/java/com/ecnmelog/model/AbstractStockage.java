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
    public abstract int getEmplacementLibre(int container_type) throws EmplacementException;
    public abstract void traiterAttente();
    
    //**************************************************
    //           IMPLÉMENTATION PATTERN OBSERVER
    //**************************************************
    public void addObserver(Observer obs) {
        this.listObserver.add(obs);
    }
    
    public void notifyObserver(String str) {
        if(str.matches("^0[0-9]+"))
            str = str.substring(1, str.length());
        
        for(Observer obs : listObserver)
            obs.update(str);
    }

    public void removeObserver() {
        listObserver = new ArrayList<Observer>();
    }
}
