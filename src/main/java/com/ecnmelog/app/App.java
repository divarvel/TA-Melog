package com.ecnmelog.app;


import com.ecnmelog.model.AbstractStockage;
import com.ecnmelog.model.AbstractAttente;
import com.ecnmelog.model.Stockage;
import com.ecnmelog.model.Attente;
import com.ecnmelog.model.Container;
import com.ecnmelog.model.ContainerException;


import com.ecnmelog.view.Interface;
import com.ecnmelog.controller.StockageController;

/**
 * Classe principale de l'application.
 */
public class App {
    /**
     * Méthode principale de l'application.
     * @param args Les arguments passés en CLI
     */
    public static void main(final String[] args) {
        int capaciteStockage = 100;

        AbstractStockage stock = new Stockage(capaciteStockage);
        AbstractAttente att = new Attente();
        try {
            for(int i=0; i<=34; i++)
                att.addContainer(new Container(i, 0));
            for(int i=0; i<=5; i++)
                att.addContainer(new Container(i + 35, 1));
            for(int i=0; i<=66; i++)
                att.addContainer(new Container(i + 41, 2));
        } catch(ContainerException e) {
            System.out.println(e.getMessage());
        }

        
        StockageController controller = new StockageController(stock, att);
        Interface fenetre = new Interface(controller);
        stock.addObserver(fenetre);
        att.addObserver(fenetre);
    }
}
