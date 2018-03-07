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
	try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                String[] usp = new String[] {"","",""};
                usp = sCurrentLine.split(",");
                System.out.println(Arrays.toString(usp));

                //hmap.put{usp[0],usp[1],usp[2]};
            }
        }
    }            
}
