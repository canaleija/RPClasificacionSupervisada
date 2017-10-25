/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificadores;

import herramientas.MatrizConfusion;
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
    private double rendimiento;
    private MatrizConfusion matriz;
    
    public Knn(int k) {
         this.distancias = new ArrayList<>();
         this.k = k;
         matriz = new MatrizConfusion(Tokenizador.inst.getClases().size());
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
     
     // mandamos información a la matriz de confusiòn
        int pertenece = Tokenizador.inst.getClases().indexOf(patron.getClase());
        int resultado = Tokenizador.inst.getClases().indexOf(patron.getClase_resultado());
        this.getMatriz().acumula(pertenece, resultado);
        
       
      
    }
    
    public void clasificaConjunto (ArrayList<Patron> patrones){
     
       for (Patron aux: patrones){
           clasifica(aux);
       }
       this.matriz.calculaEficacias();
       // calcular el % de clasificion correcta
       this.rendimiento = this.getMatriz().getEficaciaGeneral();
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

    /**
     * @return the matriz
     */
    public MatrizConfusion getMatriz() {
        return matriz;
    }
     
    }
