/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Jose
 */
public class Generador {
    /*
X0 = la semilla (X0 > 0)
a= el multiplicador (a>0)
c= constante aditiva (c>0)
m= el modulo (m>X0  , m>a y m>c)
    */
    private float seed;//semilla
    private float a;//multiplicador
    private float c;//constante aditiva
    private float m;//modulo
    private float ultimoRandom;
    private float ultimaSemilla;
    /*
Lineal:
N=m=2^g
a=1+4k
g y k relativamente primos
ri=Xi/m
g y k enteros positivos
    
    -----------
    Cuando se quiere construir un generador de números aleatorios para simular los
valores de una variable aleatoria, se deben elegir los parámetros de tal manera
que se garantice un periodo largo para que se puedan hacer todos los ensayos de
simulación, por lo tanto se deben tener en cuenta las siguientes condiciones:
• a debe ser un número impar, no divisible ni por 3 ni por 5.
• c usualmente puede ser cualquier constante, sin embargo, para asegurar
buenos resultados, se debe seleccionar a de tal forma que, a mod 8 = 5 para
una computadora binaria, o a mod 200 = 21 para computadora decimal.
• m debe ser el número entero más grande que la computadora acepte.
De acuerdo con Hull y Dobell, los mejores resultados para un generador
congruencial mixto en una computadora binaria son:
• c = 8*a±3
• a = cualquier entero
• X0 = Cualquier entero impar.
• M = 2b
 donde b >2 y que m sea aceptado por la computadora. 
    */

    public Generador(float seed, float a, float c, float m) {
        this.seed = seed;
        this.a = a;
        this.c = c;
        this.m = m;
    }
    
       
    public float nextRandom(){
        ultimaSemilla = ( a*ultimaSemilla  + c) % m; //divido
        float rnd = ultimaSemilla/(m);
        return rnd;
    }
    
    
    

    //usar 2 contructores y 2 metodos para generar los numeros    
}
