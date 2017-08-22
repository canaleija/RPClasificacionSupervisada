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
       
        Patron p1 = new Patron(new double[]{2.3,21},"A");
        Patron p2 = new Patron(new double[]{3.4,2.1},"A");
        Patron p3 = new Patron(new double[]{1,2},"B");
        Patron p4 = new Patron(new double[]{3,4},"B");
        Patron p5 = new Patron(new double[]{5,6},"B");
        Patron p6 = new Patron(new double[]{4.5,8.98},"C");
        Patron p7 = new Patron(new double[]{7.6,5.6},"C");
        Patron pDes = new Patron(new double[]{3.1,4.2},"desconocido");
       
         
        
        ArrayList<Patron> aux = new ArrayList<>();
        aux.add(p1);
        aux.add(p2);
        aux.add(p3);
        aux.add(p4);
        aux.add(p5);
        aux.add(p6);
        aux.add(p7);
        
        MinimaDistancia md = new MinimaDistancia();
        md.entrenar(aux);
        md.clasifica(pDes);
        System.out.println();
    }
    
}
