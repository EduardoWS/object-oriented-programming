// Lucas Moro Iroldi NUSP: 13832614
// Eduardo Ribeiro Rodrigues NUSP: 13696679


import java.util.Scanner;



public class FactorialCalculator {

    // Recursive method to calculate factorial
    public static int factorialRecursive(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorialRecursive(n - 1);
    }

    // Iterative method to calculate factorial
    public static int factorialIterative(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static int sumAllIntegers(int n){
        // Function to sum all integers from 1 to n
        int sum=1;

        if(n == 1){
            return sum=1;
        }

        for(int i=2; i<=n; i++){
            sum += i;
            if(i == n){
                break;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        
        int number;
        
        try
        {
            // Get input from user
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a number: ");
            number = scanner.nextInt();

            // If input is negative, print error message and return
            if (number < 0) {
                System.out.println("Factorial of a negative number is undefined.");
                return;
            }
            
        }
        catch(Exception e)
        {
            // If input is not a number, print error message and return
            System.out.println("Invalid input. Please enter a valid number.");
            return;
        }
        
        System.out.println("Factorial of " + number + " (Recursive): " + factorialRecursive(number));
        System.out.println("Factorial of " + number + " (Iterative): " + factorialIterative(number));
        System.out.println("Sum of all integers 1 ~ " + number + " = " + sumAllIntegers(number));
    }
}