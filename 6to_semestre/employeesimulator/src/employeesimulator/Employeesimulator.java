/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeesimulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Juan Ca
 */
public class Employeesimulator {

    /**
     * @param args the command line arguments
     */
    //[nombre,tipo de empleado, nomina, seguro social, tipo de contrato, saliario, costo por hora, numeor de horas trabajadas]
    //[gerente,jefe,empleado de oficina, personal de limpieza, personal de seguridad]
    public static ArrayList<employee> list = new ArrayList<>(); //lista de los empleados
    static int gerente,jefe,empleado,limpieza,seguridad;
             //0       1      2          3    4
    public static void main(String[] args) {
        // TODO code application logic here
        //arraylist para los empleados --> []
        for(int i = 0;i<20;i++){
            generator();
        }
        menu();
    }
    
    public static void menu(){
        System.out.println("----------Bienvenido----------");
        System.out.println("1)Ver empleados");
        System.out.println("2)Registrar nuevo empleado");
        System.out.println("3)Cálculo de nómina para empleado");
        System.out.println("4)Salir");
        Scanner keyboard = new Scanner(System.in);
        int selection = keyboard.nextInt();
        switch(selection){
            case 1:
                employee[] employeelist = list.toArray(new employee[list.size()]);
                System.out.println("----------Lista de empleados----------");
                for(int i = 0; i< list.size(); i++){
                    if(i != 0){
                        System.out.println("--------------------------------------");
                    }
                    System.out.println("Nómina: "+employeelist[i].nomina);
                    System.out.println("Nombre: "+employeelist[i].name);
                    System.out.println("Seguro social: "+employeelist[i].secure);
                    System.out.println("Tipo de contrato: "+employeelist[i].contract);
                    System.out.println("Empleado con sueldo fijo: "+employeelist[i].fixed);
                    //System.out.println(employeelist[i].cost_h);
                    System.out.println("Horas extras trabajadas: "+employeelist[i].hours);
                    System.out.println("Tipo de empleado: "+employeelist[i].type);
                    
                }
                System.out.println("-------------------------------------- \n");
                menu();
                break;
            default:
                System.out.println("Seleccionar otra opción");
                break;
                
        }
    }
    
    public static void generator(){
        String[] contracts = {"Temporal", "indefinido","Por obra","Internship"}; 
        Random rand = new Random();
        int nom = 50000  + rand.nextInt(99999 - 50000  + 1);
        int ss = 50000  + rand.nextInt(99999 - 50000  + 1);
//        if(gerente <=20 ||  jefe <=2 || limpieza <=2 || seguridad <=3){
//            
//        }
        int ty = rand.nextInt(4+1);
        int hrs = rand.nextInt(5-2 +1);
        int contr = rand.nextInt(4+1);
        employee employee = new employee();
        employee.name = namegen();
        employee.nomina = Integer.toString(nom);
        employee.type = ty;
        switch(ty){
            case 0: //gerente
                employee.contract = contracts[2];
                employee.fixed = true;
                employee.secure = Integer.toHexString(ss);
                employee.hours = hrs;
                break;
            case 1://jefe
                employee.contract = contracts[1];
                employee.fixed = true;
                employee.secure = Integer.toHexString(ss);
                break;
            case 2://empleado
                break;
            case 3://limpieza
                break;
            case 4://seguridad
                break;
            default:
                break;
        }
        
        list.add(employee);
    }
    public static String namegen(){
        String name ="";
        Random rand = new Random();
        String[] names = {"Pepe","Jose","Maria","Carmen","Ximena","Carlos","Pedro","Mónica","Vicente","Camila","Pablo","Ricardo","Mariana","Paula","Natalia","Daniel","Astrid","Valeria","Isabella","Emma"};
        String[] apellidos = {"González","Rodriguéz","Gómez","García","Pérez","Flores","Gimenéz","Rojas","Romero","Díaz","Herrera","Silva","Cardozo","Toledo","Franco","Campos","Contreras","Farías","Lucero","del Monte"};
        int n = rand.nextInt(20);
        int l = rand.nextInt(20);
        name = names[n]+" "+apellidos[l];
        return name;
    }
    //clase verificador de cuantos hay 
    //solo pueden haber 1 gerente, 2 jefes, 3 vigilantes, 2 limpieza
    public static boolean continue_creation(int type){
        //checar en el array de objetos si existe ya la cantidad de 
        if(type == gerente && gerente <=20 || type == jefe && jefe <=2 || type == limpieza && limpieza <=2 || type == seguridad && seguridad <=3){ //arreglar
            return true;
        }
        else{
            System.out.println("Ya no existen posiciones disponibles para este tipo de empleo");
            return false;
        }
    }
    public static void display_employees(){
        //pasar Arraylists a arrays
        //Vaciar arraylists
        //imprimir
    }
    public static void delete_employee(int id){
        //pasar Arraylists a arrays
        //vaciar arraylists
        //eliminar del array el que tenga ese id
    }
    public static void nomina_empleado(int id){
        payments payments = new payments();
        //consigue la informacion de horas extras trabajadas
        int type = 0, h = 0; //recuperar del empleado el tipo y las horas trabajadas extras
        switch(type){
            case 0:
                payments.gerente(h);
                break;
            case 1:
                payments.jefe(h);
                break;
            case 2:
                payments.empleado(h);
                break;
            case 3:
                payments.limpieza(h);
                break;
            case 4:
                payments.seguridad(h);
                break;
            default:
                System.out.println("Error, verificar tipo de empleado");
                break;
        }
    }
}

