/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javafx.scene.text.Text;

/**
 *
 * @author 21621
 */
public class Regime {
     private int id;
    private String AlimentsAutorises;
    private String AlimentsInterdits;
    private String PetitDejeuner;
     private String Collation1;
    private String Dejeuner;
    private String Collation2;
    private String Diner;
    private String Conseils;

   


 public Regime() {

    }
 public Regime(int id, String AlimentsAutorises, String AlimentsInterdits, String PetitDejeuner, String Collation1, String Dejeuner, String Collation2, String Diner, String Conseils) {
        this.id = id;
        this.AlimentsAutorises = AlimentsAutorises;
        this.AlimentsInterdits = AlimentsInterdits;              
        this.PetitDejeuner = PetitDejeuner;                                          
        this.Collation1 = Collation1;
        this.Dejeuner = Dejeuner;
        this.Collation2 = Collation2;
        this.Diner = Diner;
        this.Conseils = Conseils;


        

  

    }

    public Regime(int i, String dazdazd, String pompes, String _dazdqsdqs, String dqsdqs, String qsd, String azd, String adzz) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


 public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlimentsAutorises() {
        return AlimentsAutorises;
    }

    public void setAlimentsAutorises(String AlimentsAutorises) {
        this.AlimentsAutorises = AlimentsAutorises;
    }

    public String getAlimentsInterdits() {
        return AlimentsInterdits;
    }

    public void setAlimentsInterdits(String AlimentsInterdits) {
        this.AlimentsInterdits = AlimentsInterdits;
    }

    public String getPetitDejeuner() {
        return PetitDejeuner;
    }

    public void setPetitDejeuner(String PetitDejeuner) {
        this.PetitDejeuner = PetitDejeuner;
    }

    public String getCollation1() {
        return Collation1;
    }

    public void setCollation1(String Collation1) {
        this.Collation1 = Collation1;
    }

    public String getDejeuner() {
        return Dejeuner;
    }

    public void setDejeuner(String Dejeuner) {
        this.Dejeuner = Dejeuner;
    }

    public String getCollation2() {
        return Collation2;
    }

    public void setCollation2(String Collation2) {
        this.Collation2 = Collation2;
    }

    public String getDiner() {
        return Diner;
    }

    public void setDiner(String Diner) {
        this.Diner = Diner;
    }

    public String getConseils() {
        return Conseils;
    }

    public void setConseils(String Conseils) {
        this.Conseils = Conseils;
    }

  

   
 
   
   
 
 
 

}




















