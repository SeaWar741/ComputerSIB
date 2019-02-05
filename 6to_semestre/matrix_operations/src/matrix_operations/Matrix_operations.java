/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix_operations;

import java.util.Scanner;

/**
 *
 * @author Juan Ca
 */
public class Matrix_operations {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Matriz 1:");
        Scanner number = new Scanner(System.in);
        System.out.println("Ingresar numero de filas");
        int row = number.nextInt();
        System.out.println("Ingresar el numero de columnas");
        int col = number.nextInt();
        
        int[][] matrix1 = new int[row][col];
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
        int row2 = number.nextInt();
        System.out.println("Ingresar el numero de columnas");
        int col2 = number.nextInt();
        int[][] matrix2 = new int[row2][col2];
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
        menu(matrix1,matrix2,row,col,row2,col2);
    }
    static void menu(int[][] matrix1,int[][] matrix2, int row1, int col1,int row2, int col2){
        Scanner sel = new Scanner(System.in);
        System.out.println("Seleccionar una operación para las matrices:");
        System.out.println("1) sumar");
        System.out.println("2) restar");
        System.out.println("3) multiplicar");
        System.out.println("4) Salir");
        int option = sel.nextInt();
        switch(option){
            case 1:
                suma(matrix1,matrix2,row1,col1);
                menu(matrix1,matrix2,row1,col1,row2,col2);
                System.out.println("");
                break;
            case 2:
                resta(matrix1,matrix2, row1,col1);
                menu(matrix1,matrix2,row1,col1,row2,col2);
                System.out.println("");
                break;
            case 3:
                multiply(matrix1,matrix2,row1,col1,row2,col2);
                menu(matrix1,matrix2,row1,col1,row2,col2);
                System.out.println("");
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Opción no válida");
                menu(matrix1,matrix2,row1,col1,row2,col2);
                System.out.println("");
                break;
        }
    }
    static void suma(int[][] matrix1,int[][] matrix2, int row, int col){
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
        System.out.println("Product = ");
        
        for (int i = 0; i < row1; i++)
        {
            for (int j = 0; j < col2; j++)
            {
                for (int k = 0; k < row2; k++)
                {
                    product[i][j] +=  matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        
        for (int i = 0; i < col1; i++)
        {
            for (int j = 0; j < col2; j++)
            {
                System.out.print(product[i][j]+"\t");
            }
            
            System.out.println();
        }
    }
}
