/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeesimulator;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Juan Ca
 */
public class Employeesimulator {

    //[nombre,tipo de empleado, nomina, seguro social, tipo de contrato, saliario, costo por hora, numeor de horas trabajadas]
    //[gerente,jefe,empleado de oficina, personal de limpieza, personal de seguridad]
    public static ArrayList<employee> list = new ArrayList<>(); /*Esta lista guarda los empleados*/
    public static int gerente,jefe,empleado,limpieza,seguridad; /*Estas variables estan encargadas de contar el número de 
    empleados por tipo*/
             //0       1      2          3    4
    /*
    * @args
    * La método main crea 20 empleados aleatoriamente tanto en nombres como en tipos de trabajo siguiendo las condiciones
    * posteriormente se inicializa el método de manu para realizar todas las operaciones
    */
    public static void main(String[] args) { 
        while(list.size() < 20){
            generator();
        }
        menu();
    }
    /*
    * Esta metódo gestiona los inputs del usuario para ver empleados, calcular la nómina, generar mas empleados y salir del programa
    */
    public static void menu(){
        String[] titles = {"gerente","jefe","empleado","limpieza","seguridad"};
        System.out.println("----------Bienvenido----------");
        System.out.println("1)Ver empleados");
        System.out.println("2)Cálculo de nómina para empleado");
        System.out.println("3)Generar mas empleados");
        System.out.println("4)Salir");
        Scanner keyboard = new Scanner(System.in); /*Scanner para las opciones del menú*/
        Scanner keyboard2 = new Scanner(System.in); /*Scanner para las opciones del submenu de la nómina*/
        int selection = keyboard.nextInt(); /*Se utiliza el scanner keyboard para capturar la selección del usuario*/
        employee[] employeelist = list.toArray(new employee[list.size()]); /*Se parsea el arraylist de los empleados en un array para poder iterar en este*/
        switch(selection){ /*Switch para la selección del usuario*/
            case 1:
                System.out.println("----------Lista de empleados----------");
                for(int i = 0; i< list.size(); i++){ /*Se itera en el array y se imprimen los datos*/
                    if(i != 0){
                        System.out.println("--------------------------------------");
                    }
                    System.out.println("Nómina: "+employeelist[i].nomina);
                    System.out.println("Nombre: "+employeelist[i].name);
                    System.out.println("Seguro social: "+employeelist[i].secure);
                    System.out.println("Tipo de contrato: "+employeelist[i].contract);
                    System.out.println("Empleado con sueldo fijo: "+employeelist[i].fixed);
                    System.out.println("Horas extras trabajadas: "+employeelist[i].hours);
                    System.out.println("Tipo de empleado: "+titles[employeelist[i].type]);
                    
                }
                System.out.println("-------------------------------------- \n");
                menu(); /*se regresa al menu*/
                break;
            case 2:
                System.out.println("Ingresar nómina \n");
                String nomina = keyboard2.next(); /*Se utiliza el keyboard2 para la selección de la nómina*/
                for(int i = 0; i< list.size(); i++){
                    if(employeelist[i].nomina.equals(nomina)){
                        nomina_empleado(employeelist[i].type,employeelist[i].hours);/*se inicializa el método nomina_empleado con el tipo de empleado y las horas extra trabajadas*/
                    }
                }
                menu();/*se regresa al menú*/
                break;
            case 3:
                generator();/*se inicializa el método generator para la creación de empleados*/
                System.out.println("Empleado generado! \n");
                System.out.println("Número por categoria:");
                System.out.println("Gerente: "+gerente);
                System.out.println("Jefe: "+jefe);
                System.out.println("Limpieza: "+limpieza);
                System.out.println("Seguridad :"+seguridad+"\n");
                break;
            case 4:
                System.out.println("Gracias, hasta luego");
                System.exit(0);/*Se cierra el programa*/
                break;
            default:
                System.out.println("Seleccionar otra opción");
                System.out.println(gerente); //1
                System.out.println(jefe); //2
                System.out.println(limpieza); //2
                System.out.println(seguridad); //3
                menu();
                break;
                
        }
    }
    /*
    * Este método esta encargada de generar un empleado de manera aleatoria
    */
    public static void generator(){
        String[] contracts = {"Temporal", "Indefinido","Por obra","Internship"}; /*Lista con los tipos de contrato posibles*/
        
        Random rand = new Random(); /*se inicializa un aleatorio */
        int nom = 50000  + rand.nextInt(99999 - 50000  + 1); /*se crea un int aleatorio para el número de nómina entre 99999 y 50000*/
        int ss = 50000  + rand.nextInt(99999 - 50000  + 1); /*se crea un int aleatorio para el número de seguro social enre 99999 y 50000*/
        int ty;
        if(continue_creation() == true){ /*se verifica que se siga la creación con el método continue creation*/
            ty = rand.nextInt(4); /*se establece el int para el tipo con un máximo 4*/
        }
        else{
            ty = 2; /*En caso de que no se cumpla se establece el tipo como 2 para generar empleados*/
        }
        int hrs = rand.nextInt(10); /*se genera un número aleatorio de horsa extra trabajadas*/
        int contr = rand.nextInt(4); /*se genera un tipo de contrato aleatorio*/
        employee employee = new employee(); /*se crea un empleado*/
        employee.name = namegen(); /*se le estableece un nombre aleatorio con el método namegen*/
        employee.nomina = Integer.toString(nom); /*se establece una nómina parseando el int nom a string*/
        employee.type = ty; /*se establece el tipo de empleado*/
            switch(ty){ /*Switch para el tipo de empleado, estableceiendo su tipo de contrato, si es de sueldo fijo, su número de seguro social, las horas trabajadas
                e incrementa el número del tipo de empleado*/
                case 0: //gerente
                    employee.contract = contracts[1];
                    employee.fixed = true;
                    employee.secure = Integer.toString(ss);
                    employee.hours = hrs;
                    gerente ++;
                    break;
                case 1://jefe
                    employee.contract = contracts[1];
                    employee.fixed = true;
                    employee.secure = Integer.toString(ss);
                    employee.hours = hrs;
                    jefe ++;
                    break;
                case 2://empleado
                    employee.contract = contracts[contr];
                    employee.fixed = true;
                    employee.secure = Integer.toString(ss);
                    employee.hours = hrs;
                    empleado++;
                    break;
                case 3://limpieza
                    employee.contract = contracts[contr];
                    employee.fixed = true;
                    employee.secure = Integer.toString(ss);
                    employee.hours = hrs;
                    limpieza++;
                    break;
                case 4://seguridad
                    employee.contract = contracts[contr];
                    employee.secure = Integer.toString(ss);
                    employee.hours = hrs;
                    seguridad ++;
                    break;
                default:
                    break;
            }
            if(contr == 3 || contr == 2 || contr == 0){ /*si es 3, 2 o 0 el contrato se establece que no tiene sueldo fijo y por tanto no tiene seguro social*/
                employee.fixed = false;
                employee.secure = "No aplica";
            }
            list.add(employee);/*se añade el empleado al arraylist de empleados*/
    }
    /*
    * Método para la generación de nombres aleatorios
    */
    public static String namegen(){
        String name = "";/*Se inicializa un string vacio*/
        Random rand = new Random(); /*se inicializa un random*/
        String[] names = {"Pepe","Jose","Maria","Carmen","Ximena","Carlos","Pedro","Mónica","Vicente","Camila","Pablo","Ricardo",
            "Mariana","Paula","Natalia","Daniel","Astrid","Valeria","Isabella","Emma"};/*Esta lista contiene nombres*/
        String[] apellidos = {"González","Rodriguéz","Gómez","García","Pérez","Flores","Gimenéz","Rojas","Romero","Díaz",
            "Herrera","Silva","Cardozo","Toledo","Franco","Campos","Contreras","Farías","Lucero","del Monte"};/*Esta lista contiene apellidos*/
        int n = rand.nextInt(20);/*número aleatorio para los nombres*/
        int l = rand.nextInt(20);/*número aleatorio para los apellidos*/
        name = names[n]+" "+apellidos[l];/*se establece el nombre y el apellido en el string name*/
        return name;/*se regresa el string name*/
    }
    /*
    * Métdo para continuar la creación aleatioria donde solo pueden haber 1 gerente, 2 jefes, 3 vigilantes, 2 limpieza
    */
    public static boolean continue_creation(){
        return gerente <1 && jefe <2 && limpieza <2 && seguridad <3;
    }
    /*
    * Método para la nómina del empleado, se requiere el tipo y las horas trabajadas
    */
    public static void nomina_empleado(int type, int h){
        payments payments = new payments();/*se crea un payments*/
        switch(type){ /*se realiza un switch para el tipo de empleado llamando al método para establecer los valores para cada tipo*/
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
        System.out.println("Seleccionar tipo de pago");
        System.out.println("1) Quincenal");
        System.out.println("2) Mensual");
        System.out.println("3) Anual\n");
        Scanner keyboard = new Scanner(System.in); /*se inicializa un scanner para la seleccion del menú*/
        int selection = keyboard.nextInt();
        switch(selection){ /*switch para la selección llamando al método correspondiente para calcular el pago por periodo*/
            case 1:
                payments.quincenal(); 
                break;
            case 2:
                payments.mensual();
                break;
            case 3:
                payments.anual();
                break;
            default:
                System.out.println("seleccionar opción del menú");
                nomina_empleado(type,h);
                break;
        }
        
    }
}
/*
* Clase para los empleados, esta clase establece las variables que un empleado debe de tener
*/
class employee{
    String name;
    String nomina;
    String secure;
    String contract;
    boolean fixed;
    int hours;
    int type;
    
}
/*
* Clase para la gestion de pagos, contiene caracteristicas y métodos para los cálculos de los pagos
*/
class payments{
    static int paymentb;
    static int hextra;
    static double imss;
    static int subtotal;
    static int iva;
    static int total;
    /*
    * Método para cálculo del pago quincenal
    */
    public static void quincenal(){
        paymentb = paymentb/2; /*se divide el pago entre 2*/
        imss = imss/2; /*se divide el imss entre 2*/
        double subtotal = paymentb +hextra -imss; /*se suma el pago mas las horas extra y se resta lo del imss*/
        double iva = subtotal * 0.16; /*se multiplica el subtototal por el 16%*/
        double total = payments.paymentb + subtotal -iva;
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
    /*
    * Método para cálculo del pago mensual
    */
    public static void mensual(){
        double subtotal = paymentb+hextra- imss; /*se suma el pago mas las horas extra y se resta lo del imss*/
        double iva = subtotal * 0.16; /*se multiplica el subtotal por el 16%*/
        double total = subtotal-iva; /*se resta el total menos el iva*/
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
    /*
    * Método para cálculo del pago anual
    */
    public static void anual(){
        paymentb = paymentb*12; /*se multiplica por 12*/
        imss = imss*12; /*se multiplica por 12*/
        double subtotal = paymentb +hextra -imss; /*pago mas horas extra menos el imss*/
        double iva = subtotal * 0.16; /*subtotal por el 16%*/
        double total = subtotal -iva; /*se reliza la resta*/
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
    
    /*métodos para el tipo de empleado (el que establecerá los valores de la clase donde el valor es por mes*/
    public static void gerente(int hours){
        payments.paymentb = 15000; 
        payments.hextra = 0*hours;
        payments.imss = paymentb*0.05;
    }
    public static void jefe(int hours){
        payments.paymentb = 2000;
        payments.hextra = 0*hours;
        payments.imss = paymentb*0.05;
    }
    public static void empleado(int hours){
        payments.paymentb = 9000;
        payments.hextra = 8*hours;
        payments.imss = paymentb*0.05;
    }
    public static void empleado_nofixed(int hours){
        payments.paymentb = 0;
        payments.hextra = 80*hours;
        payments.imss = 0; // como es informal no esta registrado en el seguro social
    }
    public static void limpieza(int hours){
        payments.paymentb = 5000;
        payments.hextra = 50*hours;
        payments.imss = paymentb*0.05;
    }
    public static void seguridad(int hours){
        payments.paymentb = 6000;
        payments.hextra = 60;
        payments.imss = paymentb*0.05;
    }
}