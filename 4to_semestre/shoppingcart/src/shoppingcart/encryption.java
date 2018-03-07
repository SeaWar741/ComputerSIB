/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppingcart;

import static java.util.Objects.hash;

/**
 *
 * @author Juan Ca
 */
public class encryption {
    
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
    
    public encryption(String txt){
        txt = algorithmencrypt(txt);
        System.out.println(txt);
    }

}
