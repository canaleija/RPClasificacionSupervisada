/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptron;

import java.util.ArrayList;
import modelos.Patron;

/**
 *
 * @author Roberto Cruz Leija
 */
public class PerceptronDelta {
    
    private ArrayList<Patron> instancias;
    private double pesos[];
    private double umbral;
    private double alpha;
    private double sumatoria;

    public PerceptronDelta(double pesos[],double alpha,double umbral) {
        this.umbral = umbral ;
        this.alpha = alpha;
        this.pesos = pesos;
        sumatoria=0;
        this.instancias = null;
    }

    public PerceptronDelta(double alpha) {
        this.alpha = alpha;
        this.umbral = Math.random();
        sumatoria=0;
        this.instancias = null;
        this.pesos = null;
        
    }
    
    public boolean entrenar (ArrayList<Patron> instancias){
      this.instancias = instancias;
      if (pesos==null){
       // TODO: inicializar los pesos aleatoriamente
      
      }
      
     
      int c = 1, i=0;
      while(c<instancias.size()){
      // recorremos las instancias
      int k=1;
      for (Patron aux: this.instancias){
       int y = clasifica(aux);
       if(y==Integer.parseInt(aux.getClase())){
         // no calcula deltas
        c++;
        k++;
       }else{
        // ajustar pesos y umbral 
        
        for(int w=0;w<pesos.length;w++){
          pesos[w]+= alpha*((Integer.parseInt(aux.getClase())-y))*aux.getVectorCa()[w];
        }
        
        umbral += alpha*(Integer.parseInt(aux.getClase())-y)*-1;
        c=1;
       }
      
      }
      i++;
      System.out.println(i+"--: "+k);
      }
        
      return true;
    }
    
    public int clasifica(Patron patron){
        // acumulado
        for (int x=0;x<patron.getVectorCa().length;x++)
            this.sumatoria+=(patron.getVectorCa()[x]*this.pesos[x]);
                    
        if (this.sumatoria>=this.umbral){
          return 1;
        }else {
        return 0;
        }
        // verificamos si es mayor o igual que el umbral
        
    
    }
            
    
    
    
    
    
    
}
