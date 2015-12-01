// Roots.java
// Spencer Albrecht
// salbrech (1488178)
// pa4
// Finds the roots of a polynomial

import java.util.Scanner;
import java.util.Arrays;

public class Roots {
  public static void main(String[] args) {
    double resolution = 0.01;
    double tolerance = 0.0000001;
    double threshold = 0.001;
    double root, value1, value2, d_value1, d_value2, placeHolder = 0.0;
    int degree;
    boolean rootFound = false;
    double l_endpoint, r_endpoint;
    double[] coefficients, derivative;
    Scanner sc = new Scanner(System.in);

    //Gets all information from the user about the polynomial
    System.out.print("Enter the degree: ");
    degree = sc.nextInt();
    coefficients = new double[degree+1];
    System.out.print("Enter "+(degree+1)+" coefficients: ");
    for (int i=0; i<=degree; i++) {
      coefficients[i] = sc.nextDouble();
    }
    System.out.print("Enter the left and right endpoints: ");
    l_endpoint = sc.nextDouble();
    r_endpoint = sc.nextDouble();

    // Prints an empty line before the roots are shown to add
    // to the readability of the program output
    System.out.println("");

    derivative = diff(coefficients);
    // Start at the left endpoint and test every interval of width
    // resolution for a zero of the function
    placeHolder = l_endpoint;
    while (placeHolder <= r_endpoint) {
      // Assigns first and second value of function based on
      // coefficient array
      value1 = poly(coefficients, placeHolder);
      value2 = poly(coefficients, placeHolder+resolution);

      // Assigns first and second value of function based on
      // derivative array
      d_value1 = poly(derivative, placeHolder);
      d_value2 = poly(derivative, placeHolder+resolution);

      // Tests sign change of values within interval of polynomial
      if ((value1*value2)<0) {
        //System.out.println("Sign change was detected in polynomial");
        root = findRoot(coefficients, placeHolder, placeHolder+resolution, tolerance);
        rootFound = true;
        System.out.print("Root found at ");
        System.out.printf("%.5f%n",root);
      }
      // Tests sign change of values within interval of derivative
      else if ((d_value1*d_value2)<0) {
        // System.out.println("Sign change was detected in derivative ");
        root = findRoot(derivative, placeHolder, placeHolder+resolution, tolerance);
        // Tests if the function value of the root is close enough
        // to zero to be considered a root. This is done to negate
        // the effects of round off error
        if (Math.abs(poly(coefficients,root)) < threshold) {
          rootFound = true;
          System.out.print("Root found at ");
          System.out.printf("%.5f%n",root);
        }
      }
      // Adds the length of the interval to the placeHolder value
      // to move onto the next interval
      placeHolder+=resolution;
    }

    if (!rootFound) {
      System.out.println("No roots were found in the specified range.");
    }


  }

  // Method that returns the value of the polynomial
  // with input x
  static double poly(double[] C, double x) {
    double sum = 0;
    for (int i = 0; i<C.length; i++) {
      sum += C[i]*Math.pow(x,i);
    }
    return sum;
  }
  // Method that returns a derivative array of a
  // coefficient function
  static double[] diff(double[] C) {
    double[] derivative = new double[C.length-1];
    for (int i = 1; i<C.length; i++) {
      derivative[i-1] = C[i]*i;
    }
    //System.out.print("The derivative array is: ");
    //System.out.println(Arrays.toString(derivative));
    return derivative;
  }
  // Finds the roots of a polynomial within the interval of a and b
  static double findRoot(double[] C, double a, double b, double tolerance) {
    // Precondition for checking whether the endpoints have opposite signs
    // if (!sameSign(poly(C, a), poly(C, b))) {}
    double xVal = 0.0;
    double yVal;
    //System.out.println("The findroot function is running :D");
    //System.out.println("A-b is equal to "+(a-b));
    // Runs until the width of the interval is smaller than
    // a predefined distance
    while ( b-a >= tolerance) {
      xVal = (b+a)/2.0;
      // Calculates the function value in the polynomial
      yVal = poly(C, xVal);
      //System.out.println("The value of the function at "+xVal+" is: "+yVal);
      // If there is a sign change between a and the x-value of the
      // function then shorten the interval by setting b to the x-value
      if (poly(C, xVal)*poly(C,a) < 0) {
        b = xVal;
      }
      else {
        a = xVal;
      }
    }
    //System.out.println("The values of a and b are "+a+" "+b);
    return xVal;
  }
}
