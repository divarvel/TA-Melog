package com.ecnmelog.model;

import java.util.ArrayList;

import com.ecnmelog.observer.Observable;
import com.ecnmelog.observer.Observer;

/**
 * Classe abstraite permettant de bien définir le comportement de l'objet attente vis-à-vis du contrôleur
 */
public abstract class AbstractAttente extends ObservableModel implements Observable, Entrepot {

    /**
     * Ajouter un container
     * @param container Le container à ajouter
     */
    public abstract void addContainer(Container container) throws ContainerException;

}
