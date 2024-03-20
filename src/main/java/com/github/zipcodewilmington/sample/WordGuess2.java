package com.github.zipcodewilmington.sample;

import java.util.Random;
import java.util.Scanner;

public class WordGuess2 {
    public static Scanner scan = new Scanner(System.in);
    public static Random random = new Random();
    public static int maxNumberOfTries = 6;
    public static int numberOfTries = 0;
    public static String[] randomWords = {"code", "java", "line", "wordguess", "maven"};
    public static char[] solution;
    public static char[] playerGuesses;
    public static int currentNumberOfTries;
    public static char letter;
    public static boolean found = false;



    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
        while (true) {
            if (playSelect().equals("no")) {
                endGame();
                break;
            }

            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n" + "Let's Play Fishing WordGuess version 1.0!\n" + "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

            generateRandomWord();
            randomWordSpaces();
            numberOfTries = 0;

            System.out.print("You have a maximum of [" + maxNumberOfTries + "] guesses!\n");     //tells user maximum tries.

            while (numberOfTries < maxNumberOfTries) {

                gameDisplay();

                correctGuess();
                wrongGuess();

                quitingTheGame();

                if (numberOfTries == maxNumberOfTries || String.valueOf(playerGuesses).equals(String.valueOf(solution))){
                    winningGame();
                    outOfTries();
                }
            }
        }
    }

    public static String playSelect() {
        System.out.println("Would you like to play WordGuess 2.0? [Yes/No]");
        return scan.next().toLowerCase();
    }

    public static void generateRandomWord() {
        String codingWord = randomWords[random.nextInt(randomWords.length)];
        solution = codingWord.toCharArray();
    }

    public static void randomWordSpaces() {
        playerGuesses = new char[solution.length];
            for (int i = 0; i < playerGuesses.length; i++) {    //Puts a _ for every letter in "fishingWord".
                playerGuesses[i] = '_';

        }
    }

    public static void gameDisplay() {
        found = false;
        System.out.println("\nYour word has [" + playerGuesses.length + "] letters: ");

        for (char userGuess : playerGuesses) {
            System.out.print(userGuess + " ");
        }

        currentNumberOfTries = maxNumberOfTries - numberOfTries;

        System.out.println("\nYou have [" + currentNumberOfTries + "] tries left.");    //tells user how many tries they have left.

        System.out.print("Enter a letter or '-' to end the program: ");

        letter = scan.next().charAt(0);     //user input guess.
    }

    public static void correctGuess() {

        for (int i = 0; i < solution.length; i++) {
            if (solution[i] == letter) {    //if users attempt is correct.
                playerGuesses[i] = letter;
                found = true;
            }
        }
        if (found) {
            System.out.println("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n" +
                    "Correct guess! '" + letter + "' is in the word.\n" +
                    "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        }
    }

    public static void wrongGuess() {
        if (!found) {   //if users attempt is incorrect.
            System.out.println("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n\nThat letter was Incorrect.");
            numberOfTries++;
        }
    }

    public static void winningGame() {
        if (String.valueOf(playerGuesses).equals(String.valueOf(solution))) {    //if user guesses the word.
            System.out.println("Congratulations! You've guessed the word: " + String.valueOf(solution) + "\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
        }
        playAgain();
    }

    public static void quitingTheGame() {
        if (letter == '-') {     //Option for user to quit the game.
            System.out.print("Quitting the game... Thanks for playing.\n");
            endGame();
        }
    }

    public static void outOfTries() {
        if (numberOfTries == maxNumberOfTries) {     //if user runs out of guesses.
            System.out.println("You Lost! You ran out of guesses!\n" + "The word was: " + String.valueOf(solution));
            playAgain();
        }
    }

    public static void playAgain() {
        System.out.println("Would you like to play again? [Yes/No]");
        String playAgain = scan.next();
        if (playAgain == "no"){
            endGame();
        }
        playGame();
    }

    public static void endGame() {
        System.out.println("Thank you for playing!\n");
    }

}
