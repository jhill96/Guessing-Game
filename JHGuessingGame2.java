// Programmer: Jonathan Hill
// Class: CS 141
// Date: 11/8/21
// Assignment: Lab 4 (Guessing Game)
// Purpose:  This program will introduce a number guessing game to the user
// and let the player know if there guess is higher or lower.  When the player
// guesses correctly the game lets the player know that the guess was correct
// and how many tries it took.  The player can play as many games as they like
// and when they're done the program will give them some stats about the games they
// played.
// For extra credit I used printf in my program.

import java.util.Scanner;
import java.util.*;

public class JHGuessingGame2 {  // Start of JHGuessingGameclass

   public static void main(String[] args) { // Start of main
   
      Scanner input = new Scanner(System.in);  // Import scanner
   //   Scanner g = new Scanner(System.in);
   
      // Define variables
      int range = 100;
      double bestGuess = 10000000;
      double gamesPlayed = 0;
      double numTries = 0;
      double totalGuesses = 0;
      String word  = "y";
      instructions();  // Introduces the game.
   
      // Will run the game as many times as the user wants.
      while (word.equalsIgnoreCase("y") || word.equalsIgnoreCase("yes")) { // Start of while loop
         numTries = playGame(input, range);
         totalGuesses += numTries;
         if (numTries < bestGuess) {
            bestGuess = numTries;
         } // End of if statement
         System.out.printf("%s%n" ,"Would you like to play again?");
         System.out.printf("%s" , "Type y to play again and n to quit ");
         word = input.next();
         gamesPlayed++;
      } // End of while loop
   
      // Reports the over all results.
      overAllResults(totalGuesses, gamesPlayed, bestGuess);
   
   } // end of main method
   
   // instruction method gives the user instructions on what the game is and how it's played.
   public static void instructions() {
      System.out.println("This program allows you to play a guessing game.");
      System.out.println("I will think of a number between 1 and");
      System.out.println("100 and will allow you to guess until");
      System.out.println("you get it. For each guess, I will tell you");
      System.out.println("whether the right answer is higher of lower");
      System.out.println("then your guess.");
   } //end of instructions method
   
   public static double playGame(Scanner input, int range) { // play one game with the user
      // Computer thinks of a number 1 and range and allows the user to guess until they guess correct.
      double guess = -1;
      double numTries = 0;
      boolean again = true;
      Random rand = new Random();
      int randomNumber = rand.nextInt(range) + 1;
      System.out.printf("%s%n" , "I'm thinking of a number between 1 and 100...");
      while (again) {
         try {
            System.out.printf("%s" , "Your guess? ");
            // I'm thinking of a number between 1 and range
            // get a response and save guuss
            guess = input.nextDouble();
            again = false;
            numTries++;
         }  catch (InputMismatchException ex) {
            System.out.println("This is an invalid entry, please enter a number.");
            input.next();
         }
      }     
    
      while(guess != randomNumber) { // Start of while loop
         again = true;
         while (again) {
            try { 
               if (guess > randomNumber) {
                  System.out.printf("%s%n" , "It's lower");
                  System.out.printf("%s" , "Your guess? ");
                  guess = input.nextDouble();
                  again = false;
                  numTries++;
               } else { 
                  System.out.printf("%s%n" , "It's higher");
                  System.out.printf("%s" , "Your guess? ");
                  guess = input.nextDouble();
                  again = false;
                  numTries++;
               } // End of if/else
            } catch (InputMismatchException ex) {
               System.out.println("This is an invalid entry, please enter a number.");
               input.next();
            }
         } //End of nexted while loop    
      } // End of while loop
                
      if (numTries == 1) {
         System.out.printf("%s%.0f%s%n" , "Congratulations, you got it in " , numTries , " guess.");  
      } else {
         System.out.printf("%s%.0f%s%n" , "Congratulations, you got it in " , numTries , " guesses.");
      } // End of if/else
      return numTries;
      
   
   } // end of playGame method

  // Start of overAllResults method.
   public static void overAllResults(double totalGuesses, double gamesPlayed, double bestGuess) {
      double guessGame = totalGuesses/gamesPlayed;
      System.out.printf("%n%s%.0f%n" , "Total guesses = " , totalGuesses);
      System.out.printf("%s%.0f%n" , "Games played = " , gamesPlayed);
      System.out.printf("%s%.1f%n" , "Guesses/Game = " , guessGame);
      System.out.printf("%s%.0f%n" , "Best Score = " , bestGuess);
   } // End of overAllResults method.
}  // End of JHGuessingGame class