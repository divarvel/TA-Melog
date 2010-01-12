package com.ecnmelog.view;

import com.ecnmelog.model.AbstractAttenteBean;
import com.ecnmelog.model.AbstractStockageBean;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;




import com.ecnmelog.controller.StockageController;
import com.ecnmelog.observer.Observer;

/**
 * Classe de définition de la GUI
 * @author Clément Delafargue
 * */
public class Interface extends JFrame implements Observer{
    
    /** Content Pane de la fenêtre */
    private JPanel pan = new JPanel();
    
    /** Instance du contrôleur */
    private StockageController controller;
    
    public Interface(StockageController controller){
        this.controller = controller;
        this.setTitle("Gestion des containers");
        this.setSize(1000, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.initContent();
        
        this.setContentPane(this.pan);
        this.setVisible(true);
    }
    
    /** Initialise le contenu de la fenêtre */
    public void initContent(){
        JButton btnStocker = new JButton(">>");
        btnStocker.setPreferredSize(new Dimension(40, 10));
        btnStocker.addActionListener(new StockListener());
        this.pan.setLayout(new BorderLayout());
        this.pan.add(new guiAttente(this.controller), BorderLayout.WEST);
        this.pan.add(btnStocker, BorderLayout.CENTER);
        this.pan.add(new guiStockage(this.controller), BorderLayout.EAST);
    }
    
    /* Implémentation de l'interface Observer */
    /**
     * Affiche un message d'erreur transmis par le modèle
     * @param error Le message à afficher
     */
    public void displayError(String error) {
        new JOptionPane().showMessageDialog(null, error, "Erreur !", JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * Affiche un message d'avertissement transmis par le modèle
     * @param warning Le message à afficher
     */
    public void displayWarning(String warning) {
        new JOptionPane().showMessageDialog(null, warning, "Attention !", JOptionPane.WARNING_MESSAGE);
    }
    
    /**
     * Affiche un message d'information transmis par le modèle
     * @param info Le message à afficher
     */
    public void displayInfo(String info) {
        new JOptionPane().showMessageDialog(null, info, "Information", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Met à jour la partie "Attente" de la vue
     * @param attenteBean Statut de la zone d'attente
     */
    public void updateAttente(AbstractAttenteBean attenteBean) {
        
    }
    
    /**
     * Met à jour la partie "Stockage" de la vue
     * @param stockageBean Statut de la zone de stockage
     */
    public void updateStockage(AbstractStockageBean stockageBean) {
        
    }
    
    /** Listener du bouton de stockage des containers en attente */
    public class StockListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            controller.traiterAttente();     
        }
    }
}
