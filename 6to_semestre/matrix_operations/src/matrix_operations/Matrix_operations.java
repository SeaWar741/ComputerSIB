/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix_operations;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Juan Ca
 */
public class Matrix_operations {
    public static void suma(int[][] matrix1,int[][] matrix2, int row, int col){
        int[][] suma = new int[row][col];
        System.out.println("Suma = ");        
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                suma[i][j] = matrix1[i][j] + matrix2[i][j];
                System.out.print(suma[i][j]+"\t");
            }
            System.out.println();
        }
    }
    static void resta(int[][] matrix1,int[][] matrix2, int row, int col){
        int[][] sub = new int[row][col];
        System.out.println("Subtraction = ");
        
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                sub[i][j] = matrix1[i][j] - matrix2[i][j];
                
                System.out.print(sub[i][j]+"\t");
            }
            
            System.out.println();
        }
    }
    static void multiply(int[][] matrix1,int[][] matrix2, int row1, int col1,int row2, int col2){
        int[][] product = new int[row1][col2];
        System.out.println("Producto = ");
        
        for (int i = 0; i < row1; i++){
            for (int j = 0; j < col2; j++)
            {
                for (int k = 0; k < row2; k++)
                {
                    product[i][j] +=  matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        for (int i = 0; i < col1; i++){
            for (int j = 0; j < col2; j++)
            {
                System.out.print(product[i][j]+"\t");
            }
            
            System.out.println();
        }
    }
    static void multiply_vect(int[][]matrix,int[] vector){
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[]resultado = new int[rows];
        for(int row = 0; row< rows;row++){
            int suma = 0;
            for(int column = 0; column < columns; column++){
                suma+= matrix[row][column] *vector[column]; 
            }
            resultado[row] = suma;
        }
        System.out.println(Arrays.toString(resultado));
    }
    static void multiply_const(int[][]matrix,int constant){
        int rows = matrix.length;
        int columns = matrix[0].length;
        for (int i = 0; i < rows; i++){  
            for (int j = 0; j < columns; j++){
                matrix[i][j] = matrix[i][j] * constant;
            }
        }
        System.out.println("Resultado:");
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++)
            {
                System.out.print(matrix[i][j]+"\t");
            }
            
            System.out.println();
        }
    }
}

class Matrix_validator{
        public static int[][]matrix1;
        public static int[][]matrix2;
        public static int[] vector;
        public static int row,col,row1,col1,row2,col2,scalar;
        
        public static void main(String[] args){
            Matrix_operations Matrix_operations = new Matrix_operations();
            menu();
        }

