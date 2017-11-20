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
        public static String IDTRANS; //Account number where the money will be transfered
	public static int TRANSB = 0; //Account Balance for the Transfered
	public static String CLIENT; //Client/user ID
	public static String PASSWORD; //Client/user ID
        public static int FUNDATION = 0; //Fundation transaction
	public static int FUNDATIONM = 0; //Fundation account balance
        
    public static void questions(){ //function for questions
        int TIMES = 0; //variable for the number of trying inputs for password
        Scanner keyboard = new Scanner(System.in); //Keyboard input initializer
        String PROMT; 
        PROMT = ">"; //promt sring definition
        System.out.println("Welcome to LJD Bank");
        System.out.println("Insert Bank account");
        System.out.println();
        System.out.printf(PROMT);
        CLIENT = keyboard.nextLine(); //to be defined by user
        System.out.println();
        if(CLIENT.length() == 16){ //if the lenght of the input(account id) is equal to 16 then the account is valid
            if(TIMES <4){
                System.out.println("Insert NIP");
                System.out.printf(PROMT); //the NIP is asked then the promt is printed in the same line as the Password request
                PASSWORD = keyboard.nextLine(); 
                System.out.println();
                if(PASSWORD.length() == 4){ //if the NIP/Password lenght is equal to 4 then you will be welcomed
                    System.out.println("Welcome to your account user " +CLIENT);
                }
                else{ //if not then try string will be printed
                    System.out.println(TRY);
                }    
            }
            else{
                System.out.println("THE CASHIER HAS BEEN BLOCKED DUE TO THE " +TIMES+ " YOU HAVE ATTEMPTED TO ACCESS, PLEASE CONTACT AN ADMINISTRATOR");
            }
        }
        else{ //if not then try string will be printed
            System.out.println(TRY);
        }
    }
    
    public static void login(){
        int TIMESC = 0;
        int TIMESP = 0;
        String PROMT; 
        Scanner keyboard = new Scanner(System.in); //Keyboard input initializer
        PROMT = ">"; //promt sring definition
        System.out.println("Welcome to LJD Bank");
        System.out.println("Insert Bank account");
        System.out.println();
        System.out.printf(PROMT);
        CLIENT = keyboard.nextLine(); //to be defined by user
        if(CLIENT.length() != 16){
            if(TIMESC == 0){
                while(TIMESC < 4){
                   System.out.println("Not a valid Account");
                   System.out.println("Please insert a valid Account");
                   CLIENT = keyboard.nextLine();
                   TIMESC ++;
                }
                Cashier.close();
            }    
        }
        else{
            System.out.println("Insert NIP");
            System.out.printf(PROMT);
            PASSWORD = keyboard.nextLine();
            if(PASSWORD.length() != 4){ 
                while(TIMESP < 4){
                        System.out.println("Not a valid NIP");
                        System.out.println("Please insert a valid NIP");
                        PASSWORD = keyboard.nextLine();
                        TIMESP ++;
                }
                Cashier.close();
            }
        }
        
        PASSWORD =keyboard.nextLine();
        if(PASSWORD.length() < 4){
            PASSWORD = keyboard.nextLine();
            TIMESP ++;
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
                BALANCETRANSFER = keyboard.nextInt();
                break;
            case 2: //case for transfering money, the amount of money to transfer is requested
                System.out.println("Insert the account number to make the transfer");
                System.out.println();
                System.out.printf(">");
                IDTRANS = keyboard.nextLine();
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
    public static void transfer(){ //function for transfering money
        Scanner keyboard = new Scanner(System.in); //Keyboard input initializer
        if(IDTRANS.length() == 16){ //if the account to be transfered lenght is equal to 16 digits then
            System.out.println();
            System.out.println("Insert the amount to transfer"); //the amount to transfered is requested
            System.out.println();
            System.out.printf("> $"); 
            TRANSB = keyboard.nextInt(); //the promt is printed in the same line as the request for the amount of money
            if(TRANSB <= BALANCE){ //if the money to transfer is minor or equal then the operation can continue
                TRANSB = TRANSB + BALANCETRANSFER; //the account to be transfered balance plus the amount that is being transfered
                BALANCE = BALANCE - BALANCETRANSFER; //the user balance minus the amount that is being transfered
            }
            else{ //if there is not enough money to transfer then insufficient balance
                System.out.println("Insufficient Balance");
            }
        }
        else{//if the account inst valid an error message is displayed
            System.out.println("Not a valid account");
        }
    }
    
    public static void close(){ //function for closing the cashier
        System.out.println("Thank you for choosing our Bank");
        System.out.println();
        System.out.println("Farewell user " +CLIENT); //farewell for the client
        System.exit(0);
    }
}