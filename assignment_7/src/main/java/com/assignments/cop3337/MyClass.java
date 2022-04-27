package com.assignments.cop3337;

import java.util.*;

public class MyClass {

    private static int getOp(String exp, int cur){
        Scanner s = new Scanner(exp.substring(cur));
        s.useDelimiter("[^0-9]");
        return s.nextInt();
    }

    public static void main(String args[]) throws Exception{

      Scanner s = new Scanner(System.in);
      
      while(true){
          System.out.println("Please enter a new expression: ");
          String exp = s.nextLine();

          if(exp.equals("DONE")) {
            break;
          }

          int result = 0;
          boolean add = true;//if false, means subtract

          for(int cur = 0; cur < exp.length(); cur++){
              if(exp.charAt(cur) == '+') {
                add = true;
              } else if (exp.charAt(cur) == '-') {
                add = false;
              } else if (Character.isDigit(exp.charAt(cur))) {
                int operand = getOp(exp, cur);
                while(cur < exp.length() && Character.isDigit(exp.charAt(cur))) {
                  cur++;
                }
                cur--;
                result = add ? result + operand : result - operand;
              } else {
                  throw new Exception("Error: bad input");
              }
          }  
          System.out.println("The result is " + result);
        }
        s.close();
    }
}

