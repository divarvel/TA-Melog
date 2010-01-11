package com.ecnmelog.app;


import com.ecnmelog.model.*;
import com.ecnmelog.view.*;
import java.sql.*;

/**
 * Classe principale de l'application
 */
public class App {
    /**
     * Méthode principale de l'application.
     * @param args Les arguments passés en CLI
     */
    public static void main(String[] args) {
        
        Interface fenetre = new Interface();
        
        // Fin du programme, on ferme la connexion à la DB
        try {
            DbConn.getInstance().close();
        } catch (SQLException e) {
            System.out.println("Erreur SQL");
        }

    }
}
