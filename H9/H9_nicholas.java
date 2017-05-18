
import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * Program that will manipulate a square based on user commands.
 * The Program will shift a row or column to the left or down.
 * The user enters two commands as a string of three chars.
 * @see <a href="https://github.com/harberg/csc_142">Github Repo</a>
 */

public class H9_nicholas {

    /**
     * Main method for the Square rotate and flip program
     * @param  args                  
     * @throws FileNotFoundException 
     */
    public static void main(String[] args)
    throws FileNotFoundException {
        Scanner myFile = new Scanner(new File("square.txt"));
        Scanner scan = new Scanner(System.in);
        String myInput;
        int[][] myArr;
        int[][] newArr = new int[5][5];

        myArr = readFile(myFile);
        System.out.println("Enter you command: ");
        myInput = scan.nextLine();

        newArr = changeArr(myInput, myArr);
        
        for(int i = 0; i < myArr.length; i++) {
            System.out.println(Arrays.toString(newArr[i]));
        }
    }

    /**
     * changeArr takes in the original square and executes user commands on it.
     * @param  command Sting input with three chars, a space, and three chars
     * @param  arr     2-D array read from square.txt file
     * @return         the changed 2-D array is returned
     */
    public static int[][] changeArr(String command, int[][] arr) {
        String arg1 = String.valueOf(command.charAt(0));
        String arg2 = String.valueOf(command.charAt(1));
        int arg3 = Integer.parseInt(String.valueOf(command.charAt(2)));
        String arg4 = String.valueOf(command.charAt(4));
        String arg5 = String.valueOf(command.charAt(5));
        int arg6 = Integer.parseInt(String.valueOf(command.charAt(6)));

        int[][] newArr = new int[arr.length][arr.length];

        if(arg1.equals("s")) {
            int[] row = getRow(arr, arg3);
            //System.out.println(Arrays.toString(row));
            row = shiftLeft(row);
            //System.out.println(Arrays.toString(row));
            newArr = returnArr(arr, row, arg3);
            System.out.println(Arrays.deepToString(newArr));
        } else if(arg1.equals("f")) {
            newArr = flipCol(arr, arg3);
        }

        if(arg4.equals("s")) {
             int[] row = getRow(newArr, arg6);
             row = shiftLeft(row);
             newArr = returnArr(newArr, row, arg6);
         } else if(arg4.equals("f")) {
             newArr = flipCol(newArr, arg6);
         }
        return newArr;
    }

    /**
     * readFile takes in the square.txt file and converts it into a 2-D Array.
     * @param  myFile text file that contains the integers that make the 2-D array. The first int is ignored
     * @return        returns the 2-D array that will be used by the rest of the program.
     */
    public static int[][] readFile(Scanner myFile) {
        int[][] newArr = new int[5][5];
        int row = 0;
        String[] line;
        myFile.nextLine();
        while(myFile.hasNextLine()) {
            line = myFile.nextLine().split(" ");
            for(int i = 0; i < 5; i++) {
                newArr[row][i] = Integer.parseInt(line[i]);
            }
            row++;
        }
        return newArr;
    }
    
    /**
     * getRow will get the specific row that the user wants to manipulate
     * @param  arr 2-D array that is to be used
     * @param  row number of the row that the user wants
     * @return     returns the row as a single array that can then be shifted or flipped.
     */
    public static int[] getRow(int[][] arr, int row) {
      int[] newRow = new int[arr.length];
      for(int i = 0; i < arr.length; i++) {
         if(i == row - 1) {
            for(int j = 0; j < arr[i].length; j++) {
               newRow[j] = arr[i][j];
            }
         }
      }
      return newRow;
    }

    /**
     * returnArr is used to re-insert a single array back into the 2-D array
     * @param  arr    2-D array that the single array will be put into.
     * @param  rowArr Single array that is to be put into the 2-D array.
     * @param  rowNum number of the row that the user wants to replace
     * @return        returns the completed array after it has been shifted
     */
    public static int[][] returnArr(int[][] arr, int[] rowArr, int rowNum) {
        int[][] newArr = new int[arr.length][arr.length];
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                if(i == rowNum - 1) {
                    newArr[i][j] = rowArr[j];
                } else {
                    newArr[i][j] = arr[i][j];
                }
            }
        }
        return newArr;
    }

    /**
     * flipCol swaps the top and bottom values in a column that the user selects
     * @param  arr       2-D array that is to be manipulated
     * @param  colChoice Column that the user wants to flip
     * @return           2-D array that has the selected column flipped.
     */
    public static int[][] flipCol(int[][] arr, int colChoice) {
        int[][] newArr = new int[arr.length][arr.length];
        int col = colChoice - 1;
        int temp = arr[0][col];
        arr[0][col] = arr[arr.length - 1][col];
        arr[arr.length - 1][col] = temp;

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                newArr[i][j] = arr[i][j];
            }
        }
        return newArr;
    }

    /**
     * shiftLeft moves all the values of a single array one spot to the left.
     * The first value of the array is then moved to the back.
     * @param  arr single array that will be shifted
     * @return     single shifted array
     */
    public static int[] shiftLeft(int[] arr) {
        int[] newRow = new int[arr.length];
        int first = arr[0];
        for(int i = 0; i < arr.length - 1; i++) {
            newRow[i] = arr[i + 1];
        }
        newRow[newRow.length - 1] = first;
        return newRow;
    }

}









