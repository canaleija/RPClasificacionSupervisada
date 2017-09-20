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
    
        Grafica grafica = new Grafica("Comparación","%","Comparación Rendimientos");
        grafica.agrearSerie("md");
        grafica.agrearSerie("knn");
        
        MinimaDistancia md = new MinimaDistancia();
        Knn knn = new Knn(4);
        
        // crear las comparaciones 
        for (int x=0; x<10;x++){
            
            //  entrenar
            GeneradorInstancias ge = new GeneradorInstancias(Tokenizador.inst);
            
            ArrayList<Patron> ce = ge.generaInstancia(new int[]{0,1,2,3}, x*10, FactorSeleccion.RANDOM);
            md.entrenar(ce);
            knn.entrenar(ce);
            // clasificar 
            md.clasificaConjunto(Tokenizador.inst.getPatrones());
            double renMd = md.getRendimiento();
            grafica.agregarDatoASerie("md",new XYDataItem(x, renMd));
       
            knn.clasificaConjunto(Tokenizador.inst.getPatrones());
            double renKnn = knn.getRendimiento();
            grafica.agregarDatoASerie("knn", new XYDataItem(x, renKnn));
        }
        
        grafica.crearYmostrarGrafica();
       
        System.out.println();
    }
    
}
