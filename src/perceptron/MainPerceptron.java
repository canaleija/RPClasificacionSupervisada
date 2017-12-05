/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptron;

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
        PerceptronDelta pd = new PerceptronDelta(new double[]{-8.7,-67.01}, 15, 0.3);
        ArrayList<Patron> instancias = new ArrayList<>();
        instancias.add(new Patron(new double[]{0,0},"0"));
        instancias.add(new Patron(new double[]{1,0},"1"));
        instancias.add(new Patron(new double[]{0,1},"1"));
        instancias.add(new Patron(new double[]{1,1},"1"));
        pd.entrenar(instancias);
        System.out.println();
    }
    
}
