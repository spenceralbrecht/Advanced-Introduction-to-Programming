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
        int temp = 0;
        int smallNum,bigNum;
        int quotient = 0; 
        int remainder = 0;
        boolean validNum = false;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");

        for (int i = 0; i < 2; i++) {
            // Runs if the number the user entered is not a positive int
            while (!validNum) {

                if (input.hasNextInt()) {
                    temp = input.nextInt();
                    // If the correct input is entered, store it in num1 or num2
                    // based on whether num1 has already been assigned
                    if (temp >= 0) { 
                        validNum = true;
                        if (num1 == 0) {
                            num1 = temp; 
                        }
                        else {
                            num2 = temp;
                        } 
                        break;
                    }
                }

                // Prompt for if the first number entered was not a positive int      
		System.out.print("Please enter a positive integer: ");
                input.next();
	
            } 
            if (num2 == 0) {
                // Prompt for if the second number entered was not a positive int
                System.out.print("Please enter another positive integer: ");
                validNum = false; 
            }
        }

        // Save the order the numbers were entered for end print statements
        input1 = num1;
        input2 = num2;

        // Set num1 to the larger number and num2 to the smaller number
        bigNum = Math.max(num1,num2);
        smallNum = Math.min(num1,num2);
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
