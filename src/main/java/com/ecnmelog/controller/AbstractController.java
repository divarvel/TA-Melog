// TODO : Quasiment tout ^^

package com.ecnmelog.controller;

import java.util.ArrayList;

import com.ecnmelog.model.AbstractStockage;
import com.ecnmelog.model.AbstractAttente;

/**
 * Classe abstraite définissant le comportement du contrôleur
 */
public abstract class AbstractController {
    
    protected AbstractStockage stock;
    protected AbstractAttente att;
    
    public AbstractController(AbstractStockage stock, AbstractAttente att){
        this.stock = stock;
        this.att = att;
    }
    
    /**
     * Méthode de contrôle
     */
    abstract void control();
}
