package com.ecnmelog.view;

import java.awt.Color;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;




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
        this.pan.setLayout(new BorderLayout());
        this.pan.add(new guiAttente(this.controller), BorderLayout.WEST);
        this.pan.add(new guiStockage(this.controller), BorderLayout.EAST);
    }
    
    public void update(String str) {
        
    }
}
