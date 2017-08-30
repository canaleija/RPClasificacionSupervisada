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
        this.getPatrones().add(patron);
        if (!existe(patron.getClase())){
            this.getClases().add(patron.getClase());
            this.getCantidades().add(0);
          // acumulamos
          acumular(this.getClases().indexOf(patron.getClase()));
        }else{
         // acumulamos 
         acumular(this.getClases().indexOf(patron.getClase()));
         
        }
        // contar en su respectivo contador
        
        // verificar si ya existe la clase
    }

    private boolean existe(String clase) {
       return this.getClases().contains(clase);
    }

    private void acumular(int indexOf) {
        this.getCantidades().set(indexOf, this.getCantidades().get(indexOf)+1);
              
    }

    /**
     * @return the patrones
     */
    public ArrayList<Patron> getPatrones() {
        return patrones;
    }

    /**
     * @param patrones the patrones to set
     */
    public void setPatrones(ArrayList<Patron> patrones) {
        this.patrones = patrones;
    }

    /**
     * @return the clases
     */
    public ArrayList<String> getClases() {
        return clases;
    }

    /**
     * @param clases the clases to set
     */
    public void setClases(ArrayList<String> clases) {
        this.clases = clases;
    }

    /**
     * @return the cantidades
     */
    public ArrayList<Integer> getCantidades() {
        return cantidades;
    }

    /**
     * @param cantidades the cantidades to set
     */
    public void setCantidades(ArrayList<Integer> cantidades) {
        this.cantidades = cantidades;
    }
    
    
    
}
