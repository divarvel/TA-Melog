package com.ecnmelog.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;




//Pas encore implémenté ;-)
//import com.ecnmelog.controler.*;
//import com.ecnmelog.observer.Observer;

/**
 * Classe qui contient l'affichage graphique des containers stockés
 * @author Clément Delafargue
 * */
public class guiTableauStockage extends JPanel{


    public guiTableauStockage(){
        String[] colonnes = {"Type", "Occupés", "Libres"};
        Object[][] data = {    {"Normal", "5", "25"},
                            {"Frigorifiques", "2", "3"},
                            {"Surtarifés", "5", "60"},
                            {"Total", "12", "88"}};
                            
        JTable tableau = new JTable(data, colonnes);
        
        this.add(new JScrollPane(tableau));

    }
}
