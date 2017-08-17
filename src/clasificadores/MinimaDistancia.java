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
    System.out.println();
    }

    @Override
    public String clasifica(Patron patron) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
