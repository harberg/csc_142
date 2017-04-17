/**
* Homework 3
* Practicing basic I/O using month and years.
* Returns the number of days in the month submited by the user.
* https://github.com/harberg/csc_142/H3/
*/

import java.util.Scanner;

public class H3_nicholas {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      int monthNum;
      int year;
      int daysInMonth = 0;
      String monthName;
      
      System.out.println("Please enter a month and a year (in the common era and not in the future), both as numbers: ");
      monthNum = scan.nextInt();
      year = scan.nextInt();
      
      if(year > 0 && year < 2019) {
         switch(monthNum) {
            case 1: monthName = "January"; daysInMonth = 31;
               break;
            case 2: 
               monthName = "February"; 
               if( ((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0) ) {
                  daysInMonth = 29;
               } else {
                  daysInMonth = 28;
               }
               break;
            case 3: monthName = "March"; daysInMonth = 31;
               break;
            case 4: monthName = "April"; daysInMonth = 30;
               break;
            case 5: monthName = "May"; daysInMonth = 31;
               break;
            case 6: monthName = "June"; daysInMonth = 30;
               break;
            case 7: monthName = "July"; daysInMonth = 31;
               break;
            case 8: monthName = "August"; daysInMonth = 31;
               break;
            case 9: monthName = "September"; daysInMonth = 30;
               break;
            case 10: monthName = "October"; daysInMonth = 31;
               break;
            case 11: monthName = "November"; daysInMonth = 30;
               break;
            case 12: monthName = "December"; daysInMonth = 31;
               break;
            default: monthName = "error";
               break;
         }   
         if(monthName == "error") {
            System.out.println(monthNum + " isn't between the numbers 1 and 12.");
         } else {
            System.out.println("The month of " + monthName + " in the year " + year + " has " + daysInMonth + " days in it.");
         }
      } else {
         System.out.println("You entered a year that wasn't in the common era.");
      }
   }
}
