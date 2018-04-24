/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encrypt;

import static java.util.Objects.hash;

/**
 *
 * @author Juan Ca
 */
public class Encrypt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(getHash(algorithmencrypt("olita"),"Sha1"));
        String hola = getHash(algorithmencrypt("informatica"),"Sha1");
        System.out.println(hola);
    }
    
    public static String encryption(String txt){
        String encrypted = getHash(algorithmencrypt(txt),"Sha1");
        return encrypted;
    }
    
    public static String algorithmencrypt(String txt){
        String password = String.valueOf(hash(txt + "seawar741seawar741"));
        return password;
    }
    
    private static String getHash(String txt, String hashType){
        try{
            java.security.MessageDigest md = java.security.MessageDigest.getInstance(hashType);
            byte[] array = md.digest(txt.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < array.length; ++i){
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
}
