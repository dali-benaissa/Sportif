/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;

 
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
/**
 *
 * @author 21621
 */
public class ImcController implements Initializable {

      private Stage stage;
    private Scene scene;
    private Parent root;
    
      @FXML
    private TextField tfTaille;

    @FXML
    private TextField tfPoid;

    @FXML
    private Button btImc;

    @FXML
    private Button btExImc;

    @FXML
    private Button btRgImc;

    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    
    
    
       
            public void switchtoregime(ActionEvent event) throws IOException{
               
                    root = FXMLLoader.load(getClass().getResource("/javafx/Demoregime.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
        
   //  scene.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
      
        stage.setScene(scene);
        stage.show();
           }
    
       public void switchtoexercice(ActionEvent event) throws IOException{
               
             root = FXMLLoader.load(getClass().getResource("/javafx/DemoCRUD.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
          scene = new Scene(root);
        
     scene.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
      
        
       stage.setScene(scene);
        stage.show();
           }
    
    
       
       
           @FXML
    private void calcImc(ActionEvent event) {
      String poid =  tfPoid.getText();
       String taille =  tfTaille.getText();
       
       double res = Integer.parseInt(poid) / Math.pow((Float.parseFloat(taille)/100),2);
               System.out.println("taille sqr "+Math.pow((Float.parseFloat(taille)/100),2));
               System.out.println("poid "+Integer.parseInt(poid) );
               DecimalFormat df = new DecimalFormat("#.#");      
             String outImc = df.format(res);
               //System.out.println("IMC = "+ Double.parseDouble(outImc));
               
               if(res <18.5){
         JOptionPane.showMessageDialog(null,  
                        " Votre Indice de masse corporelle (IMC) est: "+outImc+"\n\n"
                                + "<html><font color='red'>moins de 18,5  Insuffisance pondérale (maigreur)</font></html>\n"
                +"18,5 à 25  Corpulence normale\n"+
                                "25 à 30  Surpoids\n"+
                                "30 à 35  Obésité modérée\n"+
                                "35 à 40  Obésité sévère\n"+
                                "plus de 40  Obésité morbide ou massive\n","Résultat",0);
                    }
                    if(18.5< res && res<25){
         JOptionPane.showMessageDialog(null,  
                        " Votre Indice de masse corporelle (IMC) est: "+outImc+"\n\n"
                                + "moins de 18,5  Insuffisance pondérale (maigreur)\n"
                +"<html><font color='red'>18,5 à 25  Corpulence normale</font></html>\n"+
                                "25 à 30  Surpoids\n"+
                                "30 à 35  Obésité modérée\n"+
                                "35 à 40  Obésité sévère\n"+
                                "plus de 40  Obésité morbide ou massive\n","Résultat",0);
                    }
                        if(25< res && res<30){
         JOptionPane.showMessageDialog(null,  
                        " Votre Indice de masse corporelle (IMC) est: "+outImc+"\n\n"
                                + "moins de 18,5  Insuffisance pondérale (maigreur)\n"
                +"18,5 à 25  Corpulence normale\n"+
                                "<html><font color='red'>25 à 30  Surpoids</font></html>\n"+
                                "30 à 35  Obésité modérée\n"+
                                "35 à 40  Obésité sévère\n"+
                                "plus de 40  Obésité morbide ou massive\n","Résultat",0);
                    }
                        
                                      if(30< res && res<35){
         JOptionPane.showMessageDialog(null,  
                        " Votre Indice de masse corporelle (IMC) est: "+outImc+"\n\n"
                                + "moins de 18,5  Insuffisance pondérale (maigreur)\n"
                +"18,5 à 25  Corpulence normale\n"+
                                "25 à 30  Surpoids\n"+
                                "<html><font color='red'>30 à 35  Obésité modérée</font></html>\n"+
                                "35 à 40  Obésité sévère\n"+
                                "plus de 40  Obésité morbide ou massive\n","Résultat",0);
                    }
                      
                                      
                                      
                if(35< res && res<40){
         JOptionPane.showMessageDialog(null,  
                        " Votre Indice de masse corporelle (IMC) est: "+outImc+"\n\n"
                                + "moins de 18,5  Insuffisance pondérale (maigreur)\n"
                +"18,5 à 25  Corpulence normale\n"+
                                "25 à 30  Surpoids\n"+
                                "30 à 35  Obésité modérée\n"+
                                "<html><font color='red'>35 à 40  Obésité sévère</font></html>\n"+
                                "plus de 40  Obésité morbide ou massive\n","Résultat",0);
                    }
                
                       if(res>40){
         JOptionPane.showMessageDialog(null,  
                        " Votre Indice de masse corporelle (IMC) est: "+outImc+"\n\n"
                                + "moins de 18,5  Insuffisance pondérale (maigreur)\n"
                +"18,5 à 25  Corpulence normale\n"+
                                "25 à 30  Surpoids\n"+
                                "30 à 35  Obésité modérée\n"+
                                "35 à 40  Obésité sévère\n"+
                                "<html><font color='red'>plus de 40  Obésité morbide ou massive</font></html>\n","Résultat",0);
                    }
                    }  
                   
             
    }
    

       

