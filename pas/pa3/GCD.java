// GCD.java
// Spencer Albrecht
// 1488178
// Programming Assignment 3
// Finds the greatest common divisor of two numbers

import java.util.Scanner;

public class GCD{

    public static void main(String[] args) {

        int num1 = 0;
        int num2 = 0;
        int input1 = 0;
        int input2 = 0;
        int[] inputArray = new int[2];
        int temp = 0;
        int smallNum,bigNum;
        int quotient = 0;
        int remainder = 0;
        boolean validNum = true;

        Scanner input = new Scanner(System.in);



        for (int i = 0; i < 2; i++) {
          if (i == 0) {
            System.out.print("Enter a positive integer: ");
          }
          else {
            System.out.print("Enter another positive integer: ");
          }

          while (true) {
              // While loop that gets the first number
              while (!input.hasNextInt() || !validNum) {
                  // Throw away the token
                  input.next();
                  System.out.print("Please enter a positive integer: ");
              }

              inputArray[i] = input.nextInt();
              if (inputArray[i] > 0) {
                  validNum = true;
                  break;
              }
              System.out.print("Please enter a positive integer: ");
          }
          validNum = true;
        }


        // Save the order the numbers were entered for end print statements
        input1 = inputArray[0];
        input2 = inputArray[1];

        // Set num1 to the larger number and num2 to the smaller number
        bigNum = Math.max(input1,input2);
        smallNum = Math.min(input1,input2);
        num1 = bigNum;
        num2 = smallNum;

        // Loop that actually performs the Euclidean algorithm
        do {
            quotient = num1/num2;
            //System.out.println("\nThe quotient is "+quotient);
            remainder = num1%num2;
            //System.out.println("The remainder is "+remainder);
            num1 = num2;
            //System.out.println("Number 1 is now "+num1);
            num2 = remainder;
            //System.out.println("Number 2 is now "+num2);
        } while (remainder!=0);


        System.out.println("The GCD of "+input1+" and "+input2+" is "+num1);

    }

}
