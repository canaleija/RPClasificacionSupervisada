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
       
        Patron p1 = new Patron(new double[]{5,3.7},"A");
        Patron p2 = new Patron(new double[]{7,11.3},"A");
        Patron p3 = new Patron(new double[]{7,11.3},"C");
        Patron p4 = new Patron(new double[]{7,11.3},"D");
        Patron p5 = new Patron(new double[]{7,11.3},"C");
        Patron p6 = new Patron(new double[]{7,11.3},"A");
        ArrayList<Patron> aux = new ArrayList<>();
        aux.add(p1);
        aux.add(p2);
        aux.add(p3);
        aux.add(p4);
        aux.add(p5);
        aux.add(p6);
        MinimaDistancia md = new MinimaDistancia();
        md.entrenar(aux);
       System.out.println(p1.calculaDistancia(p2));
    }
    
}
