/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpclasificacionsupervisada;

import clasificadores.Knn;
import clasificadores.MinimaDistancia;
import clasificadores.NaiveBayes;
import herramientas.FactorSeleccion;
import herramientas.GeneradorInstancias;
import herramientas.Grafica;
import herramientas.Tokenizador;
import java.util.ArrayList;
import modelos.Instancias;
import modelos.Patron;
import org.jfree.data.xy.XYDataItem;

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
         GeneradorInstancias ins = new GeneradorInstancias(Tokenizador.inst);
          NaiveBayes bayes = new NaiveBayes();
          bayes.entrenar(Tokenizador.inst.getPatrones());
//         MinimaDistancia md = new MinimaDistancia();
//         Knn knn = new Knn(3);
//         md.entrenar(Tokenizador.inst.getPatrones());
//         md.clasificaConjunto(Tokenizador.inst.getPatrones());
//         md.getMatriz().mostrarMatriz();
//         knn.entrenar(Tokenizador.inst.getPatrones());
//         knn.clasificaConjunto(Tokenizador.inst.getPatrones());
//         knn.getMatriz().mostrarMatriz();
//        
//         System.out.println();

//            knn.entrenar(ce);
//            md.entrenar(ce);


//        Grafica grafica = new Grafica("Comparación","%","Comparación Rendimientos");
//        grafica.agrearSerie("md");
//        grafica.agrearSerie("knn");
//        
//        MinimaDistancia md = new MinimaDistancia();
//        Knn knn = new Knn(4);
//        
//        // crear las comparaciones 
//        for (int x=0; x<50;x++){
//            
//            //  entrenar
//            GeneradorInstancias ge = new GeneradorInstancias(Tokenizador.inst);
//            
//            ArrayList<Patron> ce = ge.generaInstancia(new int[]{2,3}, 6*x, FactorSeleccion.PRIMEROS);
//            knn.entrenar(ce);
//            md.entrenar(ce);
//          
//            
//            knn.clasificaConjunto(ce);
//            double renKnn = knn.getRendimiento();
//            grafica.agregarDatoASerie("knn", new XYDataItem(x, renKnn));
//            //  clasificar 
//            md.clasificaConjunto(ce);
//            double renMd = md.getRendimiento();
//            grafica.agregarDatoASerie("md",new XYDataItem(x, renMd));
//           // System.out.println();
//        }
//        
//        grafica.crearYmostrarGrafica();
//       
//      //  System.out.println();
    }
    
}
