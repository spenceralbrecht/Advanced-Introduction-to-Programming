// Queens.java
// Spencer Albrecht
// salbrech (1488178)
// pa5
// Returns a queen arrangement where no queens interefere with each other

import java.util.Scanner;

class Queens {
  public static void main(String[] args) {
    int n = -1;
    int solutionCounter = 0;
    int[] queenOrder;
    boolean shouldRun = false;
    boolean verbose = false;

    // Exits if the length of the inputs are wrong
    if (args.length == 0 || args.length > 2) {
      System.out.println("Usage: Queens [-v] number");
      System.out.println("Option: -v verbose output, print all solutions");
      System.exit(1);
    }

    // Trys to check if the input is in the correct format
    try {
      if (args.length == 1) {
        try {
          Integer.parseInt(args[0]);
          System.out.println(Integer.parseInt(args[0]));
          n  = Integer.parseInt(args[0]);
          shouldRun = true;
        }
        catch (NumberFormatException e) {

        }
      }
      else if (args.length == 2) {
        n  = Integer.parseInt(args[1]);
        if (args[0].equals("-v")) {
          if (n >= 0) {
            shouldRun = true;
            verbose = true;
          }
        }
      }
    }
    // Exits if an exception was thrown
    catch (NumberFormatException e) {
      System.exit(0);
    }

    // Exits if anything with the input was wrong
    if (!shouldRun) {
      System.out.println("Usage: Queens [-v] number");
      System.out.println("Option: -v verbose output, print all solutions");
      System.exit(0);
    }

    // Actually runs the Queens program
    int numCombinations = calcFactorial(n);
    queenOrder = createArray(n);
    for (int i = 0; i < numCombinations; i++) {
      if (isSolution(queenOrder)) {
        if(verbose)
          printArray(queenOrder);
        solutionCounter++;

      }
      nextPermutation(queenOrder);
    }
    System.out.println(n+"-Queens has "+solutionCounter+" solutions");
  }

  // Calculates the number of unique permutations
  static int calcFactorial(int n) {
      int sum = 1;
      for (int i = n; i > 0; i--) {
        sum*=i;
      }
      return sum;
  }

  // Creates the first permutation of the sequence
  static int[] createArray(int n) {
    int[] array = new int[n+1];
    for (int i = n; i >= 0; i--) {
      array[i] = i;
    }
    return array;
  }

  // Generates the next unique permutation in lexigraphical
  static void nextPermutation(int[] A) {
    int pivot = 0;
    int pivotIndex = 0;
    int successor = 0;
    int successorIndex = 0;
    boolean pivotFound = false;

    for (int i = A.length-1; i > 1; i--) {
      if (A[i-1] < A[i]) {
        pivot = A[i-1];
        pivotIndex = i-1;
        pivotFound = true;
        break;
      }
    }

    if (!pivotFound) {
      reverse(A, 1);
      return;
    }

    for (int i = A.length-1; i > 0; i--) {
      if (A[i] > pivot) {
        successor = A[i];
        successorIndex = i;
        break;
      }
    }
    swap(A, pivotIndex, successorIndex);
    //System.out.println("The value of the pivot is "+pivot);
    reverse(A, pivotIndex+1);
  }

  // Returns true if the input array is a solution to Queens
  static boolean isSolution(int[] A) {
    for (int i = 1; i < A.length-1; i++) {
      for (int j = i+1; j <= A.length-1; j++) {
        //System.out.println("i = "+i+" j = "+j);
        if (Math.abs(j-i) == Math.abs(A[j]-A[i])) {
          return false;
        }
      }
    }
    return true;
  }

  static void swap(int[] Q, int i, int j){
      int temp = Q[i];
      Q[i] = Q[j];
      Q[j] = temp;
   }

  static void reverse(int[] T, int s){
      int i=s, j=T.length-1;
      while(i<j){
         swap(T, i, j);
         i++;
         j--;
      }
   }

  static void printArray(int[] P){
    System.out.print("(");
    for(int i=1; i<P.length; i++){
      if (i != P.length-1) {
        System.out.print(P[i]+", ");
      }
      else {
        System.out.print(P[i]);
      }
    }
    System.out.println(")");
  }

}
