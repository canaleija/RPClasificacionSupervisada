/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Roberto Cruz Leija
 */
public class PatronRepresentativo extends Patron{
    
    private int contador;
    
    public PatronRepresentativo(int n) {
        super(n);
        this.contador = 1;
    }

    public PatronRepresentativo(double[] vector, String clase) {
        super(vector, clase);
        this.contador = 1;
    }

    public PatronRepresentativo(Patron patron) {
        super(patron);
        this.contador = 1;
    }
    
    public void acumular (Patron patron){
    
        // acumular
        for (int x=0; x < super.getVectorCa().length;x++){
           super.getVectorCa()[x]+=patron.getVectorCa()[x];
           
        }
        
         this.contador++;
    }

    /**
     * @return the contador
     */
    public int getContador() {
        return contador;
    }
    
    
    
    
}
