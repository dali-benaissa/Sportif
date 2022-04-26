 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author admin
 */
public class Exercice {

    
 
 
   

    //var
    private int id;
    private String code_exercice;
    private String mouvement;
    private String description;
 
    //Constructor
    public Exercice() {

    }
    //..

    public Exercice(int id, String code_exercice, String mouvement, String description) {
        this.id = id;
        this.code_exercice = code_exercice;
        this.mouvement = mouvement;
        this.description = description;
        
    }

    //..
    public Exercice(String code_exercice, String mouvement, String description) {
        this.code_exercice = code_exercice;
        this.mouvement = mouvement;
        this.description = description;
        
    }
    
    
    

    public Exercice(int aInt, String string, String string0, int aInt0, String string1, Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //GETTERS & SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode_exercice() {
        return code_exercice;
    }

    public void setCode_exercice(String code_exercice) {
        this.code_exercice = code_exercice;
    }

    public String getMouvement() {
        return mouvement;
    }

    public void setMouvement(String mouvement) {
        this.mouvement = mouvement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
 
 

    @Override
    public String toString() {
        return "Exercice{" + "id=" + id + ", code_exercice=" + code_exercice + ", mouvement=" + mouvement + ", description=" + description +'}';
    }


}





