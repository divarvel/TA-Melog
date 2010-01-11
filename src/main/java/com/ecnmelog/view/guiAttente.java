package com.ecnmelog.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;



import com.ecnmelog.controller.StockageController;
import com.ecnmelog.observer.Observer;

/**
 * Classe de définition de la partie "Attente" de la GUI
 * @author Clément Delafargue
 * */

public class guiAttente extends JPanel{
    
    private JLabel lblTitre = new JLabel("Attente");
    /** Instance du contrôleur */
    private StockageController controller;
    
    
    public guiAttente(StockageController controller){
        this.setPreferredSize(new Dimension(480, 700));
        this.setLayout(new FlowLayout());
        this.add(lblTitre);
    } 
}
