/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leer_archivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author Juan Ca
 */
public class Leer_archivos {

    /**
     * @param args the command line arguments
     */
    private static final String FILENAME = "texto.txt";
    public static void main(String[] args) throws IOException {
        // TODO code application logic her
        HashMap<String, String> hmap = new HashMap<>();
        HashMap<String, String> security = new HashMap<>();
	try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null && !"".equals(sCurrentLine = br.readLine())) { // se hara una lectura, añadiendo la cdontraseña, usuario y respuesta a pregunta de seguridad dentro de dos hash(security y hmap)
                String[] usp = new String[3];
                usp = sCurrentLine.split(",");
                System.out.println(Arrays.toString(usp));
                String user = usp[0];
                String pass = usp[1];
                String ans = usp[2];
                hmap.put(user,pass);
                security.put(user,ans);
            }
        }
    }            
}
