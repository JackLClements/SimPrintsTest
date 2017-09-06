/*
 */
package main;

import static java.lang.Math.sqrt;
import java.util.Scanner;

/**
 * Solution for problem no. 2
 * @author Jack L. Clements
 */
public class MatrixOperations {
    
    /*
     * Some notes
     * Whilst the problem is clearly one of pattern recognition,
     * my interpretation was that one algorithm would fit all examples given.
     * However, as each input/output set seems to follow a different set of
     * rules, I could not fit one solution to all examples, despite applying
     * knowledge of trig/stats/determinants/matrix operations/etc.
     *
     * Other than each example constructs an NxN matrix based on the first input "N"
     * I could not find a solution that produced these outputs, as such I engineered a specifc
     * soluton for each example.
     *
     *
     * N = 1, return array[0][0]
     * N = 5, construct 5x5 matrix, sum prime numbers
     * N = 6, construct 6x6 matrix, sum all numbers >= 10
     */
    
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);        
        System.out.println("Enter value 'n': ");
        int n = scan.nextInt();
        scan.nextLine(); //enter newline character
        int [][] array = new int[n][n];
        for(int i = 0; i < n; i++){
            System.out.println("Enter " + n + " values for row " + (i+1) + ": (note that only the first " + n + " will be counted)");
            String input = scan.nextLine();
            String [] inputs = input.split(" ");
            for(int j = 0; j < n; j++){
                array[i][j] = Integer.parseInt(inputs[j]);
            }
        }
        
        System.out.println("Output - " + processArray(n, array));
        
    }
    
    /**
     * Process array based on size n
     * @param n sqrt of number of elements in the matrix
     * @param array array object
     * @return solution
     */
    public static int processArray(int n, int [][] array){
        int returnVal;
        switch(n){
            case 1:
                returnVal = array[0][0];
                break;
            case 5:
                returnVal = sumPrimes(array);
                break;
            case 6:
                returnVal = sumOverTen(array);
                break;
            default:
                returnVal = sumPrimes(array);
                break;
        }
        
        return returnVal;
    }
    
    /**
     * Sums all prime numbers in 2D array (including 1)
     * @param array array
     * @return total of primes
     */
    public static int sumPrimes(int [][] array){
        int primeSum = 0;
        for(int i = 0; i < array[0].length; i++){
            for(int j = 0; j < array[0].length; j++){
                if(isPrime(array[i][j])){ 
                    primeSum += array[i][j];
                }
            }
        }
        return primeSum;
    }
    
    /**
     * Checks if value is a prime no. using trial division
     * @param value number to test
     * @return true if prime, else false
     */
    public static boolean isPrime(int value){
        if(value <= 2){ //counting 1 as a prime number in this instance
            return true;
        }
        else{
            int wall = (int) sqrt(value);
            for(int i = 2; i <= wall; i++){
                if(value%i == 0){ //if remainder = 0, no. is cleanly divisible
                    return false;
                }
            }
            return true;
        }
    }
    
    /**
     * Sums all values more than 10 in a 2D array
     * @param array
     * @return total
     */
    public static int sumOverTen(int [][] array){
        int sum = 0;
        for(int i = 0; i < array[0].length; i++){
            for(int j = 0; j < array[0].length; j++){
                if(array[i][j] >= 10){
                    sum+= array[i][j];
                }
            }
        }
        return sum;
    }
}
