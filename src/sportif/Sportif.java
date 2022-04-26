 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportif;

 import models.Exercice;
import services.ServiceExercice;
import utils.MaConnexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.DemoCRUDController;
import models.Regime;
import services.ServiceRegime;
  
/**
 *
 * @author  
 */
public class Sportif {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException 
     */
  // public static void main(String[] args) throws SQLException {
           
     //  ServiceExercice p1 = new ServiceExercice();
     //   Exercice p = new Exercice("3issa", "3issa"," 3issa");  
        // p1.createExercice(p);         
    
       //  p1.modifier(p); 
         
//    p1.DeleteExercice(22);
    
      //  System.out.println(p1.readExercices());
    
     //   System.out.println( p1.RechercheById(24));
       
       // System.out.println(p1.getByCode("3issa"));
        
        
      //  System.out.println(p1.TriParCode());     
        
        
        
        
        
        
        
        
        
        
        
      
      /********************************/
     ServiceRegime p2 = new ServiceRegime();
        Regime pr =new Regime(1236548, "dazdazd", "150g_Viande"," dazdqsdqs","dqsdqs","qsd","azd","adzz","azd"); 
   //   p2.createRegime(pr);  
         
   //     p2.DeleteRegime(12);
        
        
Regime pre = new Regime(43, "dan", "dali", "dan", "dali", "dan", "dali", "dali", "dali");
        

 //p2.modifierRegime(pre); 
  

     //   System.out.println(p2.readRegimes());

   }
    
     
 // }














