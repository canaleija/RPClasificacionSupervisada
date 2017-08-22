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

    ArrayList<PatronRepresentativo> medias;
    
    public MinimaDistancia(){
       this.medias = new ArrayList<PatronRepresentativo>();
    }
    @Override
    public void entrenar(ArrayList<Patron> instancias) {
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
    System.out.println();
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
            }
        }
        
    }
    
    public void clasificaConjunto (ArrayList<Patron> patrones){
    
       for (Patron aux: patrones){
           clasifica(aux);
       }
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
    
}
