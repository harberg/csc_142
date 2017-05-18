/**
* Homework 7 - Compare Files
* Program will look for the differences between two text files
* This will help practice file I/O and modular design
*/

import java.util.Scanner;
import java.io.*;


public class H7_nicholas {
   /**
   * Main method for the file comparison program.
   * Main calls two prompts asking the user for the names of two different text files they would like to compare. 
   * Then the compareFiles method is called which does the heavy lifting.
   * @param fileName1 The name of the first user input file
   * @param fileName2 The name of the second user input file
   * @param myFile1 The fileName1 once it has been turned into a Scanner object
   * @param myFile2 The fileName2 once it has been turned into a Scanner object
   */
   public static void main(String[] args) 
      throws FileNotFoundException {
         Scanner console = new Scanner(System.in);
         System.out.println("Enter the name of the first file you would like to compare: ");
         
         String fileName1 = console.next();
         System.out.println("Enter the name of the second file you would like to compare: ");
         String fileName2 = console.next();
         
         Scanner myFile1 = new Scanner(new File(fileName1));
         Scanner myFile2 = new Scanner(new File(fileName2));
         
         compareFiles(myFile1, myFile2);
          
      }
      /**
      * Compares two different files to look for differences on a line by line basis
      * @param file1 is the first user submitted Scanner file
      * @param file2 is the second user submitted Scanner file 
      */
      public static void compareFiles(Scanner file1, Scanner file2) {      
         while(file1.hasNextLine() && file2.hasNextLine()) {
               String line1 = file1.nextLine();
               String line2 = file2.nextLine();
               
               if(!line1.equals(line2)) {
                  System.out.println("< " + line1);
                  System.out.println("> " + line2);
               }
               if(!file1.hasNextLine() || !file2.hasNextLine()){
                  if(!file1.hasNextLine()) {
                     System.out.println("No more lines for the first file.");   
                  } else {
                     System.out.println("No more lines for the second file.");
                  }
               }
         }
         file1.close();
         file2.close();  
      }
   }