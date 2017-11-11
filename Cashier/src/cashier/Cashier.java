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
public class Cashier {
        //variable definition}
	public static int TOTALCMONEY = 100000;
	public static int BALANCE = 250000;
        public static int BALANCERETRIEVE = 0;
        public static int BALANCEDEPOSIT = 0;
        public static int BALANCETRANSFER = 0;
	public static String TRY = "Try again";
        public static int FIRST = 0;
        public static int SECOND = 0;
        public static int IDTRANS = 0;
	public static int TRANSB = 0;
	public static String CLIENT;
	public static String PASSWORD;
        public static int FUNDATION = 0;
	public static int FUNDATIONM = 0;
        
    public static void main(String[] args) {
        System.out.println("Hola");

       
    }
    
    public static void questions(){
        Scanner keyboard = new Scanner(System.in);
        String PROMT;
        PROMT = ">";
        System.out.println("Welcome to LJD Bank");
        System.out.println("Insert Bank account");
        System.out.println();
        System.out.printf(PROMT);
        CLIENT = keyboard.nextLine(); //to be defined by user
        System.out.println();
        if(CLIENT.length() == 16){ //lenght
            System.out.println("Insert NIP");
            System.out.printf(PROMT);
            PASSWORD = keyboard.nextLine();
            System.out.println();
            if(PASSWORD.length() == 10){ //lenght
                System.out.println("Welcome to your account user" +CLIENT);
            }
            else{
                System.out.println(TRY);
            }    
        }
        else{
            System.out.println(TRY);
        }
    }
    
    public static void options(){
        int WAIT;
        int MILIS;
        Scanner keyboard = new Scanner(System.in);
        String PROMT;
        PROMT = ">";
        System.out.println("Option menu:");
        System.out.println("0. Get cash");
        System.out.println("1. Deposit");
        System.out.println("2. Transfer");
        System.out.println("3. Balance check");
        System.out.println();
        System.out.println(PROMT);
        FIRST = keyboard.nextInt();
        switch(FIRST){
            case 0:
                System.out.println("PLease insert the amount of money that you want to retrieve");
                System.out.println();
                System.out.printf("> $");
                BALANCERETRIEVE = keyboard.nextInt();
            case 1:
                System.out.println("Please insert the amout of money to deposit");
                System.out.println();
                System.out.printf("> $");
                BALANCETRANSFER = keyboard.nextInt();
            case 2:
                System.out.println("Insert the account number to make the transfer");
                System.out.println();
                System.out.printf("> $");
                IDTRANS = keyboard.nextInt();
            case 3:
                System.out.println("Chekcing your account Balance");
                System.out.println("Please wait");
                WAIT = 0;
                while(WAIT != 0){
                    WAIT ++;
                    //sleep();
                    System.out.println(".");
                }
                System.out.println();
                System.out.println("Your current balance is $"+BALANCE);
        }
    }
    public static void extract_money(){
        TOTALCMONEY -= BALANCERETRIEVE;
        BALANCE -= BALANCERETRIEVE;
    }
    
    public static void deposit(){
        TOTALCMONEY += BALANCETRANSFER;
        BALANCE += BALANCETRANSFER;
    }
    
    public static void fundation(){
        Scanner keyboard = new Scanner(System.in);
        String STR;
        System.out.println("Would you like to donate to LDJ bank? (y/n)");
        System.out.println();
        STR = keyboard.nextLine();
        if(STR == "y"){
            System.out.println();
            System.out.println("Insert the amount to donate");
            System.out.println();
            System.out.printf("> $");
            FUNDATION = keyboard.nextInt();
            FUNDATIONM += FUNDATION;
            BALANCE -= FUNDATION;
            System.out.println("Thank you for donating!");
        }
        else if(STR == "n"){
            System.out.println();
        }
        System.out.println("We'll continue with the operation");
        System.out.println();
        //sleep
        System.out.println("Done");
    }
    public static void transfer(){
        Scanner keyboard = new Scanner(System.in);
        if(IDTRANS == 16){ //length
            System.out.println();
            System.out.println("Insert the amount to transfer");
            System.out.println();
            System.out.printf("> $");
            TRANSB += BALANCETRANSFER;
            BALANCE -= BALANCETRANSFER;
            System.out.println(BALANCE);
        }
        else{
            System.out.println("Not a valid account");
        }
    }
    
    public static void close(){
        System.out.println("Thank you for choosing our Bank");
        System.out.println();
        System.out.println("farewell user " +CLIENT);
    }
}
