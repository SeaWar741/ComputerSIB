/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cashier;
import java.util.*;
/**
 *
 * @author Juan Ca
 */
public class Program extends Cashier{
    private static Cashier Cashier;
    
    public static void initialize(String[] args) {
        Cashier = new Cashier();
    }
    public static void run(){
        Scanner keyboard = new Scanner(System.in);
        int X;
        X = 0;
        Cashier.questions();
        while(X == 0){
            if(CLIENT.length() == 16 && PASSWORD.length() == 4){ //lenght
                System.out.println();
                switch(FIRST){
                    case 0:
                        System.out.println();
                        Cashier.fundation();
                        Cashier.extract_money();
                    case 1:
                        System.out.println();
                        Cashier.fundation();
                        Cashier.deposit();
                    case 2:
                        System.out.println();
                        Cashier.fundation();
                        Cashier.transfer();
                    case 3:
                        System.out.println();
                        System.out.println(+BALANCE); //revisar 
                }
            }
            else{
                System.out.println("ERROR");
                System.out.println();
            }
            System.out.println();
            System.out.println("Would you like to perform another task?");
            System.out.println();
            System.out.println("Enter 0 to continue or 1 to close the session");
            System.out.println();
            System.out.printf(">");
            X = keyboard.nextInt();
            }
        //cash.close
        }
    }






































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