class employee{
    String name;
    String nomina;
    String secure;
    String contract;
    boolean fixed;
    int hours;
    int type;
    
}

class payments{
    //caracteristicas del pago
    static int paymentb;
    static int hextra;
    static double imss;
    static int subtotal;
    static int iva;
    static int total;
        
    //métodos para tipos de pagos
    public static void quincenal(){
        paymentb = paymentb/2;
        imss = imss/2;
        double subtotal = paymentb +hextra -imss;
        double iva = subtotal * 0.16;
        double total = subtotal -iva;
        System.out.println("----------PAGO----------");
        System.out.println("Sueldo: $"+paymentb);
        System.out.println("Horas extras pagadas: $"+hextra);
        System.out.println("Descuento del 5% por IMSS: $"+imss);
        System.out.println("Subtotal: $"+subtotal);
        System.out.println("------------------------");
        System.out.println("16% de IVA: $"+iva);
        System.out.println("------------------------");
        System.out.println("Total: $"+total);
        System.out.println("");
    }
    public static void mensual(){
        double subtotal = paymentb +hextra -imss;
        double iva = subtotal * 0.16;
        double total = subtotal -iva;
        System.out.println("----------PAGO----------");
        System.out.println("Sueldo: $"+paymentb);
        System.out.println("Horas extras pagadas: $"+hextra);
        System.out.println("Descuento del 5% por IMSS: $"+imss);
        System.out.println("Subtotal: $"+subtotal);
        System.out.println("------------------------");
        System.out.println("16% de IVA: $"+iva);
        System.out.println("------------------------");
        System.out.println("Total: $"+total);
        System.out.println("");
    }
    public static void anual(){
        paymentb = paymentb*12;
        imss = imss*12;
        double subtotal = paymentb +hextra -imss;
        double iva = subtotal * 0.16;
        double total = subtotal -iva;
        System.out.println("----------PAGO----------");
        System.out.println("Sueldo: $"+paymentb);
        System.out.println("Horas extras pagadas: $"+hextra);
        System.out.println("Descuento del 5% por IMSS: $"+imss);
        System.out.println("Subtotal: $"+subtotal);
        System.out.println("------------------------");
        System.out.println("16% de IVA: $"+iva);
        System.out.println("------------------------");
        System.out.println("Total: $"+total);
        System.out.println("");
    }
    
    //métodos para el tipo de empleado (el que establecerá los valores de la clase)
    //esto es el valor por mes
    public static void gerente(int hours){
        payments.paymentb = 15000;
        payments.hextra = 0*hours;
        payments.imss = paymentb - (paymentb*0.05);
    }
    public static void jefe(int hours){
        payments.paymentb = 2000;
        payments.hextra = 0*hours;
        payments.imss = paymentb - (paymentb*0.05);
    }
    public static void empleado(int hours){
        payments.paymentb = 9000;
        payments.hextra = 8*hours;
        payments.imss = paymentb - (paymentb*0.05);
    }
    public static void empleado_nofixed(int hours){
        payments.paymentb = 0;
        payments.hextra = 80*hours;
        payments.imss = 0; // como es informal no esta registrado en el seguro social
    }
    public static void limpieza(int hours){
        payments.paymentb = 5000;
        payments.hextra = 50*hours;
        payments.imss = paymentb - (paymentb*0.05);
    }
    public static void seguridad(int hours){
        payments.paymentb = 6000;
        payments.hextra = 60;
        payments.imss = paymentb - (paymentb*0.05);
    }
}