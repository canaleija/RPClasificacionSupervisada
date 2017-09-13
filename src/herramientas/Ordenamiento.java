/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import java.util.ArrayList;
import modelos.DistanciaKnn;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Ordenamiento {
    
    public static void ordenarBurbujaOpt(ArrayList<DistanciaKnn> distancias){
       for(int i = 0; i < distancias.size()- 1; i++)
            {
            for(int j = 0; j < distancias.size() - i - 1; j++)
                 { 
                 // verificar si la distancia en j es mayor a la dist j +1                           
                if (distancias.get(j).getDistancia() > distancias.get(j+1).getDistancia())
                {
                    DistanciaKnn tmp = new DistanciaKnn(distancias.get(j+1).getDistancia(),
                                              distancias.get(j+1).getClase());
                   
                    distancias.set(j+1, new DistanciaKnn(
                                   distancias.get(j).getDistancia(),
                                   distancias.get(j).getClase()));
                   
                    distancias.set(j,new DistanciaKnn(tmp.getDistancia(), tmp.getClase()));
                    tmp = null;
                }
            }
        }
    
    }
    
}
