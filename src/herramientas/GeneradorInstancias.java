/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import java.util.ArrayList;
import java.util.Random;
import modelos.Instancias;
import modelos.Patron;

/**
 *
 * @author Roberto Cruz Leija
 */
public class GeneradorInstancias {
    
    private Instancias instanciaOriginal;

    public GeneradorInstancias(Instancias instanciaOriginal) {
        this.instanciaOriginal = instanciaOriginal;
    }
    
    public ArrayList<Patron> generaInstancia (int[] caracteristicas,double porcentaje,FactorSeleccion factor){
       // filtramos las caracteristicas
       ArrayList<Patron> nuevaInstancia = generarInstancia(caracteristicas);
       
       // en base al factor de seleccion seleccionamos los patrones de la 
       // instancia original 
       switch(factor){
           case RANDOM:{
               // seleccionamos con factor aleatorio en base a un porcentaje
               seleccionaPorcentajeAleatorio(porcentaje,nuevaInstancia);
               break;
           }
           case PRIMEROS:{
               seleccionaPrimeros(porcentaje, nuevaInstancia);
           break;
           }
           case ULTIMOS:{
           break;
           }
           default:{System.out.println("No se reconocer el factor de selección");}
       }
       return nuevaInstancia;
      
    }
    
    public ArrayList<Patron> generarInstancia(int[] caracteristicas){
        // será las nuevas instancias
        ArrayList<Patron> nuevaInstancia = new ArrayList<>();
        
        // recorrer mis instancia original para generar el filtrado (a las nuevas)
        for (Patron patron: this.instanciaOriginal.getPatrones()){
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

    
    private void seleccionaPorcentajeAleatorio(double porcentaje, ArrayList<Patron> nuevaInstancia) {
       
            Random ran = new Random();
            // calcular la cantidad de elementos por clase 
            for (int x = this.instanciaOriginal.getClases().size() - 1; x >= 0; x--) {
                int cantidadEliminar = calculaCantidad(x, porcentaje);
//                int auxRan = instanciaOriginal.getPatrones().size();
                int auxRan = nMaximo(x);
                
                int auxRan1 = nMinimo(x);

              //  System.out.println("");
                for (int y = 0; y < cantidadEliminar; y++) {
//              int pos = ran.nextInt(auxRan);
                    int pos = (int) (Math.random() * (auxRan-auxRan1)) + auxRan1;
                    nuevaInstancia.remove(pos);
                    auxRan--;
                }
            }
        }


    public int calculaCantidad(int id_Clase, double porcentaje) {
        int elementos = this.instanciaOriginal.getCantidades().get(id_Clase);
        int aEliminar = (int)((elementos*porcentaje)/100);
        if (aEliminar>=elementos){
          return elementos-1;
        }
        
        
        return aEliminar;
    }
    
    
    private void seleccionaPrimeros(double cantidad, ArrayList<Patron> nuevaInstancia) {
        int ca = (int) cantidad;
        int tope = 0;
        if (cantidad!=0){
            for (int x=0; x< this.instanciaOriginal.getClases().size();x++){
                int aux = instanciaOriginal.getCantidades().get(x);
                if(aux-cantidad > 0){
                    for(int y=tope; y < ca+tope;y++){
                    nuevaInstancia.remove(tope);
                    }
                    tope = tope + aux - (int)cantidad;
                }else{
                 
                   ca = aux-1; 
                   for(int y=tope; y < ca+tope;y++){
                    nuevaInstancia.remove(tope);
                    }
                    tope = tope + aux - (int)ca;
                }
            }
        }
     //    System.out.println();
    }
    
    

    private int nMinimo(int x) {
        int nm=0;
        for (int i = x; i < instanciaOriginal.getCantidades().size(); i++) {
            nm=nm+instanciaOriginal.getCantidades().get(i);
        }
        nm=instanciaOriginal.getPatrones().size()-nm;
        return nm;
    }

    private int nMaximo(int x) {
        int nma = 0;
        for (int i = 0; i <= x; i++) {
            nma=nma+instanciaOriginal.getCantidades().get(i);
        }
        return nma;
    }


    
    
    
}
