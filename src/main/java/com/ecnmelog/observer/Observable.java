package com.ecnmelog.observer;

/**
 * Interface implémentée par le modèle
 */
public interface Observable {
	public void addObserver(Observer obs);
	public void removeObserver();
	public void notifyObserver(String str);
}
