/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajero;

import static cajero.Cashier.BALANCE; //Balance variable is imported from cashier
import static cajero.Cashier.BALANCEDEPOSIT; //Balancedeposit variable is imported from cashier
import static cajero.Cashier.BALANCERETRIEVE; //Balanceretrieve variable is imported from cashier
import static cajero.Cashier.CLIENT; //Client variable is imported from cashier
import static cajero.Cashier.FIRST; //FIRST variable is imported from cashier
import static cajero.Cashier.PASSWORD; //Password variable is imported from cashier
import static cajero.Cashier.TOTALCMONEY; //cashier money variable is imported from cashier
import java.util.Scanner;

/**
 *
 * @author Juan Ca
 */
public class Program {
    private static Cashier Cashier; //program is son class from Cashier
    
    public static void initialize(String[] args) {
        Cashier = new Cashier(); //a new cashier is initialized
    }
    public static void run() throws InterruptedException{ // Function for running executing the cashier from the Program
        Scanner keyboard = new Scanner(System.in); //Keyboard input initializer
        int X;
        X = 0;
        //Cashier.questions(); //the object cashier runs question function
        Cashier.login();
        System.out.println();
        while(X == 0){ //while the variable x is equal to 0 then
                System.out.println();
                Cashier.options(); //the object cashier runs options function
                switch(FIRST){ //switch for the first operation
                    case 0: //case for extracting money
                        System.out.println();
                        if(BALANCERETRIEVE <= BALANCE && BALANCERETRIEVE <= TOTALCMONEY){ //if the balance that is wanted to be extraced is minor to the balance and the cashier has enough money then it ask for donating and then extracts the money with their respective functions                        
                            Cashier.fundation();
                            Cashier.extract_money();
                        }
                        else{ //if the conditions fail then insufficient balance
                            System.out.println("Insufficient Balance");
                        }
                        break;
                    case 1: //case for depositing money to the account
                        System.out.println();
                        Cashier.fundation();
                        Cashier.deposit();
                        break;
                    case 2: //case for transfering money
                        System.out.println();                      
                        if(BALANCEDEPOSIT <= BALANCE){
                            Cashier.fundation();     
                            Cashier.transfer();                            
                        }
                        else{
                            System.out.println("Insufficient Balance"); //not enough money
                        }
                        break;
                    case 3:
                        System.out.println();
                        break;
                }
            if(CLIENT.length() == 16 && PASSWORD.length() == 4){ //if the account and password are valid then another task can be performed
                System.out.println();
                System.out.println("Would you like to perform another task?");
                System.out.println();
                System.out.println("Enter 0 to continue or 1 to close the session");
                System.out.println();
                System.out.printf(">");
                X = keyboard.nextInt(); //its requested to modify the value of x 
            }
            else{
                X = 1; //if the values arent correct then the program changes the value of x to 1 to terminate the program
            }
        }//end while
        Cashier.close(); //close & terminate the cashier with close function
     }
}
