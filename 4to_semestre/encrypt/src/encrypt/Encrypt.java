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
        System.out.println(getHash(algorithmencrypt("choli"),"Sha1"));
        String hola = getHash(algorithmencrypt("charlott"),"Sha1");
        System.out.println(hola);
    }
    
    public static String algorithmencrypt(String txt){
        String password = String.valueOf(hash(txt + "seawar741seawar741"));
        return password;
    }
    
    public static String getHash(String txt, String hashType){
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