        public static void menu(){
            System.out.println("Seleccionar una operación para las matrices:");
            System.out.println("1) sumar matrices");
            System.out.println("2) restar matrices");
            System.out.println("3) multiplicar matrices");
            System.out.println("4) multiplicar matriz con vector");
            System.out.println("5) multiplicar matriz con escalar");
            System.out.println("6) Salir");
            Scanner sel = new Scanner(System.in);
            int option = sel.nextInt();
            try {
                switch(option){
                    case 1:
                        two_matrix();
                        Matrix_operations.suma(matrix1,matrix2,row,col);
                        System.out.println("");
                        menu();
                        System.out.println("");
                        break;
                    case 2:
                        two_matrix();
                        Matrix_operations.resta(matrix1,matrix2, row,col);
                        System.out.println("");
                        menu();
                        System.out.println("");
                        break;
                    case 3:
                        two_matrix();
                        Matrix_operations.multiply(matrix1,matrix2,row,col,row2,col2);
                        System.out.println("");
                        menu();
                        System.out.println("");
                        break;
                    case 4:
                        matrix_vector();
                        Matrix_operations.multiply_vect(matrix1,vector);
                        System.out.println("");
                        menu();
                        System.out.println("");
                        break;
                    case 5:
                        matrix_scalar();
                        Matrix_operations.multiply_const(matrix1,scalar);
                        System.out.println("");
                        menu();
                        System.out.println("");
                    case 6:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción no válida");
                        System.out.println("");
                        menu();
                        System.out.println("");
                        break;
                }
            }catch(ArrayIndexOutOfBoundsException exception) {
                System.out.println("No se puede realizar o terminar la operación");
                System.out.println("");
                menu();
            }
        }
        public static void two_matrix(){
            System.out.println("Matriz 1:");
            Scanner number = new Scanner(System.in);
            System.out.println("Ingresar numero de filas");
            row = number.nextInt();
            System.out.println("Ingresar el numero de columnas");
            col = number.nextInt();

            matrix1 = new int[row][col];
            System.out.println("Ingresar datos de la matriz 1");
            for(int i = 0; i< row; i++){
                for(int j = 0; j<col;j++){
                    matrix1[i][j] = number.nextInt();
                }
            }
            System.out.println("Tu matriz 1 es: ");
            for(int i = 0; i < row; i++ ){
                for(int j = 0; j <col; j++){
                    System.out.println(matrix1[i][j]+"\t");
                }
                System.out.println("");
            }
            System.out.println("Matriz 2: ");
            Scanner number2 = new Scanner(System.in);
            System.out.println("Ingresar numero de filas");
            row2 = number.nextInt();
            System.out.println("Ingresar el numero de columnas");
            col2 = number.nextInt();
            matrix2 = new int[row2][col2];
            System.out.println("Ingresar datos de la matriz 2");
            for(int i = 0; i< row2; i++){
                for(int j = 0; j<col2;j++){
                    matrix2[i][j] = number2.nextInt();
                }
            }
            System.out.println("Tu matriz 2 es: ");
            for(int i = 0; i < row2; i++ ){
               for(int j = 0; j <col2; j++){
                   System.out.println(matrix2[i][j]+"\t");
               }
                System.out.println("");
            }

            System.out.println("");
            System.out.println("");
            System.out.println("Matrices:");
            System.out.println("Tu matriz 1 es: ");
            for(int i = 0; i < row; i++ ){
               for(int j = 0; j <col; j++){
                   System.out.println(matrix1[i][j]+"\t");
               }
                System.out.println("");
            }
            System.out.println("Tu matriz 2 es: ");
            for(int i = 0; i < row2; i++ ){
               for(int j = 0; j <col2; j++){
                   System.out.println(matrix2[i][j]+"\t");
               }
                System.out.println("");

            }
        }
        public static void matrix_scalar(){
            Scanner number = new Scanner(System.in);
            Scanner number2 = new Scanner(System.in);
            System.out.println("Ingresar numero de filas");
            row = number.nextInt();
            System.out.println("Ingresar el numero de columnas");
            col = number.nextInt();
            matrix1 = new int[row][col];
            System.out.println("Ingresar datos de la matriz 1");
            for(int i = 0; i< row; i++){
                for(int j = 0; j<col;j++){
                    matrix1[i][j] = number.nextInt();
                }
            }
            System.out.println("Tu matriz 1 es: ");
            for(int i = 0; i < row; i++ ){
                for(int j = 0; j <col; j++){
                    System.out.println(matrix1[i][j]+"\t");
                }
                System.out.println("");
            }
            System.out.println("Ingresar escalar entero:");
            scalar = number2.nextInt();
        }
        public static void matrix_vector(){
            Scanner number = new Scanner(System.in);
            Scanner number2 = new Scanner(System.in);
            System.out.println("Ingresar numero de filas");
            row = number.nextInt();
            System.out.println("Ingresar el numero de columnas");
            col = number.nextInt();

            matrix1 = new int[row][col];
            System.out.println("Ingresar datos de la matriz");
            for(int i = 0; i< row; i++){
                for(int j = 0; j<col;j++){
                    matrix1[i][j] = number.nextInt();
                }
            }
            System.out.println("Tu matriz es: ");
            for(int i = 0; i < row; i++ ){
                for(int j = 0; j <col; j++){
                    System.out.println(matrix1[i][j]+"\t");
                }
                System.out.println("");
            }
            System.out.println("Ingresar datos para vector:");
            vector = new int[row];
            for(int i = 0; i < row; i++){
                vector[i] = number.nextInt();
            } 
        }
}
