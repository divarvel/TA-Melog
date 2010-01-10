package com.ecnmelog.model;

import java.util.ArrayList;

import com.ecnmelog.observer.Observable;
import com.ecnmelog.observer.Observer;

public abstract class AbstractModel implements Observable{
	
	private ArrayList<Observer> listObserver = new ArrayList<Observer>();

	//**************************************************
	//		   IMPLÉMENTATION PATTERN OBSERVER
	//**************************************************
	public void addObserver(Observer obs) {
		this.listObserver.add(obs);
	}
	
	public void notifyObserver(String str) {
		for(Observer obs : listObserver)
			obs.update(str);
	}

	public void removeObserver() {
		listObserver = new ArrayList<Observer>();
	}

	
}
