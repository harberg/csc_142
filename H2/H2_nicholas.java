/**
* Homework 2
* Practicing basic I/O using sales tax
*/

import java.util.Scanner;

public class H2_nicholas {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      double state_tax = 0.085;
      double county_tax = 0.025;
      double purchase;
      double state_total;
      double county_total;
      double total_tax;
      double total_purchase;
      
      System.out.println("You bought something? \nIf you tell me how much you paid for it, I can tell you how much you paid in sales tax."); 
      System.out.print("How much did you pay for it? (numbers only please): ");
      purchase = scan.nextDouble();
      state_total = purchase * state_tax;
      county_total = purchase * county_tax;
      total_tax = county_total + state_total;
      total_purchase = purchase + total_tax;
      System.out.println("You payed $" + purchase + " for it.");   
      System.out.println("You payed $" + state_total + " in state sales tax.");  
      System.out.println("You payed $" + county_total + " in county sales tax.");
      System.out.println("You payed a total of $" + total_tax + " in combined sales tax.");
      System.out.println("Bringing your grand total to $" + total_purchase + ".");
   }
}