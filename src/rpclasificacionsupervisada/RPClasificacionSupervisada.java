/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpclasificacionsupervisada;

import clasificadores.Knn;
import clasificadores.MinimaDistancia;
import herramientas.FactorSeleccion;
import herramientas.GeneradorInstancias;
import herramientas.Tokenizador;
import java.util.ArrayList;
import modelos.Instancias;
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
       
         
        
        Tokenizador.leerInstancias();
        Knn knn = new Knn(15);
        knn.entrenar(Tokenizador.inst.getPatrones());
        knn.clasifica(Tokenizador.inst.getPatrones().get(40));
//        GeneradorInstancias gi = new GeneradorInstancias(aux);
//        ArrayList<Patron> nuevas = gi.generaInstancia(new int[]{0,3},90, FactorSeleccion.RANDOM);
//        System.out.println();
                
//        MinimaDistancia md = new MinimaDistancia();
//        md.entrenar(aux);
//        md.clasificaConjunto(aux);
       
        System.out.println();
    }
    
}
