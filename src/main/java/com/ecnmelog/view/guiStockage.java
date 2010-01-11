package com.ecnmelog.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;



import com.ecnmelog.controller.StockageController;
import com.ecnmelog.observer.Observer;

/**
 * Classe de définition de la partie "Stockage" de la GUI
 * @author Clément Delafargue
 * */

public class guiStockage extends JPanel{
    
    private JLabel lblTitre = new JLabel("Stockage");
    private JTabbedPane onglets = new JTabbedPane();
    private JButton btnVider = new JButton("Vider");
    
    /** Instance du contrôleur */
    private StockageController controller;
    
    public guiStockage(StockageController control){
        this.controller = control;
        this.setPreferredSize(new Dimension(480, 700));
        onglets.add("Graph", new guiSchemaStockage());
        onglets.add("Tableau", new guiTableauStockage());

        this.btnVider.addActionListener(new EmptyListener());
        
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
    
    
    /** Listener du bouton de vidage de la zone de stockage*/
    public class EmptyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane jop = new JOptionPane();
            int confirm = jop.showConfirmDialog(null, "Voulez-vous vider la zone de stockage ?", "Vider la zone de stockage", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            
            if(confirm == JOptionPane.OK_OPTION) {
                controller.emptyStockage();     
            }
        }
    }
}
