package com.ecnmelog.model;

import java.util.ArrayList;
import java.sql.*;

import com.ecnmelog.model.DbConn;
import com.ecnmelog.model.Container;

/**
 * Objet passé à la vue par le modèle.
 * Contient l'état actuel de la zone d'attente
 */
public class AttenteBean extends AbstractAttenteBean {

    /**
     * Récupère l'état actuel de la zone d'attente dans la base de données et le stocke dans l'objet
     */
    public AttenteBean() {
        Connection conn = DbConn.getInstance();
        
        this.containers = new ArrayList<Container>();
        this.nbContainers = new ArrayList<Integer>();
        
        try {
            // Récupération et stockage de tous les containers en attente
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("SELECT container_id, type_id FROM container WHERE emplacement_id ISNULL ORDER BY container_id ASC;");
            
            while(rs.next()) {
                this.containers.add(new Container(rs.getInt("container_id"), rs.getInt("type_id")));
            }
            rs.close();
        } catch(SQLException e) {
            // Notifier la vue de l'erreur
        }
        
        try {
            // Comptage de tous les types de containers en attente
            // La jointure est là pour exclure les containers de type indéfini
            // C'est un choix bourrin, je sais, et ça peut entraîner l'apparition de containers zombi
            // Boaf, du moment qu'ils commencent pas à dévorer les autres containers, ça passe.
            // De toutes façons l'espace d'attente est illimité alors osef. Na.
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("SELECT COUNT(*) AS nb, a.type_id FROM container a NATURAL JOIN type b WHERE a.emplacement_id ISNULL GROUP BY a.type_id;");
            
            while(rs.next()) {
                this.nbContainers.add(rs.getInt("type_id"), rs.getInt("nb"));
            }
            rs.close();
        } catch(SQLException e) {
            // Notifier la vue de l'erreur
        }
    }
}
