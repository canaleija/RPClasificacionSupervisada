/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificadores;

import java.util.ArrayList;
import modelos.Clasificador;
import modelos.Patron;
import modelos.PatronRepresentativo;

/**
 *
 * @author Roberto Cruz Leija
 */
public class MinimaDistancia implements Clasificador{

    private ArrayList<PatronRepresentativo> medias;
    private double contadorCorrectos;
    private double rendimiento;
    
    public MinimaDistancia(){
       this.medias = new ArrayList<PatronRepresentativo>();
       this.contadorCorrectos = 0;
    }
    @Override
    public void entrenar(ArrayList<Patron> instancias) {
        contadorCorrectos = 0;
       // recorrer todas las instancias de entrenamiento
       // agregamos la primer media 
       //this.medias.add(new PatronRepresentativo(instancias.get(0)));
    for (Patron patron: instancias){
           int pos = buscarEnMedias(patron);
           if (pos==-1){
               this.medias.add(new PatronRepresentativo(patron));
           }else{
             this.medias.get(pos).acumular(patron);
           }
       }
      // una vez calculados los acumulados se tiene que 
      // calcalar los promedio
      for(PatronRepresentativo media: this.medias){
          int contador = media.getContador();
          for (int x=0; x < media.getVectorCa().length;x++){
            media.getVectorCa()[x]/=contador;
          }
      }
  
    }

    @Override
    public void clasifica(Patron patron) {
       
        // partimos de la hipotesis que pertenece a la primer clase
        double distanciaInicial = patron.calculaDistancia(this.medias.get(0));
        patron.setClase_resultado(this.medias.get(0).getClase());
        // recorrer la coleccion de medias 
        
        for (int x=1; x<this.medias.size();x++){
            double distanciaNueva = patron.calculaDistancia(this.medias.get(x));
            if(distanciaNueva < distanciaInicial){
              patron.setClase_resultado(this.medias.get(x).getClase());
              distanciaInicial =  distanciaNueva;
              // una vez ya clasificado verifico si fue una clasificacion
              // correcta o incorrecta
             
            }
        }
        
         if(patron.getClase().equals(patron.getClase_resultado()))
              {
                  contadorCorrectos++;
              }
        
    }
    
    public void clasificaConjunto (ArrayList<Patron> patrones){
     this.contadorCorrectos = 0;
     this.rendimiento = 0;
       for (Patron aux: patrones){
           clasifica(aux);
       }
       // calcular el % de clasificion correcta
       this.rendimiento = (this.contadorCorrectos/patrones.size())*100;
    }

    private int buscarEnMedias(Patron patron) {
        for(int x=0; x< this.medias.size();x++){
            PatronRepresentativo pr = this.medias.get(x);
            String nombre =  pr.getClase();
            if (nombre.equals(patron.getClase())){
              return x;
            }
        
        }
        return -1;
    }

    /**
     * @return the rendimiento
     */
    public double getRendimiento() {
        return rendimiento;
    }
    
}
