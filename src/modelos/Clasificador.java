/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import herramientas.MatrizConfusion;
import java.util.ArrayList;

/**
 *
 * @author Roberto Cruz Leija
 */
public interface Clasificador {
    
    public void entrenar(ArrayList<Patron> instancias);
    public void clasifica(Patron patron);
    public void clasificaConjunto(ArrayList<Patron> conjunto);
    public double getRendimiento();
    public MatrizConfusion getMatriz();
}
