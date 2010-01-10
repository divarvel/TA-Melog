package com.ecnmelog.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;



//Pas encore implémenté ;-)
//import com.ecnmelog.controler.*;
//import com.ecnmelog.observer.Observer;

/**
 * Classe de définition de la partie "Attente" de la GUI
 * @author Clément Delafargue
 * */

public class guiAttente extends JPanel{
    
    private JLabel lblTitre = new JLabel("Attente");
    public guiAttente(){
        
        this.setLayout(new FlowLayout());
        this.add(lblTitre);
    } 
}
