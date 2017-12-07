/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptron;

import herramientas.Tokenizador;
import java.util.ArrayList;
import modelos.Patron;

/**
 *
 * @author Roberto Cruz Leija
 */
public class MainPerceptron {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tokenizador.leerInstancias();
        ArrayList<Patron> instancias = Tokenizador.inst.getPatrones();
        PerceptronDelta pd = new PerceptronDelta(new double[]{0.7,0.1},0.6,0.3);
      
        pd.entrenar(instancias);
        System.out.println();
    }
    
}
