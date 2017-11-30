import java.io.*;
    public class fibonacci {
      public static BufferedReader ent = new BufferedReader(new InputStreamReader(System.in));
       public static int FibonacciIterativo(int n, int arr[]){
         for(int i = 0; i < n; i++)
            if(i < 2)
               arr[i] = 1;
            else
               arr[i] = arr[i-1] + arr[i-2];
         return arr[n-1];
      }
       public static int FibonacciRecursivo(int n){
         if(n < 2)
            return 1;
         else
            return FibonacciRecursivo(n-1) + FibonacciRecursivo(n-2);
      }
       public static void main(String args[]) throws IOException{      
         System.out.println("Dame el numero n");
         int n = Integer.parseInt(ent.readLine());
         int arr[] = new int [n];
         System.out.println("Iterativo es:");
         System.out.println("F(" + n + ")=" + FibonacciIterativo(n, arr));
         System.out.println("Recursivo es:");      
         System.out.println("F(" + n + ")=" + FibonacciRecursivo(n-1));
      }
   }