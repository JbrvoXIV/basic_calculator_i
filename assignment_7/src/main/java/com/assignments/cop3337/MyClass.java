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
      Stack<Integer> operandStack = new Stack<Integer>();
      
      while(true){
        System.out.printf("\nPlease enter a new expression OR enter DONE to conclude program: ");
        String exp = s.nextLine();
        
        if(exp.equals("DONE")) {
          break;
        }
        
        int result = 0;
        int operator = 1;

          for(int cur = 0; cur < exp.length(); cur++){
              if(exp.charAt(cur) == '+') {
                  operator = 1;
              } else if (exp.charAt(cur) == '-') {
                  operator = -1;
              } else if(exp.charAt(cur) == '(' ) {
                  operandStack.add(result);
                  operandStack.add(operator);
                  result = 0;
                  operator = 1;
              } else if(exp.charAt(cur) == ')') {
                  result *= operandStack.pop();
                  result += operandStack.pop();
              } else if (Character.isDigit(exp.charAt(cur))) {
                  int num = getOp(exp, cur);
                  while(cur < exp.length() && Character.isDigit(exp.charAt(cur))) {
                    cur++;
                  }
                  result += num * operator;
                  cur--;
              } else {
                  s.close();
                  throw new Exception("Error: bad input");
                }
              }
              System.out.printf("The result is: %d\n", result);
        }
        s.close();
    }
}

