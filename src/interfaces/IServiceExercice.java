/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.Exercice;

/**
 *
 * @author admin
 */
public interface IServiceExercice {
    
    //CRUD
    public void createExercice(Exercice p);
    public List<Exercice> readExercices();
    
}