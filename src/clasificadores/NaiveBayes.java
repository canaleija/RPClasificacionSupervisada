/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificadores;

import herramientas.Tokenizador;
import java.awt.Dimension;
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
    private Dimension dim;
    private double medias[][];
    private double varianzas[][];

    public NaiveBayes() {
    }
    
    
    @Override
    public void entrenar(ArrayList<Patron> instancias) {
       int numClases =  Tokenizador.inst.getClases().size();
       int contador [] = new int[numClases];
       this.medias = new double[numClases][instancias.get(0).getVectorCa().length];
       this.varianzas = new double[numClases][instancias.get(0).getVectorCa().length];
       this.dim = new Dimension(instancias.get(0).getVectorCa().length, numClases);
               
       // contar el numero de instancias por clase 
       for(int x=0; x< instancias.size();x++){
          int pos = Tokenizador.inst.getClases().indexOf(instancias.get(x).getClase());
          contador[pos]++;
       }
       this.aprioris = new double[numClases];
              
       // calcular a prioris
       for(int j=0; j < this.aprioris.length;j++)
           this.aprioris[j] = (double)contador[j]/(double)instancias.size();
          
    
      // calcular medias
	  int x=0,y=0;
	  for(int i=0;i<numClases;i++){
		  x+=contador[i];
		  for(int j=y;j<x;j++){
			  for(int k=0;k<instancias.get(i).getVectorCa().length;k++){
				  medias[i][k]+=instancias.get(j).getVectorCa()[k];
			  }
		  }
		  y+=contador[i];
                  // dividir entre lo que se conto/entre el numero total
		  for(int k=0;k<instancias.get(i).getVectorCa().length;k++){
			 medias[i][k]/=contador[i];
		}
	  }
           
        // calcular varianza 
        x=0;
        y=0;
	  for(int i=0;i<numClases;i++){
		  x+=contador[i];
		  for(int j=y;j<x;j++){
			  for(int k=0;k<instancias.get(i).getVectorCa().length;k++){
			      double cuadrado = Math.pow((instancias.get(j).getVectorCa()[k]
                                      -medias[i][k]), 2);
                              varianzas[i][k]+=cuadrado;
			  }
		  }
		  y+=contador[i];
                  // dividir entre lo que se conto/entre el numero total
		  for(int k=0;k<instancias.get(i).getVectorCa().length;k++){
			 varianzas[i][k]/=contador[i]-1;
		}
	  }
      
       System.out.println();
      
    }

    @Override
    public void clasifica(Patron patron) {
       int numClases =  Tokenizador.inst.getClases().size();
       // calcuar matriz de ditribucion  
       double distribucionNormal [][] = new double[(int)dim.getHeight()][(int)dim.getWidth()];
       double muestra[] = patron.getVectorCa();
       double evidencia=0;
       for(int c=0;c<numClases;c++){
           double producto = aprioris[c];
           for(int ca=0; ca<dim.getWidth();ca++){
              double varianza = this.varianzas[c][ca]; 
              double media = this.medias[c][ca]; 
              double vdn = (1/(Math.sqrt(2*Math.PI*varianza)))*
                      (Math.exp(-1*((Math.pow(muestra[ca]-media,2))/(varianza*2))));
              distribucionNormal[c][ca]=vdn;
              producto*=distribucionNormal[c][ca];
           }
           evidencia+=producto;
           
       }
       
       
      System.out.println();
       // calcular evidencia
       // calcular las diferentes probabilidades posterioris
       // seleccionas la mayor de las posterioris para definir la clase resultante
       
    }
    
}
