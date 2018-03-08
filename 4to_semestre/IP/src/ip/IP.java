/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author Juan Ca
 */
public class IP {

    /**
     * @param args the command line arguments
     * @throws java.net.UnknownHostException
     */
    public static void main(String[] args) throws UnknownHostException {
        InetAddress IP = InetAddress.getLocalHost();
        System.out.println("IP of my system is := "+IP.getHostAddress());
    }
    
}
