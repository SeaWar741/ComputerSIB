/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajero;

import java.util.Scanner;

/**
 *
 * @author Juan Ca
 */
public class Cashier {
        //class variable definition(all of them are public in order to be read and modified in the class)
	public static int TOTALCMONEY = 100000; //total cashier money
	public static int BALANCE = 250000; //Account balance(user)
        public static int BALANCERETRIEVE = 0; //Balance that is going to be retrieved
        public static int BALANCEDEPOSIT = 0; //Balance that is going to be deposit
        public static int BALANCETRANSFER = 0; //Balance that is going to be transfered
	public static String TRY = "INCORRECT"; //String for errors
        public static int FIRST; //variable for the first operation
        public static int SECOND = 0; //variable for the second operation
	public static int TRANSB = 0; //Account Balance for the Transfered
	public static String CLIENT; //Client/user ID
	public static String PASSWORD; //Client/user ID
        public static String ACCOUNT; //Account number where the money will be transfered
        public static int FUNDATION = 0; //Fundation transaction
	public static int FUNDATIONM = 0; //Fundation account balance
        public static int RETRY_CLIENT = 0;
        public static int RETRY_NIP = 0;

    public static void questions(){
        Scanner keyboard = new Scanner(System.in);//Scanner is initialized
        String PROMT = ">";
        System.out.println("Welcome to BADAMEX");
        while(RETRY_CLIENT<4){
            System.out.println("Insert Bank account");
            System.out.println();
            System.out.printf(PROMT);
            CLIENT = keyboard.nextLine(); //to be defined by user
            System.out.println();
            if(CLIENT.length() == 16){ //lenght
                RETRY_CLIENT = 5;//this variable is set to 5 breaking the loop when the client is valid
                while(RETRY_NIP < 4){//while the RETRYNIP is less than four then the nip is requested
                    System.out.println("Insert NIP");
                    System.out.printf(PROMT);
                    PASSWORD = keyboard.nextLine();//NIP is requested
                    System.out.println();
                    if(PASSWORD.length() == 4){ //if nip length is equal to 4
                        System.out.println("Welcome to your account user " +CLIENT); //gives welcome
                        RETRY_NIP = 5; //entonces se pone como 5 rompiendo el loop
                    }
                    else if(PASSWORD.length() != 4 && RETRY_NIP == 4){ //if the password length is diferent from 4 and retryNIP is equal to 4 attempts
                        Cashier.close(); //Cashier closes
                    }
                    else if(PASSWORD.length() != 4){// if the NIP Lenght is diferent from 4 then the NIP is requested again, RETRYNIP increases in 1
                        System.out.println(TRY);
                        RETRY_NIP ++; //RetryNIP is increased in one (+1)
                    }
                }
            }
            else if(CLIENT.length() != 16 && RETRY_CLIENT == 4){ //IF the lenght of the user is diferent from 16 and the Retry Client equals then the cashier closes
                Cashier.close();
            } 
            else if(CLIENT.length() != 16){//if the clientlenght is diferent from 16 then the retry client increases in one (+1)
                System.out.println(TRY);
                RETRY_CLIENT ++;
            } 
        }
    }
    
