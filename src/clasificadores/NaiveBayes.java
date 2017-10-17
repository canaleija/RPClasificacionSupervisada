/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificadores;

import herramientas.Tokenizador;
import java.util.ArrayList;
import modelos.Clasificador;
import modelos.Patron;

/**
 *
 * @author Roberto Cruz Leija
 */
public class NaiveBayes implements Clasificador{

    // probabilidades a priori
    private double[] aprioris;
    
    @Override
    public void entrenar(ArrayList<Patron> instancias) {
       int numClases =  Tokenizador.inst.getClases().size();
       int contador [] = new int[numClases];
       double medias [][] = new double[numClases][instancias.get(0).getVectorCa().length];
       double varianzas[][] = new double[numClases][instancias.get(0).getVectorCa().length];
       // contar el numero de instancias por clase 
       for(int x=0; x< instancias.size();x++){
          int pos = Tokenizador.inst.getClases().indexOf(instancias.get(x).getClase());
          contador[pos]++;
       }
       this.aprioris = new double[numClases];
              
       // calcular a prioris
       for(int j=0; j < this.aprioris.length;j++)
           this.aprioris[j] = (double)contador[j]/(double)instancias.size();
          
       System.out.println();
      
      // calcular medias
      // calcular varianza 
      
    }

    @Override
    public void clasifica(Patron patron) {
       // calcuar matriz de ditribucion  
       // calcular evidencia
       // calcular las diferentes probabilidades posterioris
       // seleccionas la mayor de las posterioris para definir la clase resultante
       
    }
    
}
