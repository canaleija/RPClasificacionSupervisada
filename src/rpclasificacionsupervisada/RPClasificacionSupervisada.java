/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpclasificacionsupervisada;

import clasificadores.MinimaDistancia;
import herramientas.GeneradorInstancias;
import herramientas.Tokenizador;
import java.util.ArrayList;
import modelos.Patron;

/**
 *
 * @author Roberto Cruz Leija
 */
public class RPClasificacionSupervisada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
         
        
        ArrayList<Patron> aux = Tokenizador.leerInstancias();
      
        MinimaDistancia md = new MinimaDistancia();
        md.entrenar(aux);
        md.clasificaConjunto(aux);
        System.out.println();
    }
    
}
