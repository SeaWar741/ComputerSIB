/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package importclass;

/**
 *
 * @author Juan Ca
 */
public class PruebaEntrada {
    public static void main(String args[]){
        System.out.println("Da un número");
        int numero_entero;
        numero_entero = Entrada.Entero();
        String palabra;
        String resultado;
        System.out.println("numero?");
        int a = Entrada.Entero();
        int b = Entrada.Entero();
        
        System.out.println("el valor introducido es" +(a/b));
        
        System.out.println("palabra?");
        palabra = Entrada.Cadena();
     
        if(a>b){
            System.out.println("El Mayor es" +a);
        }
        else{
            System.out.println("El mayor es"+b);
        }
        //if sin corchete elimina la capacidad de dar multiples instrucciones
        
        resultado = (a>b) ? "El mayor es:"+a: "El mayor es"+b;
        System.out.println(resultado);
    }  
}
