/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.ArrayList;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Instancias {
   
    private ArrayList<Patron> patrones;
    private ArrayList<String> clases;
    private ArrayList<Integer> cantidades;

    public Instancias() {
        this.patrones = new ArrayList<>();
        this.cantidades = new ArrayList<>();
        this.clases = new ArrayList<>();
    }
    
    public void agregarPatron(Patron patron){
        // agregamos el nuevo patron 
        this.patrones.add(patron);
        if (!existe(patron.getClase())){
          this.clases.add(patron.getClase());
          this.cantidades.add(0);
          // acumulamos
          acumular(this.clases.indexOf(patron.getClase()));
        }else{
         // acumulamos 
         acumular(this.clases.indexOf(patron.getClase()));
         
        }
        // contar en su respectivo contador
        
        // verificar si ya existe la clase
    }

    private boolean existe(String clase) {
       return this.clases.contains(clase);
    }

    private void acumular(int indexOf) {
       this.cantidades.set(indexOf, this.cantidades.get(indexOf)+1);
              
    }
    
    
    
}
