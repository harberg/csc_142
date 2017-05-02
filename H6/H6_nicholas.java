import java.util.Scanner;
/**
* A program that takes in two base 10 numbers and then converts them to base 14.
* In the base 14 system 10 = A, 11 = J, 12 = Q, and 13 = K.
* This program helps to practive loops, text processing, and modular design
* @see <a href="https://github.com/harberg/csc_142">Github Repo</a>
*/
public class H6_nicholas {

   /**
   * Main method for the base 14 number converter
   * The method prompts the user for two seperate base 14 numbers (input1 and input2).
   * It then calls numConvSum for adding the numbers together. numConvProd is also called for finding the product of the numbers.
   * The sum and product are then passed into tenTo14 to be converted to base 14 numbers. 
   * Finally, the sum is passed into base14 to check for the existence of letters.
   */
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
   
      String input1;
      String input2;
      int sum, product;
            
      System.out.println("Enter in two 14 base numbers: ");
      input1 = scan.next();
      input2 = scan.next();
      
      sum = numConvSum(input1, input2);
      product = numConvProd(input1, input2);
      
      base14(tenTo14(sum));
      System.out.println("The product of the two numbers is: " + tenTo14(product) + ".");
   }
   
   /**
   * Turns the two numbers into four digits and then finds their sum.
   * @param num1 The first user passed number
   * @param num2 The second user passed number
   * @return Sum of digits as an Int
   */
   public static int numConvSum(String num1, String num2) {
      String digit1, digit2, digit3, digit4;
      int sum;
      
      digit1 = String.valueOf(num1.charAt(0));
      digit2 = String.valueOf(num1.charAt(1));
      digit3 = String.valueOf(num2.charAt(0));
      digit4 = String.valueOf(num2.charAt(1));
      
      sum = sum(Integer.parseInt(digit1), Integer.parseInt(digit2), Integer.parseInt(digit3), Integer.parseInt(digit4));
      
      return sum;      
   }
   
   /**
   * Turns the two numbers given by the user into four digits and then finds their product.
   * @param num1 The first user passed number
   * @param num2 The second user passed number
   * @return Product of the digits as an Int
   */
   public static int numConvProd(String num1, String num2) {
      String digit1, digit2, digit3, digit4;
      int product;
      
      digit1 = String.valueOf(num1.charAt(0));
      digit2 = String.valueOf(num1.charAt(1));
      digit3 = String.valueOf(num2.charAt(0));
      digit4 = String.valueOf(num2.charAt(1));
      
      product = prod(Integer.parseInt(digit1), Integer.parseInt(digit2), Integer.parseInt(digit3), Integer.parseInt(digit4));
      
      return product;      
   }
   
   /**
   * Finds the sum of two base 14 numbers. Calls the sum() method.
   * @param num1 Number in first position of the first number
   * @param num2 Number in second position of the first number
   * @param num3 Number in first position of the second number
   * @param num4 Number in second position of the second number
   * @return Sum of the four numbers
   */
   public static int sum(int num1, int num2, int num3, int num4) {
     int sum;
     
     sum = ((num1 * 14) + (num2 * 1) + (num3 * 14) + (num4 * 1));
    
     return sum;     
   }
   
   /**
   * Finds the product of two base 14 numbers. Calls the prod() method.
   * @param num1 Number in first position of the first number
   * @param num2 Number in second position of the first number
   * @param num3 Number in first position of the second number
   * @param num4 Number in second position of the second number
   * @return Product of the four numbers
   */
   public static int prod(int num1, int num2, int num3, int num4) {
      int product;
      
      product = ((num1 * 14) + (num2 * 1)) * ((num3 * 14) + (num4 * 1));
      
      return product;
   }
   
   /**
   * Turns a base 10 number into a base 14 number
   * The method uses recursion to find the answer
   * @param num Number passed in to be converted
   * @return String that is the base 14 number 
   */
   public static String tenTo14(int num) {
      int quotient = num/14;
      int remainder = num % 14;
      
      if(quotient == 0) {
         return Integer.toString(remainder);  
      } else {
         return tenTo14(quotient) + Integer.toString(remainder);
      }
   }
   
   /**
   * Takes a base 14 number and checks to see if there are any letters that need to be applied.
   * Calls the converter() method
   * @param num14 Takes a base 14 number
   */
   public static void base14(String num14) {
      int fullInt = Integer.parseInt(num14);
      String answerOne, answerTwo;
      try {
         answerOne = num14.substring(0,2);
         answerTwo = num14.substring(2,4);
      } catch (StringIndexOutOfBoundsException e) {
         answerOne = num14.substring(0,2);
         answerTwo = num14.substring(2,3);
      }
      
      
      answerOne = converter(answerOne);
      answerTwo = converter(answerTwo); 
      
      System.out.println("The Sum of the two numbers is: " + answerOne + answerTwo + ".");
   }
   /**
   * Changes certain double digit numbers into letters for full conversion into base 14
   * @param num Pass in a number to see if it matches any of the cases, if not it remains itself
   * @return String that may be a letter of number
   */
   public static String converter(String num) {
      switch(num) {
         case "10": num = "A";
            break;
         case "11": num = "J";
            break;
         case "12": num = "Q";
            break;
         case "13": num = "K";
            break;
         default: num = num;
            break;
      }
      return num;   
   }
}