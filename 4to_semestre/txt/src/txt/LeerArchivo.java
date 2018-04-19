/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package txt;

import java.io.*;

/**
 *
 * @author Juan Ca
 */
public class LeerArchivo {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        File ARCHIVO = new File("texto.txt");
        System.out.println(ARCHIVO.canRead());
        System.out.println(ARCHIVO.length());
        
        FileReader ARCHIVO_LEER = new FileReader(ARCHIVO);
        
        BufferedReader MEMORIA_LECTURA = new BufferedReader(ARCHIVO_LEER);
        
        String LINEA = null;
        
        while((LINEA = MEMORIA_LECTURA.readLine()) != null){
            System.out.println(LINEA);
        }
    }
}
