/*    (ServiceExercice)
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.IServiceExercice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Exercice;
import utils.MaConnexion;

/**
 *
 * @author admin
 */
public class ServiceExercice implements IServiceExercice {

    //var
    MaConnexion instance = MaConnexion.getInstance();
    Connection cnx = instance.getCnx();

    public void createExercice(Exercice p) {

        //request
        try {
            String req = "INSERT INTO `Exercice`(`code`, `mouvement`, `description`) VALUES (?,?,?)";

            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, p.getCode_exercice());
            st.setString(2, p.getMouvement());
            st.setString(3, p.getDescription());

            st.executeUpdate();
            System.out.println("Exercice ajoutée avec succes.");

        } catch (SQLException ex) {

            ex.printStackTrace();
        }

    }
 
    
     public Exercice getByCode(String code) {
        Exercice r = new Exercice();
        String req = "select * from Exercice where code=?";
        try {
            PreparedStatement ps = MaConnexion.getInstance().getCnx().prepareStatement(req);
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                r.setCode_exercice(rs.getString("code")); 
                r.setId(rs.getInt("id"));
                r.setMouvement(rs.getString("mouvement"));
                r.setDescription(rs.getString("description"));
          
             
            }
 
        } catch (SQLException erreur) {
            System.out.println("erreurr");
            erreur.printStackTrace();
        }
         return r;
    }
    
    
    
    public List<Exercice> RechercheById(int id) {
        ArrayList<Exercice> exercices = new ArrayList();
        try {
            String requete = "SELECT * FROM exercice where id =?";
            PreparedStatement P = cnx.prepareStatement(requete);
            P.setInt(1, id);
            ResultSet rs = P.executeQuery();
            
            while (rs.next()) {                
                
                exercices.add(new Exercice(rs.getString(3), rs.getString("mouvement"), rs.getString("description")));
                
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return exercices;
    }
    
    
    
    
    
    public List<Exercice> TriParCode() {
        ArrayList<Exercice> exercices = new ArrayList();

        String req = "SELECT * FROM exercice ORDER BY code ASC";
        try {
            Statement st = cnx.createStatement();

            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {

                exercices.add(new Exercice(rs.getString(3), rs.getString("mouvement"), rs.getString("description")));

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return exercices;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    @Override
    public List<Exercice> readExercices() {
        ArrayList<Exercice> Exercices = new ArrayList();

        try {
            Statement st = cnx.createStatement();
            String req = "SELECT * FROM Exercice";
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {

                Exercices.add(new Exercice(rs.getString(3), rs.getString("mouvement"), rs.getString("description")));

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return Exercices;
    }

    public void DeleteExercice(int id ) {
         
        String req = "delete from exercice where id=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException er) {
            System.out.println("Erreur lors de la suppression");
            er.printStackTrace();
        }
    }
    
    public void modifier(Exercice P) {
        try {
            String req = "update Exercice set description = ? , mouvement = ? where id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
        
            ps.setString(1, P.getMouvement());
            ps.setString(2, P.getDescription());
            ps.setInt(3, P.getId());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Exercice.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
 
    
    

}
