/**
* Homework 4
* Practicing for loops
* The user will enter a 7 digit number and a formula will run to check it the 7 digit is valid or not.
* https://github.com/harberg/csc_142/H4/
*/

import java.util.Scanner;

public class H4_nicholas {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      int digits, curTotal = 0, compNum, lastDigit;
      String s, pass;
      
      System.out.println("Please enter a 7 digit number: ");
      
      digits = scan.nextInt();
      s = Integer.toString(digits);
      lastDigit = Character.getNumericValue(s.charAt(6));
      
      for(int i = 0; i < s.length(); i++) {
         curTotal += (i * i);
      }
      compNum = curTotal % 10;
      pass = lastDigit == compNum ? "valid" : "invalid";
      
      System.out.println("The ID you entered is " + pass + ".");
   }
}
