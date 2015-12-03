/* GCD.c
 * Spencer Albrecht
 * 1488178 (salbrech)
 * lab8
 * C Version of GCD.java
 * */
 #include <stdio.h>
 #include <stdlib.h>

 int main() {
    int num1 = 0;
    int num2 = 0;
    int input1 = 0;
    int input2 = 0;
    int inputArray[2];
    int temp = 0;
    int n = 0;
    int i = 0;
    int smallNum;
    int bigNum;
    int quotient = 0;
    int remain = 0;
    int validNum = 1;
    char str[1];

    // Loop that runs twice to get each number for GCD calc.
    for (i; i < 2; i++) {
      if (i == 0) {
        printf("Enter a positive integer: ");
      }
      else {
        printf("Enter another positive integer: ");
      }
      // Runs until a valid number is entered
      while (1) {
          n = scanf(" %d", &temp);
          // While loop that gets the first number
          while( n!=1 ) {
              scanf("%*s", str);
              printf("Please enter a positive integer: ");
              n = scanf(" %d", &temp);
          }
          // "temp" is now gauranteed to be a number
          inputArray[i] = temp;
          // Exit the loop if the number is valid
          if (inputArray[i] > 0) {
            break;
          }
          printf("Please enter a positive integer: ");
      }
    }

    // Save the order the numbers were entered for end print statements
    input1 = inputArray[0];
    input2 = inputArray[1];

    // Set num1 to the larger number and num2 to the smaller number
    if (input1 > input2) {
      bigNum = input1;
      smallNum = input2;
    }
    else {
      bigNum = input2;
      smallNum = input1;
    }

    num1 = bigNum;
    num2 = smallNum;

    // Loop that actually performs the Euclidean algorithm
    do {
        quotient = num1/num2;
        //System.out.println("\nThe quotient is "+quotient);
        remain = num1 % num2;
        //System.out.println("The remainder is "+remainder);
        num1 = num2;
        //System.out.println("Number 1 is now "+num1);
        num2 = remain;
        //System.out.println("Number 2 is now "+num2);
    } while (remain!=0);


    printf("The GCD of %d and %d is %d\n", input1, input2, num1);

    // Return 0 for proper system exit
    return 0;
 }
