package com.ecnmelog.model;

import java.util.ArrayList;

import com.ecnmelog.observer.Observable;
import com.ecnmelog.observer.Observer;

/**
 * Classe abstraite permettant de bien définir le comportement de l'objet stockage vis-à-vis du contrôleur
 */
public abstract class AbstractStockage extends ObservableModel implements Observable, Entrepot{
    
    public abstract int countEmplacementsDispo();
    public abstract int countEmplacementsDispo(int type);
    public abstract void storeContainer(int container_id, int emplacement_id) throws ContainerException, EmplacementException;
    public abstract int getEmplacementLibre(int containerType) throws ContainerException, EmplacementException;
    public abstract void traiterAttente();
}
