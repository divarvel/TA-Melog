package com.ecnmelog.model;

/**
 * Interface implémentée par les objets qui peuvent stocker des containers.
 * Ces objets présentent un manière commune de compter et de se débarasser des containers
 * @author Clément Delafargue
 * */
public interface Entrepot{
    // Méthodes de comptage
    public int countContainers();
    public int countContainers(int type);
    
    // Méthodes de vidage
    public void removeContainerById(int id);
    public void removeContainerByType(int type);
    public void removeContainersByType(int type);
    public void empty();
}
