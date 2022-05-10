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
public class Booksregime {
    private int id;

  
    private String aliments_autorises ;
    private String aliments_interdits ;
    private String petit_dejeuner ;
    private String collation1 ;
    private String dejeuner;
    private String collation2;
    private String diner;
    private String conseils;
             
        public Booksregime(int id, String aliments_autorises, String aliments_interdits, String petit_dejeuner, String collation1, String dejeuner, String collation2, String diner, String conseils) {
            
            this.id = id;
            this.aliments_autorises = aliments_autorises;
            this.aliments_interdits = aliments_interdits;
            this.petit_dejeuner = petit_dejeuner;
            this.collation1 = collation1;
            this.dejeuner = dejeuner;
            this.collation2 = collation2;
            this.diner = diner;
            this.conseils = conseils;
    }
        
          public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAliments_autorises() {
        return aliments_autorises;
    }

    public void setAliments_autorises(String aliments_autorises) {
        this.aliments_autorises = aliments_autorises;
    }

    public String getAliments_interdits() {
        return aliments_interdits;
    }

    public void setAliments_interdits(String aliments_interdits) {
        this.aliments_interdits = aliments_interdits;
    }

    public String getPetit_dejeuner() {
        return petit_dejeuner;
    }

    public void setPetit_dejeuner(String petit_dejeuner) {
        this.petit_dejeuner = petit_dejeuner;
    }

    public String getCollation1() {
        return collation1;
    }

    public void setCollation1(String collation1) {
        this.collation1 = collation1;
    }

    public String getDejeuner() {
        return dejeuner;
    }

    public void setDejeuner(String dejeuner) {
        this.dejeuner = dejeuner;
    }

    public String getCollation2() {
        return collation2;
    }

    public void setCollation2(String collation2) {
        this.collation2 = collation2;
    }

    public String getDiner() {
        return diner;
    }

    public void setDiner(String diner) {
        this.diner = diner;
    }

    public String getConseils() {
        return conseils;
    }

    public void setConseils(String conseils) {
        this.conseils = conseils;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
