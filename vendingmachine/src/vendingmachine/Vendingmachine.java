/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;
import java.util.*;

/**
 *
 * @author Juan Ca
 */
public class Vendingmachine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        // TODO code application logic here
        int MONEY;
        int QUARTERS;
        int DIME;
        int NICKLES;
        int PENNIES;
        
        QUARTERS = 0;
        DIME = 0;
        NICKLES = 0;

        System.out.println("Insert the requierd money:");
        System.out.printf("$");
        MONEY = keyboard.nextInt();
        if (MONEY >0 && MONEY <=99){
            while (MONEY >= 25){
                QUARTERS = QUARTERS + 1;
                MONEY = MONEY - 25;
            }
            while (MONEY >= 10){
                DIME = DIME + 1;
                MONEY = MONEY - 10;
            }
             while (MONEY >= 5){
                NICKLES = NICKLES + 1;
                MONEY = MONEY - 5;
            }
            PENNIES = MONEY;
            System.out.println();
            System.out.printf("AMOUNT OF QUARTERS:" +QUARTERS);
            System.out.println();
            System.out.printf("AMOUNT OF DIMES:" +DIME);
            System.out.println();
            System.out.printf("AMOUNT OF NICKLES:" +NICKLES);
            System.out.println();
            System.out.printf("AMOUNT OF PENNIES:"  +PENNIES);
            System.out.println();
        }
        else {
            System.out.println("not a valid amount");
        }
    }
 }
    

