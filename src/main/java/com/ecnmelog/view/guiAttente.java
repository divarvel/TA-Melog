package com.ecnmelog.view;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
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
    private JButton btnVider = new JButton("Vider");
    /** Instance du contrôleur */
    private StockageController controller;
    
    
    public guiAttente(StockageController control){
        this.controller = control;
        this.setPreferredSize(new Dimension(480, 700));
        
        Font police = new Font("Tahoma", Font.BOLD, 42);
        lblTitre.setFont(police);
        lblTitre.setHorizontalAlignment(JLabel.CENTER);
        
        this.btnVider.addActionListener(new EmptyListener());
        
        JPanel panelTitre = new JPanel();
        JPanel panelData = new JPanel();
        JPanel panelBouton = new JPanel();
        
        panelTitre.setLayout(new FlowLayout());
        panelTitre.add(lblTitre);
        panelData.setLayout(new FlowLayout());
        panelBouton.setLayout(new FlowLayout());
        panelBouton.add(btnVider);
        
        this.setLayout(new GridLayout(3, 1));
        this.add(panelTitre);
        this.add(panelData);
        this.add(panelBouton);
    }
    
    /** Listener du bouton de vidage de la zone de stockage*/
    public class EmptyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane jop = new JOptionPane();
            int confirm = jop.showConfirmDialog(null, "Voulez-vous vider la zone d'attente ?", "Vider la zone d'attente", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            
            if(confirm == JOptionPane.OK_OPTION) {
                controller.emptyAttente();     
            }
        }
    }
}
