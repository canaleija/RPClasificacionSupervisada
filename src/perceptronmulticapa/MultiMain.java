/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptronmulticapa;

/**
 *
 * @author Roberto Cruz Leija
 */
public class MultiMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RedPerceptron juan = new RedPerceptron();
        double input[][] = new double[][]{{0,0},{0,1},{1,0},{1,1}};
        double t[][] = new double[][]{{0},{0},{0},{1}};
        juan.entrenar(input, t);
        juan.clasifica(new double[]{0,0});
        juan.clasifica(new double[]{0,1});
        juan.clasifica(new double[]{1,0});
        juan.clasifica(new double[]{1,1});
                
    }
    
}
