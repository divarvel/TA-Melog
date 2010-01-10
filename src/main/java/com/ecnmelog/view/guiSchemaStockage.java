package com.ecnmelog.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Graphics;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSplitPane;




//Pas encore implémenté ;-)
//import com.ecnmelog.controler.*;
//import com.ecnmelog.observer.Observer;

/**
 * Classe qui contient l'affichage graphique des containers stockés
 * @author Clément Delafargue
 * */
public class guiSchemaStockage extends JPanel{

    public guiSchemaStockage(){
        this.setBackground(Color.RED);
    }
    
    public void paintComponent(Graphics g){
        this.setSize(400, 200);
        // Affichage des boîtes
    }

}
