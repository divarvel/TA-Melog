package com.ecnmelog.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;



//Pas encore implémenté ;-)
//import com.ecnmelog.controler.*;
//import com.ecnmelog.observer.Observer;

/**
 * Classe de définition de la partie "Stockage" de la GUI
 * @author Clément Delafargue
 * */

public class guiStockage extends JPanel{
    
    private JLabel lblTitre = new JLabel("Stockage");
    private JTabbedPane onglets = new JTabbedPane();
    private JButton btnVider = new JButton("Vider");
    
    public guiStockage(){
        onglets.add("Graph", new guiSchemaStockage());
        onglets.add("Tableau", new guiTableauStockage());

        
        JPanel panelTitre = new JPanel();
        JPanel panelData = new JPanel();
        JPanel panelBouton = new JPanel();
        
        panelTitre.setLayout(new FlowLayout());
        panelTitre.add(lblTitre);
        panelData.setLayout(new FlowLayout());
        panelData.add(onglets);
        panelBouton.setLayout(new FlowLayout());
        panelBouton.add(btnVider);
        
        this.setLayout(new GridLayout(3, 1));
        this.add(panelTitre);
        this.add(panelData);
        this.add(panelBouton);
        
    } 
}
