/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pop_top;

import java.util.Arrays;

/**
 *
 * @author Juan Ca
 */
public class Pop_top {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] cal ={1,2,3,4,5,6,7};
        top(cal);
        System.out.println("");
        pop(cal);
    }
    
    public static void pop(int[] arry){
        if(arry.length >1){
            System.out.println(arry[arry.length-1]);
            arry[arry.length-1] = 0;
        }
        else{
            System.out.println("Error");
        }
        System.out.println(Arrays.toString(arry));
    }
    
    public static void top(int[] arry){
        System.out.println(arry[arry.length-1]);
    }
}
