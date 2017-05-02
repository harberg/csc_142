import java.util.Scanner;
/**
   A program that takes in two base 10 numbers and then converts them to base 14.
   In the base 14 system 10 = A, 11 = J, 12 = Q, and 13 = K.
   This program helps to practive loops, text processing, and modular design
*/
public class H6_nicholas {
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
   
   public static int sum(int num1, int num2, int num3, int num4) {
     int sum;
     
     sum = ((num1 * 14) + (num2 * 1) + (num3 * 14) + (num4 * 1));
    
     return sum;     
   }
   
   public static int prod(int num1, int num2, int num3, int num4) {
      int product;
      
      product = ((num1 * 14) + (num2 * 1)) * ((num3 * 14) + (num4 * 1));
      
      return product;
   }
   
   public static String tenTo14(int num) {
      int quotient = num/14;
      int remainder = num % 14;
      
      if(quotient == 0) {
    
         return Integer.toString(remainder);  
      } else {
         return tenTo14(quotient) + Integer.toString(remainder);
      }
   }
   
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