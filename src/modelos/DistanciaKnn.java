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
public class DistanciaKnn {
    private double distancia;
    private String clase;

    public DistanciaKnn(){
        this.distancia = 0;
        this.clase = "Desconocida";
    }
    public DistanciaKnn(double distancia, String clase) {
        this.distancia = distancia;
        this.clase = clase;
    }

    /**
     * @return the distancia
     */
    public double getDistancia() {
        return distancia;
    }

    /**
     * @param distancia the distancia to set
     */
    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    /**
     * @return the clase
     */
    public String getClase() {
        return clase;
    }

    /**
     * @param clase the clase to set
     */
    public void setClase(String clase) {
        this.clase = clase;
    }
    
    
    
}
