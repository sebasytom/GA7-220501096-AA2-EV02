/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.confecciones.persistencia;

import co.edu.sena.confecciones.logica.Modista;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SEBAS
 */

public class ControladoraPersistencia {
    
    ModistaJpaController modistaJpaController = new ModistaJpaController(); 
    
    public void registrarModista(Modista m){
        
        try {
            modistaJpaController.create(m);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
}
        
    public List<Modista> listarModistas(){
        
       return modistaJpaController.findModistaEntities();
    }
        
}   
 
    
