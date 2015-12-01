//Guess.java
//Spencer Albrecht
//1488178
//Programming Assignment 2
//Plays a guessing game with the user 

import java.util.Scanner;

public class Guess{

    public static boolean game_over;

    public static void main(String[] args) {
        int randomNum,user_guess;
        Scanner input = new Scanner(System.in); 

        randomNum = (int) Math.ceil(Math.random()*10);
        //System.out.println(randomNum);

        System.out.println("\n"+"I'm thinking of an integer in the range 1 to 10. You have three guesses.");
        
        System.out.print("\n"+"Enter your first guess: ");
        user_guess = input.nextInt(); 
        compare(user_guess, randomNum);

        if (!game_over) {
            System.out.print("\n"+"Enter your second guess: ");
            user_guess = input.nextInt(); 
            compare(user_guess, randomNum);
        }

        if (!game_over) {
            System.out.print("\n"+"Enter your third guess: ");
            user_guess = input.nextInt(); 
            compare(user_guess, randomNum);

            if (!game_over) {
                System.out.println("\n"+"You lose. The number was "+randomNum+".");
            }
        }
        
    }

    public static void compare(int guess, int actual) {
        if (guess == actual) {
            System.out.println("You win!");
            game_over = true;
        }
        else if (guess < actual) {
            System.out.println("Your guess is too low.");
        }
        else {
            System.out.println("Your guess is too high.");
        }
    }
}