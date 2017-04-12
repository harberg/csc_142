/**
* Homework 1
* Experiments with incredment/decrement
*/

public class H1_nicholas {
   public static void main(String[] args) {
      int x = 3;
      int s = 2;
      double foo = 12.8;
      double bar = 2.9;
      long j = 0;
      
      j = (int)foo * 2;
      System.out.println("j is: " + j);
      j = (int)(foo * 2);
      System.out.println("j is: " + j);
      j = (int)foo * (long)bar;
      System.out.println("j is: " + j);
      j = (long)foo * (int)bar;
      System.out.println("j is: " + j);
      j = (long)(foo * (int)bar);
      System.out.println("j is: " + j);
      
      
       x++;
       System.out.println("x is: " + x);
       System.out.println("s is: " + s);
       x = 7;
       System.out.println("x is: " + x);
       System.out.println("s is: " + s);
       s = x++;
       System.out.println("x is: " + x);
       System.out.println("s is: " + s);
       x = 7;
       System.out.println("x is: " + x);
       System.out.println("s is: " + s);
       s = ++x;
       System.out.println("x is: " + x);
       System.out.println("s is: " + s);
       s = 2 + ++x;
       System.out.println("x is: " + x);
       System.out.println("s is: " + s);
       x = 7;
       System.out.println("x is: " + x);
       System.out.println("s is: " + s);
       s = x--;
       System.out.println("x is: " + x);
       System.out.println("s is: " + s);
       x = 7;
       System.out.println("x is: " + x);
       System.out.println("s is: " + s);
       s = --x;
       System.out.println("x is: " + x);
       System.out.println("s is: " + s);

   }
}