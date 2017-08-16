/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import java.util.ArrayList;
import modelos.Patron;

/**
 *
 * @author Roberto Cruz Leija
 */
public class GeneradorInstancias {
    
    private ArrayList<Patron> instanciaOriginal;

    public GeneradorInstancias(ArrayList<Patron> instanciaOriginal) {
        this.instanciaOriginal = instanciaOriginal;
    }
    
    public ArrayList<Patron> generarInstancia(int[] caracteristicas){
        // será las nuevas instancias
        ArrayList<Patron> nuevaInstancia = new ArrayList<>();
        
        // recorrer mis instancia original para generar el filtrado (a las nuevas)
        for (Patron patron: this.instanciaOriginal){
            // procesar cada uno de los patrones
             String nombreClase = patron.getClase();
             double[] vector = patron.getVectorCa();
        
             double[] vectorNuevo = new double[caracteristicas.length];
            // recorrer los indices de la caracteristicas de interes 
            for(int x=0; x < caracteristicas.length;x+=1){
               vectorNuevo[x]=vector[caracteristicas[x]];
            } 
            nuevaInstancia.add(new Patron(vectorNuevo, nombreClase));
        }
     return nuevaInstancia;
    }
    
    
    
}