    public static void options() throws InterruptedException{ //options/option menu function
        Scanner keyboard = new Scanner(System.in); //Keyboard input initializer
        int WAIT;
        String PROMT;
        PROMT = ">";//promt sring definition
        System.out.println("Option menu:"); //the different options are displayed per line
        System.out.println("0. Get cash");
        System.out.println("1. Deposit");
        System.out.println("2. Transfer");
        System.out.println("3. Balance check");
        System.out.println();
        System.out.printf(PROMT); //the promt is printed in the same line as the "First" variable is requiered
        FIRST = keyboard.nextInt();
        switch(FIRST){ //switch according to the user operation request
            case 0: //case for getting cash, the amount of money to retrieved is requested
                System.out.println("Please insert the amount of money that you want to retrieve");
                System.out.println();
                System.out.printf("> $");
                BALANCERETRIEVE = keyboard.nextInt();
                break;
            case 1: //case for deposit cash, the amount of money to deposit is requested
                System.out.println("Please insert the amout of money to deposit");
                System.out.println();
                System.out.printf("> $");
                BALANCEDEPOSIT = keyboard.nextInt();
                break;
            case 2: //case for transfering money, the amount of money to transfer is requested
                System.out.println();
                System.out.println("Insert the account to transfer");
                System.out.println();
                System.out.printf(">");
                keyboard.nextLine();
                ACCOUNT = keyboard.nextLine(); //the account is requested
                if(ACCOUNT.length() == 16){//if the lenght of the account is eqiual to 16 then the amount to be transfered is requested
                    System.out.println();
                    System.out.println("Insert the amount to transfer");
                    System.out.println();
                    System.out.printf("> $");
                    BALANCETRANSFER = keyboard.nextInt(); //the amount to transfer is requested
                    if(BALANCETRANSFER < BALANCE){//if the money to transfer is minor to the balance of the user then the balance equals the balance minus the balancetransfer
                        BALANCE = BALANCE - BALANCETRANSFER;
                        TRANSB = TRANSB + BALANCETRANSFER; //the balance of the account which is being transfered equals the Blance of the acount plus the balance that is being transfered
                    }
                }
                break;
            case 3: //case for transfering money, the amount of money to transfer is requested
                System.out.println("Chekcing your account Balance");
                System.out.println("Please wait");
                WAIT = 0; //wait is the variable for the animation of loading
                while(WAIT != 15){ //while variable wait is diferent from 15 then the computer will sleep for 250 milliseconds and then print a dot
                    Thread.sleep(250);
                    System.out.printf(".");
                    WAIT ++; //wait will increment its value until the loop is broken
                }
                System.out.println();
                System.out.println();
                System.out.println("Your current balance is $"+BALANCE); //display the account balance
                break;
        }
    }
    
    public static void extract_money(){ //function for money extraction
        TOTALCMONEY = TOTALCMONEY - BALANCERETRIEVE; //the total cashier money equals the total cashier money minus the retrieve request
        BALANCE = BALANCE - BALANCERETRIEVE; //the user balance equals the account minus the retrieve request
    }
    
    public static void deposit(){ //function for money deposit
        TOTALCMONEY = TOTALCMONEY + BALANCEDEPOSIT; //the cashier money equals the cashier money plus the amount that is being deposited
        BALANCE = BALANCE + BALANCEDEPOSIT; //the user balance equals the user balance plus the amount that is being deposited
    }
    
    public static void fundation(){ //function for the fundation 
        Scanner keyboard = new Scanner(System.in);//Keyboard input initializer
        String STR; //string for yes or no
        System.out.println("Would you like to donate to LDJ bank? (y/n)");
        System.out.println();
        System.out.printf(">");
        STR = keyboard.next(); //the user inputs y or n in order to say if they want to donate or not
        if(STR.equals("y")){ //if they want to donate
            System.out.println();
            System.out.println("Insert the amount to donate");
            System.out.println();
            System.out.printf("> $");
            FUNDATION = keyboard.nextInt(); //the promt is printed and the amount is requested
            if(FUNDATION <= BALANCE){//if the amount to donate is minor to the balance you can donate
                FUNDATIONM = FUNDATIONM + FUNDATION; //the fundation money plus the amount to be donated
                BALANCE = BALANCE - FUNDATION; //the user balance minus the fundation money
                System.out.println("Thank you for donating!");
            }
            else {
                System.out.println("Insufficient Balance");
            }
        }
        else if(STR.equals("n")){ //if n then prints blank
            System.out.println();
        }
        System.out.println("We'll continue with the operation");
        System.out.println();
        System.out.println("Done");
    }
    
    public static void close(){ //function for closing the cashier
        System.out.println("Thank you for choosing our Bank");
        System.out.println();
        if(CLIENT.length() == 16 && PASSWORD.length() == 4){ //if the user lenght is equal to 16 and password lenght to 4 (if they are valid) then the user closes by saying the account number
            System.out.println("Farewell user " +CLIENT); //farewell for the client
        }
        else{ //if the account or password isnt valid then the following is displayed
            System.out.println("PLEASE CONTACT THE BANK FOR ASSISTANCE IF NEEDED");
        }
        System.exit(0); //the system forces the exit of the program
    }
}