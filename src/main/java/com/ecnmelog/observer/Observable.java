package com.ecnmelog.observer;

import com.ecnmelog.model.AbstractAttenteBean;
import com.ecnmelog.model.AbstractStockageBean;

/**
 * Interface implémentée par le modèle
 */
public interface Observable {
    public void addObserver(Observer obs);
    public void removeObserver();
    public void notifyAttenteObserver(AbstractAttenteBean attenteBean);
    public void notifyStockageObserver(AbstractStockageBean stockageBean);
}
