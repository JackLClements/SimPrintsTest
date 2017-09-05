package main;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
/**
 * Reads through CV and adds alphanumeric characters to array count
 * @author Jack L. Clements
 */
public class CVReader {
    //Counts occurences of letters/numbers
    //0-25 are a-z, 26-35 are 0-9
    private static int [] histogram; 
    
    
    public static void main(String [] args){
        histogram = new int [36]; //initialise
        openFile(new File("jlccv.txt")); //read file
        
        //print histogram
        for(int i = 0; i < histogram.length-10; i++){
            System.out.print("Char " + (char)(i+65) + " :");
            for(int j = 0; j < histogram[i]; j++){
                System.out.print("-");
            }
            System.out.print("\n");
        }
        for(int i = histogram.length-10; i < histogram.length; i++){
            System.out.println("Pos " + (char)(i+22) + ": ");
            for(int j = 0; j < histogram[i]; j++){
                System.out.print("-");
            }
            System.out.print("\n");
        }
    } 
    
    /**
     * Try to open file and pass each line to the array adding method
     * @param file 
     */
    public static void openFile(File file){
        try{
            Scanner reader = new Scanner(new FileReader(file));
            while(reader.hasNextLine()){
                addToArray(reader.nextLine().toUpperCase()); //uses uppercase for easier formatting
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * Read each char in line string and determine whether is alphabet letter or number
     * @param string 
     */
    public static void addToArray(String string){
        for(char c : string.toCharArray()){
            if(65 <= ((int) c) && ((int) c) <= 90){ //65 = A, 90 = Z
                int loc = ((int) c) - 65;
                histogram[loc]++;
            }
            if(48 <= ((int) c) && ((int) c) <= 57){ //48 = 0, 57 = 9
                int loc = ((int) c) - 22;
                histogram[loc]++;
            }
        }
    }
    
}
