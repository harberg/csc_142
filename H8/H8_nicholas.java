/**
* Homework 8 - Personality Test
* This program will look at the results from a personality test and output the analysis
* The program will user file I/O, arrays, and modular design 
*/

import java.util.*;
import java.io.*;


public class H8_nicholas {

    public static final int DIMENSIONS = 4;
    public static final int[] DIMENSIONSIZE = {10, 20, 20, 20};
    public static final String[][] DIMENSIONOPTIONS = {{"E", "I"}, {"S", "N"}, {"T", "F"}, {"J", "P"}};
    
    /**
     * Main Method for the personality test file
     * This method reads in a file name for the answers and a name for the return file. 
     * The createFile method is called.
     * @throws FileNotFoundException This is the catch the common error thrown from the Scanner
     * 
     */
    public static void main(String[] args) 
      throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        System.out.println("Add your answer file to see your results: ");

        Scanner fileName = new Scanner(new File(console.next()));
        
        System.out.print("What would you like the name of the results file called? ");
        PrintStream returnFile = new PrintStream(new File(console.next()));
        
        createFile(fileName, returnFile);
        
        returnFile.close();
        fileName.close();
    }
    
    /**
     * Takes in the input file, reads it, calls 4 methods (getSections, answerCounter, answerPrecents, and findDimensions), and creates the output file.
     * @param fileInput is the input file that the user submits
     * @param fileReturn is the file that is output with the results
     */

    public static void createFile(Scanner fileInput, PrintStream fileReturn) {
        while(fileInput.hasNextLine()) {
            fileReturn.print(fileInput.nextLine() + ": ");
            String line = fileInput.next();
            String[] sections = new String[4];
            
            sections = getSections(line);
            
            int[] section = answerCounter(sections);
            int[] percents = answerPercents(section);
            
            fileReturn.println(Arrays.toString(percents) + " = " + findDimensions(percents));
            if(fileInput.hasNextLine()) {
                fileInput.nextLine();
            }
        }
    }

    /**
     * answerPercents calculates the percentage of 'B' answers when passed arrays with the number of 'A' and 'B'.   
     * @param  section is an array that contains the number of 'A' and 'B'
     * @return         returns the percents for each answer
     */
    
    public static int[] answerPercents(int[] section) {
        int[] percents = new int[DIMENSIONS];
        for (int i = 0; i < DIMENSIONS; i++) {
            percents[i] = (int) Math.round((double) section[(i * 2) + 1] / (section[i * 2] + section[(i * 2) + 1]) * 100);
        }
        return percents;
    }
    
    /**
     * findDimensions figures out the dimensions of personality when passed an array with the percent of 'B'
     * @param  percents the percents of 'B'
     * @return          returns the personality dimensions
     */
    
    public static String findDimensions(int[] percents) {
        String dimensions = "";
        for (int i = 0; i < DIMENSIONS; i++) {
            if (percents[i] > 50) {
                dimensions = dimensions + DIMENSIONOPTIONS[i][1];
            } else if (percents[i] < 50) {
                dimensions = dimensions + DIMENSIONOPTIONS[i][0];
            } else {
                dimensions = dimensions + "X";
            }
        }
        return dimensions;
    }
    
    /**
     * getSections takes in the raw answers from the user and turns the long string into an array
     * @param  line is the line in the file that is being read
     * @return      returns an array that has been created from the 70 char long answer string
     */
    
    public static String[] getSections(String line) {
        String[] outputArr = new String[4];
        int j = 0;
        for (int i = 0; i < outputArr.length; i++) {
            outputArr[i] = "";
        }
        for (int i = 0; i < 70; i++) {
            if (j > 6) {
                j = 0;
            }
            int arrIndex = (int)Math.round((j + 1) / 2);
            outputArr[arrIndex] = outputArr[arrIndex] + Character.toUpperCase(line.charAt(i));
            j++;
        }
        return outputArr;
    }
    
    /**
     * answerCouter counts the number of 'A' and 'B' responses in each section
     * @param  inputArr the array created from the getSections()
     * @return          returns an array with the number of 'A' and 'B' answers counted
     */
    
    public static int[] answerCounter(String[] inputArr) {
        int[] outputArr = new int[8];
        int index = 0;
        for (int i = 0; i < inputArr.length; i++) {
            for (int j = 0; j < inputArr[i].length(); j++) {
                if (inputArr[i].charAt(j) == 'A') {
                    outputArr[index] = outputArr[index] + 1;
                } else if (inputArr[i].charAt(j) == 'B') {
                    outputArr[index + 1] = outputArr[index + 1] + 1;
                }
            }
            index = index + 2;
        }
        return outputArr;
    }

}
