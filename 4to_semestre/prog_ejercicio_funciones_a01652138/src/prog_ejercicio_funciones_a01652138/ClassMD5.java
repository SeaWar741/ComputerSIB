/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog_ejercicio_funciones_a01652138;

/**
 *
 * @author Juan Ca
 */
import java.security.*;
import java.math.BigInteger;
import java.util.Scanner;

public class ClassMD5 {
    public static void encrypt(){
        Scanner keyboard = new Scanner(System.in);
        Scanner key = new Scanner(System.in);
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("[1]MD5");
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("[2]SHA1");
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        int selection = keyboard.nextInt();
        System.out.println("");
        System.out.println("Ingresar palabra");
        String text = key.nextLine();
        String word = "La palabra encriptada es: ";
        switch(selection){
            case 1:
                System.out.println(word +getMD5(text));
                break;
            case 2:
                System.out.println(word +getSHA1(text));
                break;
            default:
                System.out.println("No es valido");
                break;
        }
                
        
    }
    
    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getSHA1(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA1");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}

