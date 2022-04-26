  /*    (ServiceExercice)
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services; 

import interfaces.IServiceRegime;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Regime ;
import utils.MaConnexion;

/**
 *
 * @author admin
 */
public class ServiceRegime implements IServiceRegime{
    
    //var
    MaConnexion instance = MaConnexion.getInstance();
    Connection cnx = instance.getCnx();

    @Override
    public void createRegime(Regime p) {
        
        //request
        String req = "INSERT INTO `Regime`(`aliments_autorises`, `aliments_interdits`, `petit_dejeuner`, `collation1`, `dejeuner`, `collation2`, `diner`, `conseils`) VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, p.getAlimentsAutorises());
            st.setString(2, p.getAlimentsInterdits());
            st.setString(3, p.getPetitDejeuner());
            st.setString(4, p.getCollation1());
            st.setString(5, p.getDejeuner());
            st.setString(6, p.getCollation2());
            st.setString(7, p.getDiner());
            st.setString(8, p.getConseils());

            st.executeUpdate();
            System.out.println("Regime ajoutée avec succes.");
            
        } catch (SQLException ex) {
            
            ex.printStackTrace(); 
        }
        
        
    }

    @Override
    public List<Regime> readRegimes() {
        ArrayList<Regime> Regimes = new ArrayList();
        
        try {
            Statement st = cnx.createStatement();
            String req = "SELECT * FROM Regime";
            ResultSet rs = st.executeQuery(req);
             
            while (rs.next()) {                 
                
                Regimes.add(new Regime(rs.getInt(1), rs.getString("aliments_autorises"), rs.getString("aliments_interdits"),rs.getString("petit_dejeuner"), rs.getString("collation1"), rs.getString("dejeuner"), rs.getString("collation2"),rs.getString("diner"),rs.getString("conseils")));
                
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return Regimes;
    }
    
    
     public void DeleteRegime(int id ) {
         
        String req = "delete from regime where id=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException er) {
            System.out.println("Erreur lors de la suppression");
            er.printStackTrace();
        }
    }
     
       public void modifierRegime(Regime P) {
        try {
            String req = "update Regime set aliments_autorises = ? , aliments_interdits = ? , petit_dejeuner = ? , collation1 = ? , dejeuner = ? , collation2 = ? , diner = ? , conseils = ? where id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
        
           ps.setString(1, P.getAlimentsAutorises());
            ps.setString(2, P.getAlimentsInterdits());
            ps.setString(3, P.getPetitDejeuner());
            ps.setString(4, P.getCollation1());
            ps.setString(5, P.getDejeuner());
            ps.setString(6, P.getCollation2());
            ps.setString(7, P.getDiner());
            ps.setString(8, P.getConseils());
            ps.setInt(9, P.getId());

            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Regime.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
     
     
     
     
     
     
     
     
     
     
     
     
     
     public List<Regime> fetchAllRegime() {
       ArrayList<Regime> regimes = new ArrayList();
        
        try {
            Statement st = cnx.createStatement();
            String req = "SELECT * FROM regimes";
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()) {                
                
 
                regimes.add(new Regime(rs.getInt(1), rs.getString("AlimentsAutorises"), rs.getString("AlimentsInterdits"),rs.getString("PetitDejeuner"), rs.getString("Collation1"), rs.getString("Dejeuner"), rs.getString("Collation2"),rs.getString("Diner"),rs.getString("Conseils")));
                
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return regimes;
    }
     

}




