/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.confecciones.logica;

import co.edu.sena.confecciones.persistencia.ControladoraPersistencia;
import java.util.List;



/**
 *
 * @author SEBAS
 */

public class Controladora {
    
  ControladoraPersistencia controladoraPersistencia = new ControladoraPersistencia();
  
  
  
  public void registrarModista(Modista m){
      
      controladoraPersistencia.registrarModista(m);
  }
  
  public List<Modista>listarModistas(){
      
      return controladoraPersistencia.listarModistas();
      
  }
  
}
