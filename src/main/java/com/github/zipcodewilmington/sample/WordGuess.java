package com.github.zipcodewilmington.sample;

import java.util.Random;
import java.util.Scanner;

public class WordGuess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean playAgain = true;   //setting playAgain to "true".

        while (playAgain) {
            playGame(scanner);

            System.out.print("Would you like to play again? (yes/no): ");
            String playChoice = scanner.next();
            playAgain = playChoice.equalsIgnoreCase("yes");
        }

        System.out.println("\nThanks for playing Fishing Word Guess 1.0!");
        scanner.close();

    }

        public static void playGame(Scanner scanner){

        String[] randWords = {"fish", "rod", "bait", "hook", "line", "bass", "carp", "leader", "crankbait", "crappie"}; //array of random fishing words.

        Random random = new Random();

        int maxTries = 6;   //Max # of user tries.
        int numTries = 0;   //Current # of user tries

        String fishingWord = randWords[random.nextInt(randWords.length)];
        char[] solution = fishingWord.toCharArray();
        char[] playerGuesses = new char[solution.length];
            for (int i = 0; i < playerGuesses.length; i++) {    //Puts a _ for every letter in "fishingWord".
                playerGuesses[i] = '_';
            }

        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n" + "Let's Play Fishing WordGuess version 1.0!\n" + "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.print("You have a maximum of [" + maxTries + "] guesses!\n");     //tells user maximum tries.
                
        while (numTries < maxTries) {
            
            System.out.println("\nYour word has [" + playerGuesses.length + "] letters: ");
            for(char userGuess : playerGuesses) {
                System.out.print(userGuess + " ");
            }

            int currentNum = maxTries - numTries;   //takes maxTries(6) - numTries = gives user how many tries they have left.

            System.out.println("\nYou have [" + currentNum + "] tries left.");    //tells user how many tries they have left.

            System.out.print("Enter a letter or '-' to end the program: ");

            char letter = scanner.next().charAt(0);     //user input guess.

                if(letter == '-') {     //Option for user to quit the game.
                    System.out.print("Quitting the game... Thanks for playing.\n");
                    break;
                }
                
                boolean found = false;  //boolean "found" is set to false.

                for (int i = 0; i < solution.length; i++) {
                    
                    if (solution[i] == letter) {    //if users attempt is correct.
                        playerGuesses[i] = letter;
                        found = true;
                        System.out.print("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
                    }
                }
                
                if (!found) {   //if users attempt is incorrect.
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\nThat letter was Incorrect.");
                    numTries++;
                }
                
                if (String.valueOf(playerGuesses).equals(fishingWord)) {    //if user guesses the word.
                    System.out.println("Congratulations! You've guessed the word: " + fishingWord + "\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
                    break;
                }
                
            }

            if (numTries == maxTries) {     //if user runs out of guesses.
                System.out.println("You Lost! You ran out of guesses!\n" + "The word was: " + fishingWord);
            }

    }
                
                

}


