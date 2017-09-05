/*
 */
package main;

import static java.lang.Math.sqrt;
import java.util.Scanner;

/**
 *
 * @author Jack L. Clements
 */
public class TempClassName {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt();
        n = 5;
        int [][] array = new int[n][n];
        array[0][0] = 1;
        array[0][1] = 2;
        array[0][2] = 3;
        array[0][3] = 4;
        array[0][4] = 5;
        array[1][0] = 6;
        array[1][1] = 7;
        array[1][2] = 8;
        array[1][3] = 9;
        array[1][4] = 0;
        array[2][0] = 1;
        array[2][1] = 2;
        array[2][2] = 3;
        array[2][3] = 4;
        array[2][4] = 5;
        array[3][0] = 6;
        array[3][1] = 7;
        array[3][2] = 8;
        array[3][3] = 9;
        array[3][4] = 0;
        array[4][0] = 1;
        array[4][1] = 2;
        array[4][2] = 3;
        array[4][3] = 4;
        array[4][4] = 5;
        
        int total = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                total+= array[i][j];
            }
        }
        
        System.out.println(sqrt(total));
        
    }
}
