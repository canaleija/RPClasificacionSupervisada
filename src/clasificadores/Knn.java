/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificadores;

import herramientas.Ordenamiento;
import herramientas.Tokenizador;
import java.util.ArrayList;
import modelos.Clasificador;
import modelos.DistanciaKnn;
import modelos.Patron;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Knn  implements Clasificador{

    private ArrayList<Patron> instancias;
    private ArrayList<DistanciaKnn> distancias;
    private int k;
    private double contadorCorrectos;
    private double rendimiento;
    
    
    public Knn(int k) {
         this.distancias = new ArrayList<>();
         this.k = k;
         this.contadorCorrectos = 0;
    }
    
    
    
    @Override
    public void entrenar(ArrayList<Patron> instancias) {
        this.instancias = instancias;
    }

    @Override
    public void clasifica(Patron patron) {
        this.distancias = new ArrayList<>();
     // calcular las distancias
     for(Patron aux: this.instancias){
        double dist = patron.calculaDistancia(aux);
        String clase = aux.getClase();
        if (dist!=0){
           this.distancias.add(new DistanciaKnn(dist, clase)); 
        }
        
     }
     // ordenamos 
     Ordenamiento.ordenarBurbujaOpt(distancias);
     // verificar que clase cumple primero con los k vecinos 
     
     String claseResultado = verificarKvecinos();
     patron.setClase_resultado(claseResultado);
     
       if(patron.getClase().equals(patron.getClase_resultado()))
              {
                  contadorCorrectos++;
              }
       
       System.out.println();
    }
    
    public void clasificaConjunto (ArrayList<Patron> patrones){
     this.contadorCorrectos = 0;
       for (Patron aux: patrones){
           clasifica(aux);
       }
       // calcular el % de clasificion correcta
       this.rendimiento = (this.contadorCorrectos/patrones.size())*100;
    }


    private String verificarKvecinos() {
        int[] contador = new int[Tokenizador.inst.getClases().size()];
        int ip = 0;
        // busco
        cicloBusco:for (DistanciaKnn aux: this.distancias){
            String clase =aux.getClase();
            // cuento 
            int indice = Tokenizador.inst.getClases().indexOf(clase);
            contador[indice]+=1;
           
            //  verifico
            for (int x=0; x< contador.length;x++){
             if(contador[x]==this.k){
                 ip = x;
                 break cicloBusco;
             }
               
             }  
                          
            }
        String clase = Tokenizador.inst.getClases().get(ip);
        return  clase;
        }

    /**
     * @return the rendimiento
     */
    public double getRendimiento() {
        return rendimiento;
    }
     
    }
