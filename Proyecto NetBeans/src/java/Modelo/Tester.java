/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Random;

/**
 *
 * @author Jose
 */
public class Tester {
    private int cantidadIntervalos;
    private int cantidadNumeros;

    public Tester (int cantidadIntervalos, int cantidadNumeros) {
        this.cantidadIntervalos = cantidadIntervalos;
        this.cantidadNumeros = cantidadNumeros;
    }
    
    public int[] generarTablaFrecuenciasLenguaje(){
        int[] tablaFrencuencias = new int[cantidadIntervalos];
        Random rnd = new Random();
        float numeroAleatorio =  rnd.nextFloat();
                
        for (int i = 0; i < cantidadNumeros; i++) {
            
            for (int j = 0; j < cantidadIntervalos; j++) {
                double limiteSuperior = ((double) (1+j)/ (double)cantidadIntervalos);
            
                if (numeroAleatorio < limiteSuperior ) {
                    tablaFrencuencias[j]++;
                    break;
                }
            }
            numeroAleatorio =  rnd.nextFloat();
              
 
        }

        return tablaFrencuencias;
    }
    
    
    public int[] generarTablaFrecuenciasPropio(){
        int[] tablaFrencuencias = new int[cantidadIntervalos];
            /*
X0 = la semilla (X0 > 0)
a= el multiplicador (a>0)
c= constante aditiva (c>0)
m= el modulo (m>X0  , m>a y m>c)
            */
        Generador rnd = new Generador(13,11,91, cantidadNumeros);
        float numeroAleatorio =  rnd.nextRandom();
                
        for (int i = 0; i < cantidadNumeros; i++) {
            for (int j = 0; j < cantidadIntervalos; j++) {
                double limiteSuperior = ((double) (1+j)/ (double)cantidadIntervalos);
            
                if (numeroAleatorio < limiteSuperior ) {
                    tablaFrencuencias[j]++;
                    break;
                }
            }
            numeroAleatorio =  rnd.nextRandom();
              
 
        }

        return tablaFrencuencias;
    }
    
}
