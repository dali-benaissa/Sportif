/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;

/**
 * 
 * @author 21621
 */
public class Books {
    private int id ;
    private String code_exercice;
    private String mouvement;
    private String description;

    public Books(int id, String code_exercice, String mouvement, String description) {
        this.id = id;
        this.code_exercice = code_exercice;
        this.mouvement = mouvement;
        this.description = description;
    }

    public String getCode_exercice() {
        return code_exercice;
    }

    public String getMouvement() { 
        return mouvement;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
}
