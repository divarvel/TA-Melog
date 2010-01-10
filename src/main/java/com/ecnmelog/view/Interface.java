package com.ecnmelog.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSplitPane;




//Pas encore implémenté ;-)
//import com.ecnmelog.controler.*;
//import com.ecnmelog.observer.Observer;

/**
 * Classe de définition de la GUI
 * @author Clément Delafargue
 * */
public class Interface extends JFrame{
//public class Interface extends JFrame implements Observer{
    
    /** Content Pane de la fenêtre */
    private JPanel pan = new JPanel();
    /** SplitPane contenant les deux parties de l'interface */
    private JSplitPane split;
    
    public Interface(){
        this.setTitle("Gestion des containers");
        this.setSize(1000, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(this.pan);
        
        this.split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new guiAttente(), new guiStockage());
        this.split.setOneTouchExpandable(true);
        this.split.setDividerLocation(500);
        
        this.setLayout(new BorderLayout());
        this.getContentPane().add(split, BorderLayout.CENTER);


        
        this.setVisible(true);
    }
}
